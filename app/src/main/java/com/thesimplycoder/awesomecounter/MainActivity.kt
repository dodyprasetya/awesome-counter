package com.thesimplycoder.awesomecounter

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // initialization of number variable
    var number: Int = 0

    // initialization of handler
    val handler: Handler = Handler()

    // initialization of runnable for our handler
    val runnable = object: Runnable {
        override fun run() {
            // increase the number
            number++

            // update the displayed number
            tvNumberCounter.text = "$number"

            // run the timer again
            handler.postDelayed(this, 1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("lifecycle", "created")
    }

    override fun onStart() {
        super.onStart()
        Log.i("lifecycle", "started")
    }

    override fun onResume() {
        super.onResume()
        Log.i("lifecycle", "resumed")

        // start the timer handler
        handler.postDelayed(runnable, 1000)
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifecycle", "paused")

        // pause or stop the timer handler
        handler.removeCallbacks(runnable)
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifecycle", "stopped")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("lifecycle", "restarted")
    }

    override fun onDestroy() {
        Log.i("lifecycle", "destroyed")
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }

}
