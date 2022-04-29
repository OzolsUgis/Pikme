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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ugisozols.core_ui.AppBlack
import com.ugisozols.core_ui.LocalSpacing



@Composable
fun InputTextField(
    value : String,
    onValueChange : (String) -> Unit,
    fontSize : TextUnit = 16.sp,
    placeholder : String,
    placeholderFontSize: TextUnit = 16.sp,
    placeholderColor : Color = AppBlack,
    password: Boolean = false,
    singleLine: Boolean = true,
    maxLines : Int = 40,
    color: Color = AppBlack,
    indicatorColor : Color = Color.Transparent,
    horizontalPadding : Dp = LocalSpacing.current.spaceExtraLarge
) {

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontalPadding)
        ,
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = color,
            focusedIndicatorColor = indicatorColor,
            unfocusedIndicatorColor = indicatorColor
        ),
        placeholder = {
            Text(
                text = placeholder,
                color = placeholderColor,
                fontSize = placeholderFontSize
            )
        },
        shape = RoundedCornerShape(10.dp),
        singleLine = singleLine,
        visualTransformation = if (password) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        maxLines = maxLines,
        textStyle = TextStyle(
            fontSize = fontSize
        )
    )
}