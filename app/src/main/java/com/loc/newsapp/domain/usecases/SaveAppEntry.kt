package com.loc.newsapp.domain.usecases

import android.util.Log
import com.loc.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager  //interface implementation (from LocalUserManager)
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}