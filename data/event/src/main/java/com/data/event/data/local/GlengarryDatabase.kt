package com.data.event.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.data.event.data.local.dao.ServiceDao
import com.data.event.data.local.entity.ServiceEntity

@Database(entities = [ServiceEntity::class], version = 1)
abstract class GlengarryDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "glengarry.db"
    }

    abstract val eventServiceDao: ServiceDao

}