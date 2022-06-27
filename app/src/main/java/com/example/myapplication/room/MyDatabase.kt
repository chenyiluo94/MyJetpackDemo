package com.example.myapplication.room

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myapplication.room.student.MyStudentDao
import com.example.myapplication.room.student.MyStudentEntity

@Database(entities = [MyUserEntity::class,MyStudentEntity::class], version = 2,
//autoMigrations = AutoMigration(from = 1, to = 2, spec = MyDatabase)
    )
abstract class MyDatabase:RoomDatabase(){
    abstract fun userDao():MyUserDao
    abstract fun studentDao():MyStudentDao
    companion object{

        @Volatile
        private var instance:MyDatabase?=null
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("""
                CREATE TABLE student (
                    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                    name TEXT NOT NULL,
                    classLeval TEXT NOT NULL 
                )
                """.trimIndent())
            }
        }

        fun getDatabase(context: Context):MyDatabase{
            if (instance!=null){
                return instance as MyDatabase
            }
            synchronized(this){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java, "user"
                ).addMigrations(MIGRATION_1_2)
                    .build()
                return instance as MyDatabase
            }
        }
    }
}