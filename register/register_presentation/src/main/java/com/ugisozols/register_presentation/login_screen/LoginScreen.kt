package com.ugisozols.register_presentation.login_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ugisozols.core.util.UiEvent
import com.ugisozols.core_ui.LocalSpacing
import com.ugisozols.core_ui.componenets.InputTextField
import com.ugisozols.core_ui.componenets.StandardButton
import com.ugisozols.core.R



@Composable
fun LoginScreen(
    scaffoldState: ScaffoldState,
    onNavigate : (UiEvent.Navigate) -> Unit,
    viewModel: LoginScreenViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(event.message.asString(context))
                }
                is UiEvent.Navigate -> {
                    onNavigate(event)
                }
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputTextField(
                value = viewModel.email.value,
                onValueChange = {
                    viewModel.setEmail(it)
                },
                placeholder = stringResource(id = R.string.email)
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            InputTextField(
                value = viewModel.password.value,
                onValueChange = {
                    viewModel.setPassword(it)
                },
                placeholder = stringResource(id = R.string.password),
                password = true
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spaceExtraLarge),
                horizontalArrangement = Arrangement.End
            ) {
                if(viewModel.isLoading.value){
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(35.dp)
                            .padding(top = spacing.spaceSmall),
                        strokeWidth = 4.dp
                    )
                }
                Spacer(modifier = Modifier.width(spacing.spaceSmall))

                StandardButton(
                    onClick = {
                        viewModel.isLoading.value = true
                        viewModel.onEvent(LoginScreenEvents.OnLoginClick)
                    },
                    stringResource(id = R.string.login_button)
                )
            }
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            Text(
                modifier = Modifier.clickable {
                    //TODO : Add forgot password functionality
                },
                text = stringResource(id = R.string.forgot_password),
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(spacing.spaceLarge))

            Text(
                modifier = Modifier.clickable {
                    viewModel.onRegisterClick()
                },
                text = stringResource(id = R.string.create_account),
                style = MaterialTheme.typography.h2
            )
        }
    }
}