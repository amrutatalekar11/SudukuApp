package com.fresher.sudoku.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fresher.sudoku.model.UserDataModel
import com.fresher.sudoku.screens.FirstScreen
import com.fresher.sudoku.screens.FourthScreen
import com.fresher.sudoku.screens.SecondScreen
import com.fresher.sudoku.screens.ThirdScreen

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalComposeApi
@Composable
fun SudukuNavigation(userDataModel: UserDataModel){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SudukuScreens.FirstScreen.name
    ) {
        composable(SudukuScreens.FirstScreen.name) {
            // first screen
            FirstScreen(navController = navController,userDataModel)
        }
        composable(SudukuScreens.SecondScreen.name) {
            // second screen
            SecondScreen(navController = navController,userDataModel)
        }
        composable(SudukuScreens.ThirdScreen.name) {
            // third screen
            ThirdScreen(navController = navController,userDataModel)
        }
        composable(SudukuScreens.FourthScreen.name) {
            // third screen
            FourthScreen(navController = navController,userDataModel)
        }

    }
}