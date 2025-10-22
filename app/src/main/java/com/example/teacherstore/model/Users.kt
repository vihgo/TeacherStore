package com.example.teacherstore.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
/*val nombre: String="",
    val correo: String="",
    val contrasena: String="",
    val direccion: String="",
    val aceptaTerminos: Boolean=false,*/
@Entity(tableName = "users")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("nombre")
    val nombre: String,
    @ColumnInfo("correo")
    val correo: String,
    @ColumnInfo("contrasena")
    val contrasena: String,
    @ColumnInfo("direccion")
    val direccion: String,

)
{
}