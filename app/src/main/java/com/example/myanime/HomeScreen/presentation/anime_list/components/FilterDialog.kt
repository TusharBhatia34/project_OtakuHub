package com.example.myanime.HomeScreen.presentation.anime_list.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.animelist.common.Constants
import com.example.myanime.HomeScreen.presentation.AnimeViewModel




@Composable
fun filterDialog(viewModel: AnimeViewModel,navController: NavController) {
    Dialog(
        onDismissRequest = { viewModel.HideDialog()},
        properties = DialogProperties(
            dismissOnClickOutside = true
        )
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .width(350.dp)
            , colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Column( modifier = Modifier.padding(15.dp)) {
               var selectedGenres = remember { mutableListOf<Int>()}
                var isCheckedSl by remember { mutableStateOf(false)}
                var isCheckedA by remember { mutableStateOf(false)}
                var isCheckedAw by remember { mutableStateOf(false)}
                var isCheckedD by remember { mutableStateOf(false)}
                var isCheckedC by remember { mutableStateOf(false)}
                var isCheckedAd by remember { mutableStateOf(false)}
                var isCheckedS by remember { mutableStateOf(false)}
                var isCheckedR by remember { mutableStateOf(false)}
                var isCheckedSt by remember { mutableStateOf(false)}
                var isCheckedSe by remember { mutableStateOf(false)}
                var isCheckedH by remember { mutableStateOf(false)}
                var isCheckedM by remember { mutableStateOf(false)}
                var isCheckedSf by remember { mutableStateOf(false)}
                var isCheckedF by remember { mutableStateOf(false)}
                Icon(imageVector = Icons.Default.Close, contentDescription = null,modifier = Modifier
                    .clickable {
                        viewModel.HideDialog()
                    }
                    .align(Alignment.End)
                       , tint = MaterialTheme.colorScheme.onSecondary
                   )
                Text("Filter by genres", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSecondary)
                Spacer(modifier = Modifier.size(15.dp))
                Row(Modifier.fillMaxWidth()) {
                    Checkbox(
                        checked = isCheckedA,
                        onCheckedChange = {
                            isCheckedA = it
                            if(isCheckedA){
                              selectedGenres.add(1)
                            }
                            else{
                                selectedGenres.remove(1)
                            }
                        }
                        , enabled = true
                          ,modifier = Modifier.size(20.dp)
                           ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Action", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))

                    Checkbox(
                        checked = isCheckedSl,
                        onCheckedChange = {
                            isCheckedSl = it
                            if(isCheckedSl){
                                selectedGenres.add(36)
                            }
                            else{
                                selectedGenres.remove(36)
                            }
                        }
                        , enabled = true
                        ,modifier = Modifier.size(20.dp)
                        ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Slice of life", modifier = Modifier.padding(start = 8.dp,end = 8.dp), color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(Modifier.fillMaxWidth()) {


                    Checkbox(
                        checked = isCheckedAw,
                        onCheckedChange = {
                            isCheckedAw = it
                            if(isCheckedAw){
                                selectedGenres.add(46)
                            }
                            else{
                                selectedGenres.remove(46)
                            }
                        }
                        , enabled = true
                        ,modifier = Modifier.size(20.dp)
                        ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Award Winning", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))

                    Checkbox(
                        checked = isCheckedD,
                        onCheckedChange = {
                            isCheckedD = it
                            if(isCheckedD){
                                selectedGenres.add(8)
                            }
                            else{
                                selectedGenres.remove(8)
                            }
                        }
                        , enabled = true
                        ,modifier = Modifier.size(20.dp)
                        ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Drama", modifier = Modifier.padding(start = 8.dp,end = 44.dp), color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(Modifier.fillMaxWidth()) {

                    Checkbox(
                        checked = isCheckedC,
                        onCheckedChange = {
                            isCheckedC = it
                            if(isCheckedC){
                                selectedGenres.add(4)
                            }
                            else{
                                selectedGenres.remove(4)
                            }
                        }
                        , enabled = true
                        ,modifier = Modifier.size(20.dp)
                        ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Comedy", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))

                    Checkbox(
                        checked = isCheckedAd,
                        onCheckedChange = {
                            isCheckedAd = it
                            if(isCheckedAd){
                                selectedGenres.add(2)
                            }
                            else{
                                selectedGenres.remove(2)
                            }
                        }
                        , enabled = true
                        ,modifier = Modifier.size(20.dp)
                        ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Adventure", modifier = Modifier.padding(start = 8.dp,end = 16.dp), color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(Modifier.fillMaxWidth()) {


                    Checkbox(
                        checked = isCheckedS,
                        onCheckedChange = {
                            isCheckedS= it
                            if(isCheckedS){
                                selectedGenres.add(37)
                            }
                            else{
                                selectedGenres.remove(37)
                            }
                        }
                        , enabled = true
                        ,modifier = Modifier.size(20.dp)
                        ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Supernatural", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))

                    Checkbox(
                        checked = isCheckedR,
                        onCheckedChange = {
                            isCheckedR = it
                            if(isCheckedR){
                                selectedGenres.add(22)
                            }
                            else{
                                selectedGenres.remove(22)
                            }
                        }
                        , enabled = true
                        ,modifier = Modifier.size(20.dp)
                        ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Romance", modifier = Modifier.padding(start = 8.dp,end = 22.dp), color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(Modifier.fillMaxWidth()) {


                    Checkbox(
                        checked = isCheckedSt,
                        onCheckedChange = {
                            isCheckedSt = it
                            if(isCheckedSt){
                                selectedGenres.add(30)
                            }
                            else{
                                selectedGenres.remove(30)
                            }
                        }
                        , enabled = true
                        ,modifier = Modifier.size(20.dp)
                        ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Sports", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))

                    Checkbox(
                        checked = isCheckedSe,
                        onCheckedChange = {
                            isCheckedSe = it
                            if(isCheckedSe){
                                selectedGenres.add(41)
                            }
                            else{
                                selectedGenres.remove(41)
                            }
                        }
                        , enabled = true
                        ,modifier = Modifier.size(20.dp)
                        ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Suspense", modifier = Modifier.padding(start = 8.dp,end = 19.dp), color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(Modifier.fillMaxWidth()) {


                    Checkbox(
                        checked = isCheckedH,
                        onCheckedChange = {
                            isCheckedH = it
                            if(isCheckedH){
                                selectedGenres.add(14)
                            }
                            else{
                                selectedGenres.remove(14)
                            }
                        }
                        , enabled = true
                        ,modifier = Modifier.size(20.dp)
                        ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Horror", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))

                    Checkbox(
                        checked = isCheckedM,
                        onCheckedChange = {
                            isCheckedM = it
                            if(isCheckedM){
                                selectedGenres.add(46)
                            }
                            else{
                                selectedGenres.remove(46)
                            }
                        }
                        , enabled = true
                        ,modifier = Modifier.size(20.dp)
                        ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Mystery", modifier = Modifier.padding(start = 8.dp,end = 33.dp), color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(Modifier.fillMaxWidth()) {


                    Checkbox(
                        checked = isCheckedSf,
                        onCheckedChange = {
                            isCheckedSf = it
                            if(isCheckedSf){
                                selectedGenres.add(24)
                            }
                            else{
                                selectedGenres.remove(24)
                            }
                        }
                        , enabled = true
                        ,modifier = Modifier.size(20.dp)
                        ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Sci-fi", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))

                    Checkbox(
                        checked = isCheckedF,
                        onCheckedChange = {
                            isCheckedF = it
                            if(isCheckedF){
                                selectedGenres.add(46)
                            }
                            else{
                                selectedGenres.remove(46)
                            }
                        }
                        , enabled = true
                        ,modifier = Modifier.size(20.dp)
                        ,     colors = CheckboxDefaults.colors(
                            uncheckedColor = MaterialTheme.colorScheme.outline, checkedColor = MaterialTheme.colorScheme.background
                        )
                    )
                    Text("Fantasy", modifier = Modifier.padding(start = 8.dp,end = 34.dp), color = MaterialTheme.colorScheme.onSecondary)
                }

                Spacer(modifier = Modifier.size(15.dp))
                Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(
                        onClick = {
                            isCheckedSl = false
                            isCheckedA = false
                            isCheckedAw = false
                            isCheckedD = false
                            isCheckedC = false
                            isCheckedAd = false
                            isCheckedS = false
                            isCheckedR = false
                            isCheckedSt = false
                            isCheckedSe = false
                            isCheckedH = false
                            isCheckedM = false
                            isCheckedSf = false
                            selectedGenres.clear()
                                  }
                        , colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                        , shape = RoundedCornerShape(15.dp)
                        , border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                        ,modifier = Modifier.height(35.dp)
                    ) {
                        Text(
                            text = "Reset All"
                            , color = MaterialTheme.colorScheme.background
                        )
                    }
                    Button(
                        onClick = {
                            if(selectedGenres.isNotEmpty()){

                                viewModel.toPassGenres(selectedGenres.joinToString())
                                viewModel.HideDialog()
                                navController.navigate(Constants.FILTER_ANIME_ROUTE)
                                selectedGenres.clear()

                            }

                        }
                        , colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.background
                        )
                        , shape = RoundedCornerShape(15.dp)
                        ,modifier = Modifier.height(35.dp)
                    ) {
                        Text(
                            text = "Apply"
                            , color = MaterialTheme.colorScheme.onPrimary
                        )
                    }

                }
                }
        }
    }
}


