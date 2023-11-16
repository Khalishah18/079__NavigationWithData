package com.example.esjumbo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked:() -> Unit
){
    var namaTxt by remember {
        mutableStateOf("")
    }
    var alamatTxt by remember {
        mutableStateOf("")
    }
    var phoneTxt by remember {
        mutableStateOf("")
    }

    var  listData: MutableList<String> = mutableListOf(namaTxt, alamatTxt, phoneTxt)

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Masukkan Data Diri", fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Column (
            modifier = Modifier.padding(20.dp)
        ){
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = namaTxt,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.name))},
                onValueChange = {namaTxt = it}
            )
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = alamatTxt,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.address))},
                onValueChange = {alamatTxt = it}
            )
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = phoneTxt,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.phone))},
                onValueChange = {phoneTxt = it}
            )
            Spacer(modifier = Modifier.padding(10.dp))
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(onClick = {onBackButtonClicked}) {
                Text(text = stringResource(id = R.string.back_button))
            }
            Button(onClick = {onSubmitButtonClicked}) {
                Text(text = stringResource(id = R.string.submit_button))
            }
        }
    }
}