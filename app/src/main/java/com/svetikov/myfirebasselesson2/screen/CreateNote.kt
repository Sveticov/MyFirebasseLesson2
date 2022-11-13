package com.svetikov.myfirebasselesson2.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.svetikov.myfirebasselesson2.Note
import com.svetikov.myfirebasselesson2.constant.Constant
import com.svetikov.myfirebasselesson2.viewmoddel.MyViewModel

@Composable
fun CreateNote(viewmode:MyViewModel = viewModel()) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        var title by remember { mutableStateOf("") }
        var subtitle by remember { mutableStateOf("") }
        OutlinedTextField(value =title, onValueChange ={title = it}, label = { Text(text = Constant.Key.TITLE)})
        OutlinedTextField(value =subtitle, onValueChange ={subtitle = it}, label = { Text(text = Constant.Key.SUBTITLE)})
        Button(onClick = {
            viewmode.create(Note(title = title, subtitle = subtitle))
        }) {
            Text(text = "Create")
        }
    }
}