package com.fresher.sudoku.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fresher.sudoku.components.InputField
import com.fresher.sudoku.model.UserDataModel
import com.fresher.sudoku.navigation.SudukuScreens
import java.lang.reflect.Array

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun SecondScreen(navController: NavController,userDataModel: UserDataModel,
                 modifier: Modifier = Modifier,
                 onValChange: (String) -> Unit = {}) {
    val context = LocalContext.current
    val NumberOfRaws = remember {
        mutableStateOf("")
    }

    val NumberOfColumn = remember {
        mutableStateOf("")
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    val splitByState = remember {
        mutableStateOf(1)
    }

    val validState = remember(NumberOfRaws.value) {
        NumberOfRaws.value.trim().isNotEmpty()
    }

    // var gridPercentage = (NumberOfRaws.value.toInt() * NumberOfColumn.value.toInt())


    Surface(
        modifier = modifier
            .padding(2.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)

    ) {
        Column(
            modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            InputField(
                valueState = NumberOfRaws,
                lableId = "Rows",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!validState) return@KeyboardActions
                    onValChange(NumberOfRaws.value.trim())


                    keyboardController?.hide()
                })
            // navController.navigate(SudukuScreens.ThirdScreen.name)
        }
    }
    Row(
        modifier = modifier
            .padding(
                horizontal = 0.dp,
                vertical = 150.dp
            )
    )
    {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            InputField(
                valueState = NumberOfColumn,
                lableId = "Column",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!validState) return@KeyboardActions
                    onValChange(NumberOfRaws.value.trim())


                    keyboardController?.hide()
                })
            // navController.navigate(SudukuScreens.ThirdScreen.name)
        }
    }
    Row(
        modifier = modifier
            .padding(
                horizontal = 150.dp,
                vertical = 300.dp
            )
    ) {
        Button(
            onClick = {
                userDataModel.rows = NumberOfRaws.value.toInt()
                userDataModel.columns = NumberOfColumn.value.toInt()

                navController.navigate(SudukuScreens.ThirdScreen.name)
            },
            contentPadding = PaddingValues(16.dp),
            border = BorderStroke(10.dp, Color.Black),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Text(text = "ENTER")
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

      },
          contentPadding = PaddingValues(16.dp),
          border = BorderStroke(10.dp, Color.Black),
          colors = ButtonDefaults.textButtonColors(
              backgroundColor = Color.DarkGray,
              contentColor = Color.White
          )) {
          Text(text = "RESET")
      }

  }


    }







