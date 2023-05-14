package com.example.quotesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quotesapp.models.SaveQuotes


@Composable
fun QuotesListItem(value : SaveQuotes,onclick : (value : SaveQuotes)->Unit) {
    Card(elevation = 4.dp,
        modifier = Modifier.padding(8.dp)
            .clickable { onclick(value) }
      ) {

        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                imageVector =  Icons.Filled.ArrowForward,
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                contentDescription = "Quote",
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180f)
                    .background(Color.Black)
            )
            // spacer is use to add spacing between different items
            Spacer(modifier = Modifier.padding(4.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = value.text,  fontWeight = FontWeight.Bold,style = MaterialTheme.typography.body2, modifier = Modifier.padding(bottom = 8.dp))
                Box(modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxWidth(.4f)
                    .height(1.dp))


                Text(text = value.author,style = MaterialTheme.typography.body2, fontWeight = FontWeight.Thin, modifier = Modifier.padding(top = 4.dp))
            }

        }
    }
}





