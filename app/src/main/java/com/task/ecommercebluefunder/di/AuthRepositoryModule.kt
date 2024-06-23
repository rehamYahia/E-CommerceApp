package com.task.ecommercebluefunder.di


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.task.ecommercebluefunder.repository.auth.AuthRepository
import dagger.Provides
import com.task.ecommercebluefunder.repository.auth.AuthRepositoryImp
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthRepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepo(authdataStore: DataStore<Preferences>): AuthRepository {

        return AuthRepositoryImp(authdataStore)
    }
}