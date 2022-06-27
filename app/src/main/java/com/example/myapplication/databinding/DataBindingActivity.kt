package com.example.myapplication.databinding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R

private const val TAG = "DataBindingActivity"
class DataBindingActivity : AppCompatActivity() {
    private var isChange=false;
    private val dataInfo=DataInfo("哈哈",R.mipmap.a)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding=DataBindingUtil.setContentView<ActivityDatabindingBinding>(this,R.layout.activity_databinding)
        dataBinding.lifecycleOwner=this
        dataBinding.dataInfo=dataInfo

        dataBinding.recyclerview.adapter=MyAdapter()

        dataBinding.changeBtn.setOnClickListener{
            if (isChange){
                dataInfo._name.set("哈哈")
                dataInfo._imageUrl.set(R.mipmap.a)
            }else{
                dataInfo._name.set("呵呵")
                dataInfo._imageUrl.set(R.mipmap.b)
            }
            isChange=!isChange;
        }
    }

}