package com.example.chall5.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chall5.model.dao.DataUserDao
import com.example.chall5.model.data.DataUser

@Database(entities = [DataUser::class], version = 1)
abstract class RoomDatabaseStore: RoomDatabase() {
    abstract fun dataUserDao (): DataUserDao

    companion object{
        private var dataUser : RoomDatabaseStore?=null
        fun getDataUser(context: Context):RoomDatabaseStore? {
            if (dataUser == null) {
                synchronized(RoomDatabaseStore::class.java) {
                    dataUser = Room.databaseBuilder(
                        context.applicationContext,
                        RoomDatabaseStore::class.java,
                        "DataUser.db"
                    ).build()
                }
           }

            return dataUser
        }
    }

}