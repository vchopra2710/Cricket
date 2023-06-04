package com.app.compose.cricket.ui.widget

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import androidx.datastore.dataStoreFile
import androidx.glance.state.GlanceStateDefinition
import com.app.compose.cricket.domain.model.currentmatches.CurrentMatch
import kotlinx.serialization.json.Json
import java.io.File
import java.io.InputStream
import java.io.OutputStream

object SelectedMatchStateDefinition : GlanceStateDefinition<CurrentMatch?> {

    private const val DATA_STORE_FILENAME = "selectedMatchDatastore"
    private val Context.datastore by dataStore(DATA_STORE_FILENAME, SelectedMatchSerializer)

    override suspend fun getDataStore(context: Context, fileKey: String): DataStore<CurrentMatch?> =
        context.datastore

    override fun getLocation(context: Context, fileKey: String): File =
        context.dataStoreFile(DATA_STORE_FILENAME)

    object SelectedMatchSerializer : Serializer<CurrentMatch?> {
        override val defaultValue: CurrentMatch?
            get() = null

        override suspend fun readFrom(input: InputStream): CurrentMatch? = try {
            Json.decodeFromString(input.readBytes().decodeToString())
        } catch (exception: Exception) {
            throw CorruptionException("Could not read connectivity data: ${exception.message}")
        }

        override suspend fun writeTo(t: CurrentMatch?, output: OutputStream) {
            val json = Json {
                explicitNulls = false
            }
            t?.let {
                output.use {
                    it.write(
                        json.encodeToString(CurrentMatch.serializer(), t)
                            .encodeToByteArray()
                    )
                }
            }

        }

    }
}