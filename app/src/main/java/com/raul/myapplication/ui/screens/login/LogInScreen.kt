package com.raul.myapplication.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raul.myapplication.R
import androidx.lifecycle.viewmodel.compose.viewModel
import com.raul.myapplication.data.remote.model.UserLogIn
import com.raul.myapplication.ui.AppViewModelProvider


@Composable
fun LogInScreen(
    modifier: Modifier = Modifier,
    viewModel: LogInViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {

    Box(
        modifier = modifier
            .fillMaxSize(1.0f)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()

        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement
                    .spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                UpperTextLogIn(
                    modifier = modifier
                )
                LogInInputForm(
                    user = viewModel.currentUser,
                    onValueChange = viewModel::updateUser
                )
                Button(
                    modifier = modifier
                        .fillMaxWidth(),
                    onClick = {
                        viewModel.logIn(viewModel.currentUser)
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.log_in)
                    )
                }

                ClickableText(
                    text = AnnotatedString(stringResource(id = R.string.register_text)),
                    onClick = {

                    },
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline,
                        fontSize = 16.sp
                    )


                )

                // TODO(IF LOGIN SUCCESSFUL GO TO NEXT SCREEN)
                when (viewModel.logInUiState) {
                    is LogInUiState.Success -> Text(
                        text = (viewModel.logInUiState as LogInUiState.Success).user.firstName
                    )

                    is LogInUiState.Error -> Text(text = "Error")
                    is LogInUiState.Loading -> Text(text = "Loading")
                }
            }

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogInInputForm(
    user: UserLogIn = UserLogIn("", ""),
    modifier: Modifier = Modifier,
    onValueChange: (UserLogIn) -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = user.username,
            onValueChange = {
                onValueChange(user.copy(username = it))
            },
            label = {
                Text(text = stringResource(id = R.string.enter_username))
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            singleLine = true
        )
        OutlinedTextField(
            value = user.password,
            onValueChange = {
                onValueChange(user.copy(password = it))
            },
            label = {
                Text(text = stringResource(id = R.string.enter_password))
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            singleLine = true
        )
    }

}

@Composable
fun UpperTextLogIn(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(id = R.drawable.icon_htrack),
            contentDescription = "Icon"
        )
        Text(
            text = stringResource(id = R.string.app_name),
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = modifier
                .padding(start = 8.dp)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun previewLogInScreen() {
    LogInScreen()
}
