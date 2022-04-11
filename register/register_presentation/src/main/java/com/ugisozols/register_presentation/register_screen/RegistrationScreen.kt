package com.ugisozols.register_presentation.register_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ugisozols.core.util.UiEvent

@Composable
fun RegisterScreen(
    scaffoldState: ScaffoldState,
    viewModel: RegistrationScreenViewModel = hiltViewModel()
){

    val context = LocalContext.current
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
            TextField(
                value = viewModel.email.value,
                onValueChange = {
                    viewModel.setEmail(it)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = viewModel.password.value,
                onValueChange = {
                    viewModel.setPassword(it)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = viewModel.confirmedPassword.value,
                onValueChange = {
                    viewModel.setConfPassword(it)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                viewModel.onEvent(RegistrationScreenEvents.OnRegisterClick)
            }) {
                if(viewModel.registrationLoading.value){
                  CircularProgressIndicator()
                }else{
                    Text(text = "ClickMe")
                }
            }
        }
    }
}