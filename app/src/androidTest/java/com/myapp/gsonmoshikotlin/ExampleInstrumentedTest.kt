package com.myapp.gsonmoshikotlin

import androidx.test.InstrumentationRegistry

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.myapp.gsonmoshikotlin", appContext.packageName)
    }
}
