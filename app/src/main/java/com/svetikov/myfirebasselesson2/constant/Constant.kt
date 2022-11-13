package com.svetikov.myfirebasselesson2.constant

import com.svetikov.myfirebasselesson2.repository.DatabaseRepository

lateinit var LOGIN: String
lateinit var PASSWORD: String
lateinit var REPOSITORY: DatabaseRepository
const val FIREBASE = "FireBase"
const val FIREBASE_ID = "firebaseId"

object Constant {
    object Key {
        const val LOGIN_TXT = "Login"
        const val PASSWORD_TXT = "Password"
        const val SIG_IN_TXT = "SigIn"
        const val TITLE = "title"
        const val SUBTITLE = "subtitle"
    }

}