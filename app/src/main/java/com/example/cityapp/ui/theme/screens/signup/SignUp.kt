package com.example.cityapp.ui.theme.screens.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cityapp.components.AnnotatedText
import com.example.cityapp.ui.theme.UIScreen

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true
)
@Composable
fun SignUp(
    navigateToLoginScreen: () -> Unit = {},
){
Column(
    modifier = Modifier.padding(
        16.dp
    )
) {
    Text(
        text = "Create an Account",
        style = UIScreen.titleLarge,
    )
    AnnotatedText(
        text = "Already have an account?",
        highlightedText = " Log in",
        onClick = navigateToLoginScreen
    )

    Spacer(
        modifier = Modifier.size(50.dp)
    )

    Text(
        text = "User name",
    )
    OutlinedTextField(
        value = "",
        onValueChange = {},
        shape = RoundedCornerShape(10.dp)
    )

    Spacer(
        modifier = Modifier.size(30.dp)
    )
    Text(
        text = "Email address",
    )
    OutlinedTextField(
        value = "",
        onValueChange = {},
        shape = RoundedCornerShape(10.dp)
    )

    Spacer(
        modifier = Modifier.size(30.dp)
    )

    Text(
        text = "Password",
    )
    OutlinedTextField(
        value = "",
        onValueChange = {},
        shape = RoundedCornerShape(10.dp)
    )
    Text(text = "Use 8 or more chacterers with a mix of letters.")

    Spacer(
        modifier = Modifier.size(30.dp)
    )

    OutlinedButton(
        onClick = {  },
        shape = RoundedCornerShape(30.dp),
    ) {
        Text(
            text = "Create an account",
        )
    }
}
}