package com.loc.newsapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.domain.usecases.AppEntryUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUsecases
):  ViewModel() {

    //sadece bu event public diger fonk'lar private
    fun onEvent(event: OnBoardingEvent){
        when(event){
            is OnBoardingEvent.SaveAppEntry -> {
                saveAppEntry()  //Kullanici uygulamayi ilk kez baslattiginda, SaveAppEntry olayi tetiklenir.
            }
        }
    }

    //usecase'ler viewModel'de cagiriliyor.
    private fun saveAppEntry() {
        viewModelScope.launch{
            appEntryUseCases.saveAppEntry()  //Temel is mantigini yerine getirir ve veriyi kaydeder.
                                              // AppEntryUsecases -> SaveAppEntry
        }

    }
}