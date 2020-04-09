package com.myapp.gsonmoshikotlin

import android.content.Context
import com.google.gson.Gson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class DataExampleParser(private val context: Context) {

    private lateinit var adapterMoshi: JsonAdapter<List<DataExample>>
    private lateinit var gson: Gson

    private var jsonFileStrSmall = ""
    private var jsonFileStrLarge = ""

    init {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(MutableList::class.java, DataExample::class.java)
        adapterMoshi = moshi.adapter(type)
        gson = Gson()
    }

    fun loadSmallJson() = apply {
        jsonFileStrSmall = loadJSONFromAsset("generated_1_000.json") ?: ""
    }

    fun loadLargeJson() = apply {
        jsonFileStrLarge = loadJSONFromAsset("generated_100_000.json") ?: ""
    }

    // parse Json by Moshi
    fun parseMoshi() = apply {
        if (jsonFileStrSmall.isNotBlank())
            adapterMoshi.fromJson(jsonFileStrSmall) ?: emptyList()
        else
            adapterMoshi.fromJson(jsonFileStrLarge) ?: emptyList()
    }

    // parse Json by Gson
    fun parseGson() = apply {
        if (jsonFileStrSmall.isNotBlank())
            gson.fromJson<List<DataExample>>(jsonFileStrSmall, List::class.java)
        else
            gson.fromJson<List<DataExample>>(jsonFileStrLarge, List::class.java)
    }

    fun parseKotlin() = apply {
        if (jsonFileStrSmall.isNotBlank())
            Json.parse(DataExample.serializer().list, jsonFileStrSmall)
        else
            Json.parse(DataExample.serializer().list, jsonFileStrLarge)
    }

    // Get Json from assets
    private fun loadJSONFromAsset(name: String): String? {
        var json: String
        json = try {
            val `is`: InputStream = context.assets.open(name)
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}