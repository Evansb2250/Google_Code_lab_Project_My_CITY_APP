package com.example.cityapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight


@Composable
fun AnnotatedText(
    text: String,
    highlightedText: String,
    onClick: () -> Unit = {}
){
    Row() {
        Text(
            text = buildAnnotatedString {
                this.append(text)
            },
            modifier = Modifier.wrapContentWidth()
        )
        Text(
            text = buildAnnotatedString {
                this.addStyle(
                    style = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    ),
                    start = 0,
                    end = highlightedText.length,
                )
                this.append(highlightedText)
            },
            modifier = Modifier.clickable {
                onClick()
            }.wrapContentWidth()
        )
    }
}