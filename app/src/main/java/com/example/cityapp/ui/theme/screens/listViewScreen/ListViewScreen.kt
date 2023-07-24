package com.example.cityapp.ui.theme.screens.listViewScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cityapp.data.DataSource
import com.example.cityapp.ui.theme.pxt10

@Preview(
    showBackground = true
)
@Composable
fun ListViewScreen(
    id:String = "",
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        //add LazyList
        DataSource.events.forEach { event ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = pxt10)
            ){
                Row {
                    Text(text = event.name )
                }
            }

            Spacer(modifier = Modifier.size(pxt10))
        }
    }

}