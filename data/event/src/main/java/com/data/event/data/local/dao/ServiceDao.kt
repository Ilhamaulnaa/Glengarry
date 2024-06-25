package com.data.event.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.core.domain.model.ServiceLocalType
import com.data.event.data.local.entity.ServiceEntity

@Dao
interface ServiceDao {
    @Query("SELECT * FROM serviceentity WHERE localType = :type")
    suspend fun getEventService(
        type: ServiceLocalType = ServiceLocalType.Recommendation
    ): List<ServiceEntity>

    @Query("SELECT * FROM serviceentity WHERE title LIKE '%' || :query || '%' AND type = :type")
    fun getEventServicePagingSource(
        query: String,
        type: ServiceLocalType
    ): PagingSource<Int, ServiceEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEventService(data: List<ServiceEntity>)

    @Query("DELETE FROM serviceentity WHERE id = :id")
    suspend fun deleteEventService(id: Int)

    @Query("DELETE FROM serviceentity WHERE localType = :type")
    fun clearService(type: ServiceLocalType)

}