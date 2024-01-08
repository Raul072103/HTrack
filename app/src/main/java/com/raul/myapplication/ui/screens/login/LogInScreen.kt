package com.raul.myapplication.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raul.myapplication.R
import com.raul.myapplication.data.remote.model.User

@Composable
fun LogInScreen() {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
    ) {

    }

}

@Composable
fun ItemEntryBody(

) {
    LogInInputForm(
        user =
    )
}

@Composable
fun LogInInputForm(
    user: User,
    modifier: Modifier = Modifier,
    onValueChange: (User) -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {
                onValueChange(user.copy(body = it))
            },
            label = {
                Text(text = stringResource(id = R.string.enter_username))
            }

        ) {

        }
    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun previewLogInScreen() {

}
