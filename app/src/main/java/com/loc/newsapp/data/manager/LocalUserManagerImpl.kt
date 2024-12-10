package com.loc.newsapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.util.Constants
import com.loc.newsapp.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(
    private val context: Context
):LocalUserManager {
    override suspend fun saveAppEntry() { //Kullanicinin uygulamaya ilk kez giris yapip yapmadigini kaydeder.
        context.dataStore.edit { settings ->  //uyg'a ilk kez girince veriyi true olarak duzenleyip anahtar ile true olarak kaydeder.
            settings[PreferencesKeys.APP_ENTRY] = true  //degeri yazma
        }
    }

    override fun readAppEntry(): Flow<Boolean> { //Kullanicinin daha once uygulamaya giris yapip yapmadigini ogrenir.
        return context.dataStore.data.map { preferences->   // context.dataStore.data -> kayitli verilere erisir
            preferences[PreferencesKeys.APP_ENTRY] ?: false  //anahtar bulunamazsa(doha once giris yoksa) false doner. (deger okuma)
        }
    }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS) //datastore -> uyg ayarlarini saklamak ve erismek icin. key-value seklinde saklar.

private object PreferencesKeys{ //saklanacak ayarlarin keylerini tanimlar.
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY )
}