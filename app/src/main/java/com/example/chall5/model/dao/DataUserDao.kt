package com.example.chall5.model.dao

import androidx.room.*
import com.example.chall5.model.data.DataUser

@Dao
interface DataUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserDataUser(dataUser: DataUser)

    @Query("SELECT*fROM data_user WHERE email = :email")
    suspend fun getEmail (email : String): DataUser

    @Update
    suspend fun updateProfileUser (user: DataUser):Int

    @Delete
    suspend fun deleteUser (user: DataUser): Int
}