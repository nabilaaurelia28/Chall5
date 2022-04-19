package com.example.chall5.model.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "data_user")
data class DataUser(
    @PrimaryKey(autoGenerate = true)
    val id : Int?,
    @ColumnInfo(name = "email")
    val email : String?,
    @ColumnInfo(name = "password")
    val password : String?,
    @ColumnInfo (name = "nama")
    val nama : String?,
    @ColumnInfo (name = "alamat")
    val alamat : String?,
    @ColumnInfo (name = "usia")
    val usia : Int?,


)
