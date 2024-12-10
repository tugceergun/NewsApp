package com.loc.newsapp.domain.usecases

import com.loc.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager  //interface implementation (from LocalUserManager)
) {
    suspend fun invoke(){
        localUserManager.saveAppEntry()
    }
}