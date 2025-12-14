package com.example.koltinbasics

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.datastore by preferencesDataStore(name = "simple_storage")
class SimplePrefManager(private val context: Context) {
    private val SCORE_KEY = intPreferencesKey("score")
    val scoreflow: Flow<Int> = context.datastore.data.map { it[SCORE_KEY]?:0 }

    suspend fun savescore(value: Int){
        context.datastore.edit { preferences -> preferences[SCORE_KEY] = value }
    }
}