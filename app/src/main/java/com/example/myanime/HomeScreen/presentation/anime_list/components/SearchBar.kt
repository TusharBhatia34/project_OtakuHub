@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myanime.HomeScreen.presentation.anime_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun searchBar(modifier:Modifier) {


   var text by remember{ mutableStateOf("")  }

        OutlinedTextField( modifier = Modifier
            .then(modifier)
            .height(50.dp)

            ,value = text,
            onValueChange = { text = it}
            , colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.onSurface,
                focusedContainerColor =MaterialTheme.colorScheme.onSurface,
                focusedBorderColor =  Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = MaterialTheme.colorScheme.onSecondary,
                unfocusedTextColor = MaterialTheme.colorScheme.onSecondary,
                focusedLabelColor =MaterialTheme.colorScheme.onSecondary,
                cursorColor = MaterialTheme.colorScheme.onSecondary
            ), shape = RoundedCornerShape(30.dp),
            placeholder = { Text(text = "Search", fontSize = 16.sp )},

            trailingIcon = {
                if (text.isNotBlank()){
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }

            }
            , singleLine = true
        )


//    var active by remember{ mutableStateOf(false)  }
//    SearchBar(
//        modifier = modifier,
//        query = text,
//        onQueryChange = {text = it},
//        onSearch = { active= false},
//        active = active,
//        onActiveChange ={ active =  it},
//        placeholder = { Text(text = "Search") },
//        leadingIcon = {
//            Icon(imageVector = Icons.Default.Search, contentDescription = null )
//        },
//        trailingIcon = {
//            Icon(imageVector = Icons.Default.Close, contentDescription = null )
//        }
//    ) {
//
//    }
}