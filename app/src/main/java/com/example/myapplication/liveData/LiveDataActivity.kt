package com.example.myapplication.liveData

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.arch.core.util.Function
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.myapplication.R


private const val TAG="LiveData";

class LiveDataActivity : AppCompatActivity() {

    private lateinit var textview: TextView;
    private val myHandle=Handler(Looper.getMainLooper())
    private val liveData= MutableLiveData<String>();

    private val liveDataInt= MutableLiveData<Int>();

    private val liveDataBool= MutableLiveData<Boolean>();
    private val liveDataStr1= MutableLiveData<String>();
    private val liveDataStr2= MutableLiveData<String>();
    private var boolValue=false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata)
        textview=findViewById(R.id.textview);

        liveData.observe(this) {
            textview.text = it
            Log.d(TAG, "接收消息$it")
        }

        liveDataInt.value=111;
        val liveDataChange=Transformations.map(liveDataInt,object :Function<Int,String>{
            override fun apply(input: Int?): String {
                return "哈哈$input"
            }

        });
        liveDataChange.observe(this){
            textview.text= it
        }

        val switchMapString=Transformations.switchMap(liveDataBool
        ) { input ->
            if (input)
                liveDataStr1
            else
                liveDataStr2
        }
        switchMapString.observe(this){
            textview.text=it
        }

    }
    fun sendValue(view: View) {
        Log.d(TAG, "发送消息 sendValue")
        liveData.value="这是一条消息"
    }
    fun delayValue(view: View) {
        myHandle.postDelayed({
            Log.d(TAG, "发送消息 delayValue")
            liveData.value="这是一条延时消息"
        },3000)
    }
    fun postValue(view: View) {
        Thread{
            Log.d(TAG, "发送消息 postValue")
            liveData.postValue("这是一条线程中postValue消息")
        }.start()
    }

    fun changeMap(view: View) {
        liveDataBool.value=boolValue;
        boolValue=!boolValue;
        liveDataStr1.value="true数值"
        liveDataStr2.value="false数值"
    }
}