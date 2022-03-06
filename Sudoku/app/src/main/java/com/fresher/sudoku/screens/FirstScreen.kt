package com.fresher.sudoku.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fresher.sudoku.model.UserDataModel

import com.fresher.sudoku.navigation.SudukuScreens
import kotlinx.coroutines.delay

@Composable

fun FirstScreen(navController: NavController,userDataModel: UserDataModel) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true , block = {
        scale.animateTo(targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                }
            ))
        delay(2000L)
        navController.navigate(SudukuScreens.SecondScreen.name)
    })
        Surface(
            modifier = Modifier
                .padding(15.dp)
                .size(330.dp).scale(scale.value),
            shape = CircleShape, color = Color.White, border = BorderStroke(
                width = 5.dp,
                color = Color.LightGray
            )
        )
        {
            Column(
                modifier = Modifier.padding(1.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                SudukuLogo()
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "\"Play Think Enjoy\"",
                    style = MaterialTheme.typography.h5,
                    color = Color.LightGray)
            }
        }
}

@Composable
fun SudukuLogo(modifier: Modifier = Modifier) {
    Text(
        text = "WELCOME",
        modifier = modifier.padding(bottom = 16.dp),
        style = MaterialTheme.typography.h3,
        color = Color.Red.copy(alpha = 0.5f)
    )
}




