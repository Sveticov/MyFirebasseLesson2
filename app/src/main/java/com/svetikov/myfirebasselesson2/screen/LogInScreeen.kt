package com.svetikov.myfirebasselesson2.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.svetikov.myfirebasselesson2.constant.Constant
import com.svetikov.myfirebasselesson2.constant.FIREBASE
import com.svetikov.myfirebasselesson2.constant.LOGIN
import com.svetikov.myfirebasselesson2.constant.PASSWORD
import com.svetikov.myfirebasselesson2.viewmoddel.MyViewModel

@Composable
fun LogInScreen(viewModel: MyViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var switch by remember { mutableStateOf(false) }
    var switchAll by remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!switch && !switchAll)
        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            label = { Text(text = Constant.Key.LOGIN_TXT) })
        if (!switch && !switchAll)
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = Constant.Key.PASSWORD_TXT) })
        Row{
            if (!switch && !switchAll)
            Button(onClick = {
                LOGIN =login
                PASSWORD =password
                viewModel.initDataBase(FIREBASE) {  }
            }) {
                Text(text = Constant.Key.SIG_IN_TXT)
            }
            Button(onClick = {
                switch = !switch
            }) {
                Text(text = "Open Create")
            }
            Button(onClick = {switchAll=!switchAll}) {
                Text(text = "Show All")
            }

        }
        if (switch) CreateNote()
        if (switchAll) AllListNote()
    }
}