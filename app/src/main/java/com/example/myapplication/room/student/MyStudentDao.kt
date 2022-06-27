package com.example.myapplication.room.student

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.room.MyUserEntity

@Dao
interface MyStudentDao {
    @Insert
    fun insert(vararg studentEntity: MyStudentEntity)

    @Query("select * from student")
    fun query():List<MyStudentEntity>
}