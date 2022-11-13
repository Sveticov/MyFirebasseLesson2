package com.svetikov.myfirebasselesson2.firebase

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.svetikov.myfirebasselesson2.Note
import com.svetikov.myfirebasselesson2.constant.Constant
import com.svetikov.myfirebasselesson2.constant.FIREBASE_ID
import com.svetikov.myfirebasselesson2.constant.LOGIN
import com.svetikov.myfirebasselesson2.constant.PASSWORD
import com.svetikov.myfirebasselesson2.repository.DatabaseRepository

class AppFireBaseRepository : DatabaseRepository {
    private val mAuth = FirebaseAuth.getInstance()

    private val database = Firebase.database.reference
        .child(mAuth.currentUser?.uid.toString())

    override val readAll: LiveData<List<Note>> = AllNotesLiveData()

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
        val noteId = database.push().key.toString()
        val mapNotes = hashMapOf<String, Any>()

        mapNotes[FIREBASE_ID] = noteId
        mapNotes[Constant.Key.TITLE] = note.title
        mapNotes[Constant.Key.SUBTITLE] = note.subtitle

        database.child(noteId)
            .updateChildren(mapNotes)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { println("Error $it") }
    }

    override fun sigOut(onSuccess: () -> UInt) {
        mAuth.signOut()
        onSuccess()
    }

    override fun connectToDataBase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(LOGIN, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                mAuth.createUserWithEmailAndPassword(LOGIN, PASSWORD)
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }

    }
}