package com.svetikov.myfirebasselesson2.repository

import androidx.lifecycle.LiveData
import com.svetikov.myfirebasselesson2.Note

interface DatabaseRepository {

    val readAll:LiveData<List<Note>>

    suspend fun create(note: Note,onSuccess: () -> Unit)

    fun sigOut(onSuccess:() -> UInt){}

    fun connectToDataBase(onSuccess: () -> Unit, onFail: (String) -> Unit){}
}