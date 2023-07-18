package com.example.cityapp.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cityapp.R


val ed = "Don't you have an account? "
@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
)
@Composable
fun LoginScreen(){
    Column(
        modifier = Modifier.padding(
            16.dp,
        )
    ) {
        Text(
           text = "Sign in",
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            textAlign = TextAlign.Start,
        )

        Spacer(modifier =
        Modifier.size(30.dp)
        )

        Text(text = "Email or phone number")
        TextField(
            value = "",
            onValueChange ={},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                ),
            shape = RoundedCornerShape(size = 10.dp)
        )

        Spacer(modifier =
        Modifier.size(30.dp)
        )

        Text(text = "Email or phone number")
//        Icon(
//          painter = painterResource(
//              id = androidx.core.R.drawable.notification_bg,
//          ),
//            contentDescription = ""
//        )
        TextField(
            value = "",
            onValueChange ={},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                ),
            shape = RoundedCornerShape(size = 10.dp)
        )

        Spacer(modifier =
        Modifier.size(30.dp)
        )

        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                ),
            shape = CircleShape
        ) {
            Text(text = "Sign in")
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

        ){
            Checkbox(
                checked = false,
                onCheckedChange = {},
            )

            Text(
                text = "Remember me",
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier =
        Modifier.size(50.dp)
        )

//        Text(
//            text = "Don't you have an account?",
//            = buildAnnotatedString {  }
//        )
        Row() {
            Text(
                text = buildAnnotatedString {
                    this.append(ed)
                },
                )
            Text(
                text = buildAnnotatedString {
                    this.addStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        ),
                        start = 0,
                        end = "Sign up".length,
                    )
                    this.append("Sign up")
                },
                modifier = Modifier.clickable {

                }
                )
        }

    }
}