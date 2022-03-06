package com.fresher.sudoku.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fresher.sudoku.model.UserDataModel
import com.fresher.sudoku.navigation.SudukuScreens
import com.fresher.sudoku.userComp.UserInput

@ExperimentalComposeUiApi
@Composable
fun ThirdScreen(
    navController: NavController,userDataModel: UserDataModel) {
    val context = LocalContext.current
    var title by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserInput(
            modifier = Modifier.padding(
                top = 18.dp, bottom = 16.dp
            ),
            text = title, label = "UserInput",
            onTextChange = {
                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) title = it
            })

        Button(onClick = {
            userDataModel.userinputString = title
            navController.navigate(SudukuScreens.FourthScreen.name)
        }) {
            Text(text = "Save")
        }

    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            showToast(context, "OOPS...! Something went wrong please try again.")
            navController.navigate(SudukuScreens.SecondScreen.name)
        }) {
            Text(text = "RESET")
        }

    }
}

