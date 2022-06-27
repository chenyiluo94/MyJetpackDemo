package com.example.myapplication.room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.databinding.ActivityRoom2Binding
import com.example.myapplication.room.student.MyStudentEntity

private const val TAG = "TAG"
class RoomActivity : AppCompatActivity() {

    private  val userInfo2 = MutableLiveData<List<MyUserEntity>>()
    private  val userInfoStu = MutableLiveData<List<MyStudentEntity>>()
    private lateinit var binding: ActivityRoom2Binding
    private val database by lazy {
        MyDatabase.getDatabase(this).userDao()
    }
    private val databaseStudent by lazy {
        MyDatabase.getDatabase(this).studentDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRoom2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.insert.setOnClickListener{
            Thread{
                database.insert(MyUserEntity(name="张三", age = 18))
            }.start()
        }
        binding.delete.setOnClickListener{
            Thread{
                database.delete(MyUserEntity(id = 1, name = null, age = null))
            }.start()
        }
        binding.updata.setOnClickListener{
            Thread{
                database.updata(MyUserEntity(id = 2, name="李四", age = 20))
            }.start()
        }
        binding.query.setOnClickListener{
            Thread{
                val userInfo=database.query()
                this.userInfo2.postValue(userInfo)
            }.start()
        }

        binding.studentInset.setOnClickListener{
            Thread{
                databaseStudent.insert(MyStudentEntity(name = "张三",classLeval="五年级"))
            }.start()
        }
        binding.studentQuery.setOnClickListener{
            Thread{
                val databaseStudentInfo=databaseStudent.query()
                this.userInfoStu.postValue(databaseStudentInfo)
            }.start()
        }

        userInfo2?.observe(this) {
            binding.textview.text= "数据查询$it"
        }
        userInfoStu?.observe(this) {
            binding.textview.text= "数据查询$it"
        }

    }

}