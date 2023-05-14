package com.example.quotesapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapp.models.SaveQuotes


@Composable
fun SaveQuotesData(data : List<SaveQuotes>,onclick : (value : SaveQuotes)->Unit){
    Column() {
        Text(  text = "Welcome To Quotes",
            modifier = Modifier.padding(bottom = 8.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
           )
         SavePassQuotesData(data = data,onclick)




    }
}
@Composable
fun SavePassQuotesData(data : List<SaveQuotes>,onclick : (value : SaveQuotes)->Unit){
    LazyColumn(content = {
        items(data) {it
            QuotesListItem(it,onclick)

        }
    })
}