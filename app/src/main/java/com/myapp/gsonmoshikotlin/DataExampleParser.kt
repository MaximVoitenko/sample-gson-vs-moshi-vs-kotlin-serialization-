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

class DataExampleParser {

    private var adapterMoshi: JsonAdapter<List<DataExample>>? = null
    private var gson: Gson? = null

    init {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(MutableList::class.java, DataExample::class.java)
        adapterMoshi = moshi.adapter(type)
        gson = Gson()
    }

    fun parseGson(json: String) = gson?.fromJson<List<DataExample>>(json, List::class.java)

    fun parseKotlin(json: String) = Json.parse(DataExample.serializer().list, json)

    fun parseMoshi(json: String) = adapterMoshi?.fromJson(json)

    fun loadJSONFromAsset(name: String, context: Context): String? {
        val json: String
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

