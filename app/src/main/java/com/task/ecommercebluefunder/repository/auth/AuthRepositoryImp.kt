package com.task.ecommercebluefunder.repository.auth

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.task.ecommercebluefunder.constants.DataStoreKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthRepositoryImp (private val dataStore: DataStore<Preferences>) :AuthRepository{
    override suspend fun UpdateLoginStatues(loginStatues:Boolean) {
     dataStore.edit {preferance->
         preferance[DataStoreKey.LOGIN_STATUES]=loginStatues
     }
    }

    override suspend fun getLoginStatues(): Flow<Boolean> {
        val loginStatus: Flow<Boolean> = dataStore.data
            .map { preferences ->
                preferences[DataStoreKey.LOGIN_STATUES] ?: false
            }
        return loginStatus
    }
}

