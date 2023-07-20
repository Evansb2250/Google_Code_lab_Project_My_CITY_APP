package com.example.cityapp.screens.home

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cityapp.R
import com.example.cityapp.ui.theme.UIScreen

@Preview(
    showBackground = true
)
@Composable
fun HomeScreen(

) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Home",
        )
        Row() {

        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 10.dp
                ),
            backgroundColor = Color.LightGray,
            shape = RoundedCornerShape(5.dp)
        ) {
            Row() {
                Image(
                    painter = painterResource(
                        id = R.drawable.adventure_icon,
                    ),
                    contentDescription = null,
                )
                
                Text(text = "Adventure")
            }

        }
    }
}