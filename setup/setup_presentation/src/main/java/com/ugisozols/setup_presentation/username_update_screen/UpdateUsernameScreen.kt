package com.ugisozols.setup_presentation.username_update_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ugisozols.core_ui.*
import com.ugisozols.core.R
import com.ugisozols.core.util.UiEvent
import com.ugisozols.core_ui.LocalSpacing
import com.ugisozols.core_ui.componenets.InputTextField
import kotlinx.coroutines.flow.collect


@Composable
fun UpdateUsernameScreen(
    onNavigate : (UiEvent.Navigate) -> Unit,
    scaffoldState: ScaffoldState,
    viewModel: UpdateUsernameScreenViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect { event ->
            when(event){
                is UiEvent.Navigate -> {
                    onNavigate(event)
                }
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.message.asString(context)
                    )
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppBlack)
    ) {
        Column(
            Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(horizontal = spacing.spaceLarge),
                text = stringResource(
                    id = R.string.setup_greeting
                ),
                style = MaterialTheme.typography.h3,
                color = LightGreen
            )
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            InputTextField(
                value = viewModel.name.value,
                onValueChange = {
                    viewModel.onUsernameValueChange(it)
                },
                fontSize = 22.sp,
                placeholder = stringResource(id = R.string.setup_name),
                horizontalPadding = spacing.spaceLarge,
                placeholderFontSize = 22.sp,
                color = LightGray,
                indicatorColor = LightGray,
                placeholderColor = LightGray
            )
            Spacer(modifier = Modifier.height(spacing.spaceLarge))

            Row(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(end = spacing.spaceLarge)
                    .clickable {
                        viewModel.onEvent(UpdateUsernameScreenEvents.OnNextClick)
                    },
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .width(150.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(start = spacing.spaceMedium),
                        text = stringResource(id = R.string.next_page),
                        style = TextStyle(
                            color = LightGreen,
                            fontSize = 25.sp
                        )
                    )
                    Canvas(
                        modifier = Modifier
                            .width(150.dp)
                            .height(60.dp)
                    ){
                       val arrow = Path().apply {
                           moveTo(x = 0f, y= 30f)
                           lineTo(size.width, y= 30f)
                           lineTo(size.width - 30f, y = 0f)
                           moveTo(size.width + 4f, y= 30f)
                           lineTo(size.width - 30f, y = 60f)
                       }
                        drawPath(
                            arrow,
                            color = LightGray,
                            style = Stroke(6f).apply {
                                cap
                            }
                        )
                    }
                }
            }
        }
    }
}


