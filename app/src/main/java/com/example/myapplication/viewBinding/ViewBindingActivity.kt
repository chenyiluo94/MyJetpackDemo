package com.example.myapplication.viewBinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityViewbindingBinding


private const val mLog="ViewBindingActivity";

class ViewBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewbindingBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityViewbindingBinding.inflate(layoutInflater)
//        XXXBinding.inflate(inflater, container, false)
        setContentView(binding.root)

        binding.textview.text="获得到binding的数据了"
    }

}