package com.example.cityapp.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cityapp.model.HomeScreenUIElements
import com.example.cityapp.model.HomeScreenUIState
import com.example.cityapp.ui.theme.pxt16
import com.example.cityapp.ui.theme.pxt32

private val pxt40 = 40.dp
private val pxt20 = 20.dp
private val pxt109 = 109.dp

@Composable
fun HomeScreenPage(
    state: HomeScreenUIState,
    onClickTab:(HomeScreenUIElements) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = state.title.name,
            modifier = Modifier.padding(
                bottom = pxt40,
            )
        )
        state.headers.forEach { header ->
            Text(
                text = header.title.name,
                modifier = Modifier
                    .padding(
                        horizontal = pxt16,
                    )
                    .fillMaxWidth(),
                textAlign = TextAlign.Start,
            )
            Box(
                Modifier
                    .padding(
                        horizontal = pxt16,
                    )
                    .fillMaxWidth()
                    .height(pxt109)
                    .background(
                        color = Color.DarkGray
                    )
                    .clickable { onClickTab(header) }
                    .padding(
                        start = pxt16,
                        end = pxt16,
                        bottom = pxt20
                    )
            ) {
                //TODO add an image in this block
            }
            Spacer(modifier = Modifier.size(pxt32))
        }
    }
}