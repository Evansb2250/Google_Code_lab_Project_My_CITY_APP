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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cityapp.components.AnnotatedText
import com.example.cityapp.ui.theme.UIScreen
import com.example.cityapp.ui.theme.signin.LoginStates
import com.example.cityapp.ui.theme.signin.SignInMethod


val ed = "Don't you have an account? "

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
)
@Composable
fun LoginScreen(
    state: LoginStates = LoginStates.LoginInProgress(),
    updateUser: (updatedUser: LoginStates.LoginInProgress) -> Unit = {},
    signIn: (SignInMethod) -> Unit = {},
    navToSignUpPage: () -> Unit = {},
    navToHomePage: (userId: String) -> Unit = {},
) {
    when (state) {
        is LoginStates.Error -> {

        }

        LoginStates.Loading -> {

        }

        is LoginStates.SuccessfulLogin -> {
            LaunchedEffect(key1 = Unit) {
                navToHomePage(state.usernameId)
            }
        }

        is LoginStates.LoginInProgress -> {
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

                Spacer(
                    modifier =
                    Modifier.size(60.dp)
                )

                Text(text = "Email or phone number")
                OutlinedTextField(
                    value = state.username,
                    onValueChange = { newUserName ->
                        updateUser(
                            state.copy(
                                username = newUserName,
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(size = 10.dp)
                )

                Spacer(
                    modifier =
                    Modifier.size(30.dp)
                )

                Text(text = "Password")
                OutlinedTextField(
                    value = state.password,
                    onValueChange = { newPassword ->
                        updateUser(
                            state.copy(
                                password = newPassword,
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(size = 10.dp)
                )

                Spacer(
                    modifier =
                    Modifier.size(30.dp)
                )

                Button(
                    onClick = {
                        signIn(SignInMethod.GoogleSignIn)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                        ),
                    shape = RectangleShape
                ) {

                    Text(
                        text = "Sign In With Google"
                    )
                }

                Spacer(
                    modifier =
                    Modifier.size(20.dp)
                )

                OutlinedButton(
                    onClick = {
                        signIn(SignInMethod.LocalSignIn)
                    },
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

                    ) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = {},
                    )

                    Text(
                        text = "Remember me",
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(
                    modifier =
                    Modifier.size(50.dp)
                )

                AnnotatedText(
                    text = ed,
                    highlightedText = "Sign Up",
                    onClick = navToSignUpPage
                )

                Spacer(
                    modifier =
                    Modifier.size(20.dp)
                )
            }
        }
    }
}