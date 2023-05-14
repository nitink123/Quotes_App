package com.example.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.quotesapp.models.QuotesVM
import com.example.quotesapp.models.SaveQuotes
import com.example.quotesapp.screens.QuotesListItem
import com.example.quotesapp.screens.QuotesListItemDetail
import com.example.quotesapp.screens.SavePassQuotesData
import com.example.quotesapp.screens.SaveQuotesData
import com.example.quotesapp.ui.theme.QuotesAppTheme

class MainActivity : ComponentActivity() {

    lateinit var vm: QuotesVM
     var result: List<SaveQuotes> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[QuotesVM::class.java]

        vm.quotesData.observe(this) { response ->
            result = response
        }
        setContent {
            //   ListItemDetail()
            DefaultPreview()
        }

        vm.getQuotesData()

    }


    @Preview
    @Composable
    fun DefaultPreview() {
        if(vm.currentPage.value == Pages.Listing)
        {
            SaveQuotesData(data = result){
                vm.SwitchPages(it)
            }
        }else{
            vm.currentQuote?.let { QuotesListItemDetail(it) }
        }
//        SaveQuotesData(data = result)
    }
}

enum class Pages{
    Listing,
    Details
}
