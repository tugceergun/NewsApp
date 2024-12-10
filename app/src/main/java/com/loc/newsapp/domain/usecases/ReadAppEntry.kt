package com.loc.newsapp.domain.usecases

import com.loc.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager //interface implementation (from LocalUserManager)
) {
    suspend fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}