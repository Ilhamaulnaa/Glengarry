package com.data.user.data.datastore

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

val Context.userPreferenceDataStoreModule: DataStore<UserPreferencesDataStore> by dataStore(
    fileName = "settings.pb",
    serializer = UserPreferenceSerializer
)

object UserPreferenceSerializer : Serializer<UserPreferencesDataStore> {

    override val defaultValue: UserPreferencesDataStore
        get() = UserPreferencesDataStore.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserPreferencesDataStore {
        try {
            return UserPreferencesDataStore.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: UserPreferencesDataStore, output: OutputStream) = t.writeTo(output)

}
