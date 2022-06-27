package com.example.myapplication.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.example.myapplication.R

class ViewModelLeftFragment : Fragment() {

    private lateinit var message: TextView
//    private  val viewModel by lazy {
//        ViewModelProvider(this).get(MyViewModel::class.java);
//    }
    private val viewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_view_model_left, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message=view.findViewById<TextView>(R.id.message)

        activity?.let { viewModel.liveData.observe(it){
            message.text=it.toString()
        } }
    }

}