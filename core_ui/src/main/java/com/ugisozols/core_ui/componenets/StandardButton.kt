package com.ugisozols.core_ui.componenets

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun StandardButton(
  onClick : () -> Unit,
  buttonTitle : String
){
    Button(
        shape = RoundedCornerShape(10.dp),
        onClick = {
            onClick()
        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 8.dp,
            pressedElevation = 12.dp
        )
    ) {
        Text(text = buttonTitle)
    }
}