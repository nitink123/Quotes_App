package com.example.quotesapp.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.endpoint.RetroFit
import kotlinx.coroutines.launch

class QuotesVM(application: Application) : AndroidViewModel(application) {

    var quotesData : MutableLiveData<List<SaveQuotes>> = MutableLiveData()
    var errorData: MutableLiveData<String> = MutableLiveData()

    fun getQuotesData() {
        viewModelScope.launch {
            val data = RetroFit.create().getQuotes()

           if(data.isSuccessful){
               quotesData.value = data.body()
           }else{
               errorData.value = "failed to fetch quotes"
           }
        }
    }
}