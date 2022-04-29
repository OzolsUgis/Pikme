package com.ugisozols.pikme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ugisozols.core.navigation.Route
import com.ugisozols.pikme.navigation.navigate
import com.ugisozols.pikme.ui.theme.PikmeTheme
import com.ugisozols.register_presentation.login_screen.LoginScreen
import com.ugisozols.register_presentation.register_screen.RegisterScreen
import com.ugisozols.setup_presentation.username_update_screen.UpdateUsernameScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PikmeTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.LOGIN
                    ){
                        composable(Route.REGISTER){
                            RegisterScreen(scaffoldState = scaffoldState)
                        }
                        composable(Route.LOGIN){
                            LoginScreen(
                                scaffoldState = scaffoldState,
                                navController::navigate
                            )
                        }
                        composable(Route.UPDATE_USERNAME){
                            UpdateUsernameScreen(
                                navController::navigate,
                                scaffoldState
                            )
                        }
                        composable(Route.UPDATE_IMAGE){

                        }
                    }
                }
            }
        }
    }
}
