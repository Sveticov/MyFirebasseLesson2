package com.svetikov.myfirebasselesson2.viewmoddel

import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svetikov.myfirebasselesson2.Note
import com.svetikov.myfirebasselesson2.constant.FIREBASE
import com.svetikov.myfirebasselesson2.constant.REPOSITORY
import com.svetikov.myfirebasselesson2.firebase.AppFireBaseRepository
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    fun initDataBase(database: String, onSuccess: () -> Unit) {
        when (database) {
            FIREBASE -> {
                REPOSITORY = AppFireBaseRepository()
                REPOSITORY.connectToDataBase(
                    { onSuccess() }
                ) { println("Error $it") }
            }
        }

    }

    fun create(note: Note){
        viewModelScope.launch {
            REPOSITORY.create(note){

            }
        }

    }

    fun allNotes()= REPOSITORY.readAll//.observeAsState().value?: listOf(Note(title = "Start", subtitle = "Start"))//.value?: listOf(Note(title = "test0", subtitle = "test00"))

}