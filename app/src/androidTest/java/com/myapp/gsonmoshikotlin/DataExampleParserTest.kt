package com.myapp.gsonmoshikotlin

import android.os.Debug
import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.myapp.gsonmoshikotlin.DataExampleParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DataExampleParserTestAndroid {

    private val app = InstrumentationRegistry.getInstrumentation().targetContext
    lateinit var dataExampleParser: DataExampleParser

    @Before
    fun setup() {
        dataExampleParser = DataExampleParser(context = app)
    }

    @Test
    fun load_small_json_via_gson() {
        dataExampleParser.loadSmallJson()
        Debug.startMethodTracing("load_small_json_via_gson")
        dataExampleParser.parseGson()
        Debug.stopMethodTracing()
    }

    @Test
    fun load_large_json_via_gson() {
        dataExampleParser.loadLargeJson()
        Debug.startMethodTracing("load_large_json_via_gson")
        dataExampleParser.parseGson()
        Debug.stopMethodTracing()
    }

    @Test
    fun load_small_json_via_moshi() {
        dataExampleParser.loadSmallJson()
        Debug.startMethodTracing("load_small_json_via_moshi")
        dataExampleParser.parseMoshi()
        Debug.stopMethodTracing()
    }

    @Test
    fun load_large_json_via_moshi() {
        dataExampleParser.loadLargeJson()
        Debug.startMethodTracing("load_large_json_via_moshi")
        dataExampleParser.parseMoshi()
        Debug.stopMethodTracing()
    }

    @Test
    fun load_small_json_via_kotlin_serialization() {
        dataExampleParser.loadSmallJson()
        Debug.startMethodTracing("load_small_json_via_kotlin_serialization")
        dataExampleParser.parseKotlin()
        Debug.stopMethodTracing()
    }

    @Test
    fun load_large_json_via_kotlin_serialization() {
        dataExampleParser.loadLargeJson()
        Debug.startMethodTracing("load_large_json_via_kotlin_serialization")
        dataExampleParser.parseKotlin()
        Debug.stopMethodTracing()
    }

}