package com.example.myapplication.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R


private const val mLog="Lifecycle";

class LifecycleActivity2 : AppCompatActivity() {
//    private val myLifecycle by lazy {
//        MyLifecycle()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)
//        lifecycle.addObserver(myLifecycle)
//        lifecycle.addObserver(MyObserver())
    }

}