package com.myapp.gsonmoshikotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val parser = DataExampleParser()
        var smallJson = ""
        var largelJson = ""

        lifecycleScope.launch(Dispatchers.Default) {
            withContext(Dispatchers.Main) { progress.visibility = View.VISIBLE }
            smallJson = parser.loadJSONFromAsset("generated_small.json", this@MainActivity) ?: ""
            largelJson = parser.loadJSONFromAsset("generated_large.json", this@MainActivity) ?: ""
            withContext(Dispatchers.Main) { progress.visibility = View.GONE }
        }


        gsonSmallBtn.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Default) {
                withContext(Dispatchers.Main) { progress.visibility = View.VISIBLE }
                val start = System.currentTimeMillis() // save start time of parse
                parser.parseGson(smallJson)
                val end = System.currentTimeMillis() // save end time of parse
                Log.d(TAG, "gson small file duration = ${end - start}")
                withContext(Dispatchers.Main) {
                    resultTv.setText("${end - start}")
                    progress.visibility = View.GONE
                }
            }
        }
        gsonLargeBtn.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Default) {
                withContext(Dispatchers.Main) { progress.visibility = View.VISIBLE }
                val start = System.currentTimeMillis() // save start time of parse
                parser.parseGson(largelJson)
                val end = System.currentTimeMillis() // save end time of parse
                Log.d(TAG, "gson large file duration = ${end - start}")
                withContext(Dispatchers.Main) {
                    resultTv.setText("${end - start}")
                    progress.visibility = View.GONE
                }
            }
        }
        moshiSmallBtn.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Default) {
                withContext(Dispatchers.Main) { progress.visibility = View.VISIBLE }
                val start = System.currentTimeMillis() // save start time of parse
                parser.parseMoshi(smallJson)
                val end = System.currentTimeMillis() // save end time of parse
                Log.d(TAG, "moshi small duration = ${end - start}")
                withContext(Dispatchers.Main) {
                    resultTv.setText("${end - start}")
                    progress.visibility = View.GONE
                }
            }
        }
        moshiLargeBtn.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Default) {
                withContext(Dispatchers.Main) { progress.visibility = View.VISIBLE }
                val start = System.currentTimeMillis() // save start time of parse
                parser.parseMoshi(largelJson)
                val end = System.currentTimeMillis() // save end time of parse
                Log.d(TAG, "moshi large file duration = ${end - start}")
                withContext(Dispatchers.Main) {
                    resultTv.setText("${end - start}")
                    progress.visibility = View.GONE
                }
            }
        }
        ktxSmallBtn.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Default) {
                withContext(Dispatchers.Main) { progress.visibility = View.VISIBLE }
                val start = System.currentTimeMillis() // save start time of parse
                parser.parseKotlin(smallJson)
                val end = System.currentTimeMillis() // save end time of parse
                Log.d(TAG, "kts.serialization small file duration = ${end - start}")
                withContext(Dispatchers.Main) {
                    resultTv.setText("${end - start}")
                    progress.visibility = View.GONE
                }
            }
        }
        ktxLargeBtn.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Default) {
                withContext(Dispatchers.Main) { progress.visibility = View.VISIBLE }
                val start = System.currentTimeMillis() // save start time of parse
                parser.parseKotlin(largelJson)
                val end = System.currentTimeMillis() // save end time of parse
                Log.d(TAG, "kts.serialization large file duration = ${end - start}")
                withContext(Dispatchers.Main) {
                    resultTv.setText("${end - start}")
                    progress.visibility = View.GONE
                }
            }
        }
    }


}
