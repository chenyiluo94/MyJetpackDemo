package com.example.myapplication.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

private const val LOG="MyLifecycle"
class MyLifecycle() : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start(){
        Log.d(this.toString(),"start")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create(){
        Log.d(this.toString(),"create")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume(){
        Log.d(this.toString(),"resume")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause(){
        Log.d(this.toString(),"pause")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop(){
        Log.d(this.toString(),"stop")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy(){
        Log.d(this.toString(),"destroy")
    }

}