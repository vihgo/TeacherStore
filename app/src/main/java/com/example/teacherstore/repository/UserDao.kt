package com.example.teacherstore.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.teacherstore.model.Users
import kotlinx.coroutines.flow.Flow
@Dao
interface UserDao {
    @Query("Select * FROM users")
    fun obtenerUsuarios(): Flow<List<Users>>

    @Query("Select * From users where id=:id")
    fun obtenerUsuario(id:Int): Flow<Users>
    @Query("Select * From users where correo=:correo")
    fun obtenerUsuario(correo:String): Flow<Users>
    @Insert
    suspend fun agregarUsuario(user: Users)
    @Delete
    suspend fun eliminarUsuario(user: Users)
    @Update
    suspend fun actualizarUsuario(user: Users)
}



