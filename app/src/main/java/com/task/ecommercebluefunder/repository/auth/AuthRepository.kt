package com.task.ecommercebluefunder.repository.auth

import kotlinx.coroutines.flow.Flow

interface AuthRepository {

  suspend fun UpdateLoginStatues(loginStatues:Boolean)

  suspend fun getLoginStatues(): Flow<Boolean>
}