package com.example.myapplication.lifecycle

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R

private const val mLog="Lifecycle";

internal class MyLifecycle2 (context:Context){
    fun resume(){
        Log.d(mLog,"resume");
    }
    fun destroy(){
        Log.d(mLog,"destory")
    }
}

class LifecycleActivity : AppCompatActivity() {
    private val myLifecycle by lazy { MyLifecycle2(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)
    }

    override fun onResume() {
        super.onResume()
        myLifecycle.resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        myLifecycle.destroy()
    }
}