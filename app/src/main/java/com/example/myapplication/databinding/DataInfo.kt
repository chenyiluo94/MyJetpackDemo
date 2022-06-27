package com.example.myapplication.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.example.myapplication.R

class DataInfo(var name:String,var imageUrl:Int) {
    val _name= ObservableField<String>()
    val _imageUrl= ObservableField<Int>()

    init {
        _name.set(name)
        _imageUrl.set(imageUrl)
    }
    companion object{

        @JvmStatic
        @BindingAdapter(value = ["imageUrl"], requireAll = false)
        fun imageUrl(imageView: ImageView,imageUrl:Int){
            imageView.setImageResource(imageUrl)
        }
    }
}