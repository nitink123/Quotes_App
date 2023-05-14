package com.example.quotesapp.models

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.Pages
import com.example.quotesapp.endpoint.RetroFit
import kotlinx.coroutines.launch

class QuotesVM(application: Application) : AndroidViewModel(application) {

    var quotesData : MutableLiveData<List<SaveQuotes>> = MutableLiveData()
    var errorData: MutableLiveData<String> = MutableLiveData()
    var currentPage = mutableStateOf(Pages.Listing)
    var currentQuote : SaveQuotes? = null


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

    fun SwitchPages(quotes: SaveQuotes?){
        if(currentPage.value == Pages.Listing){
            currentQuote = quotes
            currentPage.value = Pages.Details
        }else{
            currentPage.value = Pages.Listing
        }
    }
}