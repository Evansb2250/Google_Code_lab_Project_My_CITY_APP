package com.example.cityapp.ui.theme.screens.login

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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cityapp.components.AnnotatedText
import com.example.cityapp.ui.theme.PoppinsFamily
import com.example.cityapp.ui.theme.UIScreen


val ed = "Don't you have an account? "
@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
)
@Composable
fun LoginScreen(
    navToSignUpPage: () -> Unit = {},
    navToLoginScreen: () -> Unit = {},
){
    Column(
        modifier = Modifier.padding(
            16.dp,
        )
    ) {
        Text(
           text = "Sign in",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 30.dp,
                ),
            textAlign = TextAlign.Start,
            style = UIScreen.titleLarge
        )

        Spacer(modifier =
        Modifier.size(60.dp)
        )

        Text(text = "Email or phone number")
        OutlinedTextField(
            value = "",
            onValueChange ={},
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(size = 10.dp)
        )

        Spacer(modifier =
        Modifier.size(30.dp)
        )

        Text(text = "Email or phone number")


        OutlinedTextField(
            value = "",
            onValueChange ={},
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(size = 10.dp)
        )

        Spacer(modifier =
        Modifier.size(30.dp)
        )

        OutlinedButton(
            onClick = { navToLoginScreen() },
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

        AnnotatedText(
            text = ed,
            highlightedText = "Sign Up",
            onClick = navToSignUpPage
        )

        Spacer(modifier =
        Modifier.size(20.dp)
        )
    }
}