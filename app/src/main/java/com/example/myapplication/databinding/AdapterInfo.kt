package com.example.myapplication.databinding

import androidx.databinding.ObservableField

data class AdapterInfo(var content:String) {
    var _content=ObservableField<String>()
    init {
        _content.set(content)
    }
}