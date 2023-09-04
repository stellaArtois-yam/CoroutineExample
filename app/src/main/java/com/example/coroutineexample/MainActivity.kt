package com.example.coroutineexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.measureTime

class MainActivity : AppCompatActivity() {

    val TAG = "Main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lifecycleScope.launch(Dispatchers.Default) {
            val time = measureTime {

                val one = async { firstThing()}
                val two = async { secondThing()}
                Log.d(TAG, "The answer is : ${one.await() + two.await()}")
            }
            Log.d(TAG, "Complete in: ${time} ms")
        }

    }

    suspend fun firstThing() : Int {
        delay(1000L)
        return 10
    }

    suspend fun secondThing() : Int {
        delay(1000L)
        return 20
    }



//    val one = firstThing()
//    val two = secondThing()
//    Log.d(TAG, "The answer is : ${one + two}")
}