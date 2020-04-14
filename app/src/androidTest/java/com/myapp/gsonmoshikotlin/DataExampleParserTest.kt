package com.myapp.gsonmoshikotlin

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class DataExampleParserTest{

    private var dataExampleParser = DataExampleParser()
    private val app = InstrumentationRegistry.getInstrumentation().targetContext

    private val shortJson = loadJSONFromAsset("generated_small.json", app)
    private val longJson = loadJSONFromAsset("generated_large.json", app)

    @Test
    fun load_small_json_via_gson() {
        val result = dataExampleParser.parseGson(shortJson!!)
        assert(!result.isNullOrEmpty())
    }

    @Test
    fun load_large_json_via_gson() {
        val result = dataExampleParser.parseGson(longJson!!)
        assert(!result.isNullOrEmpty())
    }

    @Test
    fun load_small_json_via_moshi() {
        val result = dataExampleParser.parseMoshi(shortJson!!)
        assert(!result.isNullOrEmpty())
    }

    @Test
    fun load_large_json_via_moshi() {
        val result = dataExampleParser.parseMoshi(longJson!!)
        assert(!result.isNullOrEmpty())
    }

    @Test
    fun load_small_json_via_kotlin_serialization() {
        val result = dataExampleParser.parseKotlin(shortJson!!)
        assert(!result.isNullOrEmpty())
    }

    @Test
    fun load_large_json_via_kotlin_serialization() {
        val result = dataExampleParser.parseGson(longJson!!)
        assert(!result.isNullOrEmpty())
    }

    private fun loadJSONFromAsset(name: String, context: Context): String? {
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