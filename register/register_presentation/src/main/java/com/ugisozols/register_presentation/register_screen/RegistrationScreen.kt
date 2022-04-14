package com.ugisozols.register_presentation.register_screen

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
import com.ugisozols.core.R
import com.ugisozols.core.util.UiEvent
import com.ugisozols.core_ui.LocalSpacing
import com.ugisozols.core_ui.componenets.InputTextField
import com.ugisozols.core_ui.componenets.StandardButton
import com.ugisozols.register_presentation.login_screen.LoginScreenEvents

@Composable
fun RegisterScreen(
    scaffoldState: ScaffoldState,
    viewModel: RegistrationScreenViewModel = hiltViewModel()
){

    val context = LocalContext.current
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect{ event ->
            when(event){
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(event.message.asString(context))
                }
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ){
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
            InputTextField(
                value = viewModel.confirmedPassword.value,
                onValueChange = {
                    viewModel.setConfPassword(it)
                },
                placeholder = stringResource(id = R.string.confirmed_password),
                password = true
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spaceExtraLarge),
                horizontalArrangement = Arrangement.End
            ) {
                if(viewModel.registrationLoading.value){
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
                        viewModel.registrationLoading.value = true
                        viewModel.onEvent(RegistrationScreenEvents.OnRegisterClick)
                    },
                    stringResource(id = R.string.register_button)
                )
            }
        }
    }
}