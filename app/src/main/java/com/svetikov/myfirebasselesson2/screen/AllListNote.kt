package com.svetikov.myfirebasselesson2.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.svetikov.myfirebasselesson2.Note
import com.svetikov.myfirebasselesson2.viewmoddel.MyViewModel

@Composable
fun AllListNote(viewmodel:MyViewModel = viewModel()){
    val notes = viewmodel.allNotes().observeAsState().value?: listOf(Note(title = "Start", subtitle = "Start"))
    LazyColumn(){
       items(notes){note ->
           Card(backgroundColor = Color.Magenta, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
               Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                   Text(text = note.title)
                   Text(text = note.subtitle)
               }
           }

       }
    }
}