package com.ugisozols.core_ui.componenets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ugisozols.core_ui.Black
import com.ugisozols.core_ui.LocalSpacing

@Composable
fun InputTextField(
    value : String,
    onValueChange : (String) -> Unit,
    placeholder : String,
    password: Boolean = false,
    singleLine: Boolean = true,
    maxLines : Int = 40
) {
    val spacing = LocalSpacing.current
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = spacing.spaceExtraLarge)
        ,
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(text = placeholder)
        },
        shape = RoundedCornerShape(10.dp),
        singleLine = singleLine,
        visualTransformation = if (password) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        maxLines = maxLines
    )
}