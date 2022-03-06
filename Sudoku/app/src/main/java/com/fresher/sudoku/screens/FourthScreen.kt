package com.fresher.sudoku.screens

import android.content.Context
import android.util.Log
import android.widget.GridLayout
import android.widget.Toast
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fresher.sudoku.model.UserDataModel
import com.fresher.sudoku.navigation.SudukuScreens
import com.fresher.sudoku.userComp.UserInput

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun FourthScreen(navController: NavController,userDataModel: UserDataModel) {
    val context = LocalContext.current
    var title by remember{
        mutableStateOf("")
    }
// val gridPercentage = (NumberOfRaws.value * NumberOfColumn.value).toInt()
    Log.d("Fourth screen", userDataModel.userinputString)
    val rows = userDataModel.rows
    val columns = userDataModel.columns
    val userInput = userDataModel.userinputString
    val colorInputState = remember {
        mutableStateOf(IntArray(userInput.length))
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(columns)
        ) {
            items(userInput.length) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    // Text(text = "Number " + rows )

                    Text(text = "${userInput.get(it)}",color = getColor(colorInputState.value[it])

                    )

                }

            }
        }

        UserInput(
            modifier = Modifier.padding(
                top = 18.dp , bottom = 16.dp
            ),
            text =  title, label = "        Your Final Grid ",
            onTextChange = {
                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) title = it
                refreshState(colorInputState)
                checkHoizontal(title,userInput,rows,columns,colorInputState)
                checkVertical(title,userInput,rows,columns,colorInputState)
                checkDiagonal(title,userInput)
            })
        Button(onClick = {
            showToast(context, "Thanks For Playing . Have a Good Day")
            navController.navigate(SudukuScreens.SecondScreen.name) }) {

            Text(text = "RESET")
        }

    }

}

fun getColor(index:Int):Color{
    if(index == 0) return Color.Black
    else return Color.Blue
}

fun refreshState(colorInputState: MutableState<IntArray>){
    for(i in 0..colorInputState.value.size -1){
        colorInputState.value[i] = 0
    }
}

fun checkHoizontal(word:String,userInput:String,row:Int,col:Int,colorInputState:MutableState<IntArray>) {



    var strList:ArrayList<String> = ArrayList()
    for (j in 0..col - 1) {
        var str = ""
        for (i in 0..row - 1) {

             str = str + userInput[i + (j * row)].toString()
        }
        Log.d("checkHorizontal",str)
        strList.add(str)

    }
    for(str in strList){
       val index = matchDetails(str,word,0)
        if(index>=0) {
            val finalIndex = strList.indexOf(str)
            // check should u increment by 1??
            val s =  finalIndex*col + index
            highlightCellsHorizontal(s,word.length,colorInputState)
        }

    }

}

fun highlightCellsHorizontal(startIndex:Int, length:Int,colorInputState: MutableState<IntArray>){
   for(l in startIndex..startIndex+length-1)
    colorInputState.value[l] = 1
}
fun matchDetails(inputString: String, whatToFind: String, startIndex: Int = 0): Int {
    val matchIndex = inputString.indexOf(whatToFind, startIndex)
    val rs =  "Searching for '$whatToFind' in '$inputString' starting at position $startIndex: " +
            if (matchIndex >= 0) "Found at $matchIndex" else "Not found"
    return matchIndex
}




fun checkVertical(word:String,userInput: String,row:Int,col:Int,colorInputState: MutableState<IntArray>){


    var strList:ArrayList<String> = ArrayList()
    for (j in 0..row - 1) {
        var str = ""
        for (i in 0..col- 1) {
            Log.d("checkHorizontal $i , $j ,$row,$col", userInput[j + (i * col)].toString())
            str = str + userInput[j + (i * col)].toString()
        }
        Log.d("checkHorizontal",str)
        strList.add(str)

    }

    //handle this part ..error is here .. u need correct index calculation
    for(str in strList){
        val index = matchDetails(str,word,0)
        if(index>=0) {
            val finalIndex = strList.indexOf(str)
            // check should u increment by 1??
            val s =  finalIndex + index*col
            highlightCellsVertical(s,word.length,col,colorInputState)
        }

    }

}
fun highlightCellsVertical(startIndex:Int, length:Int,col:Int,colorInputState: MutableState<IntArray>){
    var l = startIndex
    var count = length
    while(count>0)
    {

        colorInputState.value[l] = 1
        l += col
        count --
    }
}

fun checkDiagonal(word:String,userInput: String){

}

fun showToast(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_LONG)
        .show()
}

