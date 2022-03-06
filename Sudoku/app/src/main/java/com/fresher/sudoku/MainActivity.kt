package com.fresher.sudoku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.fresher.sudoku.model.UserDataModel
import com.fresher.sudoku.navigation.SudukuNavigation
import com.fresher.sudoku.screens.SecondScreen
import com.fresher.sudoku.ui.theme.SudokuTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalComposeApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           SudukuApp()
            }
        }
    }


@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalComposeApi
@Composable
fun SudukuApp() {
    SudokuTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            val userDataModel = UserDataModel()
            SudukuNavigation(userDataModel)
        }
    }
}


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        SudokuTheme {

        }
    }
