package com.example.myanime.HomeScreen.presentation.anime_info.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun genreBox(genreList:List<String>?) {

    if (genreList != null) {
        genreList.forEach {genre->
            Box(contentAlignment = Alignment.Center, modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.onSurface)
            ){
                Text(text = genre, Modifier.padding(8.dp), color = MaterialTheme.colorScheme.onSecondary)
            }
            Spacer(modifier = Modifier.size(4.dp))
        }
    }




}

@Preview
@Composable
fun g() {
genreBox(genreList = listOf("Adventure","Action","Horror"))
}