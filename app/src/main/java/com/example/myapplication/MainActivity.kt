package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.databinding.DataBindingActivity
import com.example.myapplication.navigation.NavigationActivity
import com.example.myapplication.room.RoomActivity
import com.example.myapplication.viewmodel.ViewModelActivity

class MainActivity : AppCompatActivity() {

    lateinit var tvButton: TextView;
//    private val myLifecycle by lazy {
//        MyLifecycle()
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvButton=findViewById(R.id.tvButton);
//        lifecycle.addObserver(myLifecycle)

        tvButton.setOnClickListener {
            val intent = Intent(this, NavigationActivity::class.java)
            startActivity(intent)
        }
    }

}