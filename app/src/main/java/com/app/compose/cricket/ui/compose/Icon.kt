package com.app.compose.cricket.ui.compose

import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun IconRes(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
) = Icon(
    painter = painterResource(id = icon),
    contentDescription = null,
    modifier = modifier,
)