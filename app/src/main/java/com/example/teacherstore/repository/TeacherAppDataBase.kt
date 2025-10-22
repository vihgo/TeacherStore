package com.example.teacherstore.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.teacherstore.model.Users

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class TeacherAppDataBase(): RoomDatabase() {
    abstract fun userDao(): UserDao
}


