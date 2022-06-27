package com.example.myapplication.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R

class ViewModelActivity : AppCompatActivity() {
    private lateinit var textview: TextView;
    private  val viewModel by lazy {
        ViewModelProvider(this).get(MyViewModel::class.java);
    }
//    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        textview=findViewById<TextView>(R.id.textview)
        viewModel.liveData.observe(this){
            textview.text=it.toString()
        }
    }

    fun addValue(view: View) {
        viewModel.add();
    }
}