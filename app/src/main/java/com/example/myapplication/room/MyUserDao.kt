package com.example.myapplication.room

import androidx.room.*

@Dao
interface MyUserDao {
    @Insert
    fun insert(vararg userEntity: MyUserEntity)

    @Delete
    fun delete(userEntity: MyUserEntity)

    @Update
    fun updata(vararg userEntity: MyUserEntity)

    @Query("select * from user")
    fun query():List<MyUserEntity>
}