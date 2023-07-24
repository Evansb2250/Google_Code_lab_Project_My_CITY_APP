package com.example.cityapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cityapp.R


@Preview(
    showBackground = true,
)
@Composable
fun ImageCard() {
    Card(
        modifier = Modifier.size(
            width = 327.dp,
            height = 315.dp,
        )
    ) {
        Column {
            Box(modifier = Modifier) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(218.dp),
                    painter = painterResource(
                        id = R.drawable.my_project,
                    ),
                    contentScale = ContentScale.Crop,
                    contentDescription = "",
                )
            }
        }
    }
}