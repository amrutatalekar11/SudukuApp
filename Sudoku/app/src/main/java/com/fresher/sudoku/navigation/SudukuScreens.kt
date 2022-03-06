package com.fresher.sudoku.navigation

import com.fresher.sudoku.screens.FirstScreen

enum class SudukuScreens {
    FirstScreen,
    SecondScreen,
    ThirdScreen,
    FourthScreen;
    companion object{
        fun fromRoute(route : String?) : SudukuScreens
                = when (route?.substringBefore("/")){
            FirstScreen.name -> FirstScreen
            SecondScreen.name -> SecondScreen
            ThirdScreen.name -> ThirdScreen
            FourthScreen.name -> FourthScreen
            null -> SecondScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }


}