package com.example.cityapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cityapp.R
import com.example.cityapp.ui.theme.UIScreen

@Preview(
    showBackground = true
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppTopAppBar(

) {
    Column() {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 10.dp,
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .width(
                            220.dp,
                        )
                        .height(
                            38.dp
                        ),
                    shape = RoundedCornerShape(10.dp),
                    trailingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(
                                    id = R.drawable.filter_icon,
                                ),
                                contentDescription = "",
                                modifier = Modifier.border(
                                    border = BorderStroke(
                                        1.dp,
                                        color = Color.Black
                                    ),
                                    shape = RoundedCornerShape(5.dp)
                                )

                            )
                        }
                    }
                )

//                IconButton(
//                    modifier = Modifier
//                        .padding(
//                            start = 8.dp,
//                        )
//                        .border(
//                            border = BorderStroke(
//                                width = 1.dp,
//                                color = Color.Black
//                            ),
//                            shape = RoundedCornerShape(10.dp)
//                        ),
//                    onClick = { },
//                ) {
//                    Image(
//                        painter = painterResource(
//                            id = R.drawable.filter_icon,
//                        ),
//                        contentScale = ContentScale.Crop,
//                        contentDescription = "",
//                    )
//                }
            }
        }
        Divider(
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}