package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val liveData=MutableLiveData<Int>()
    var intValue:Int=1;
    fun getLiveDat(): MutableLiveData<Int> {
        return liveData;
    }
    fun add(){
        intValue++;
        liveData.value=intValue
    }
}