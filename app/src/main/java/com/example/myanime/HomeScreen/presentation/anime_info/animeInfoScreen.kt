package com.example.myanime.HomeScreen.presentation.anime_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import coil.compose.AsyncImage
import com.example.animelist.common.Constants
import com.example.myanime.HomeScreen.presentation.anime_info.components.genreBox
import com.example.myanime.HomeScreen.presentation.anime_list.AnimeListState
import com.example.myanime.R



@Composable
fun animeInfoScreen(
    navController: NavController,
    state:AnimeListState

) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primary)
        .padding(8.dp)
        .verticalScroll(rememberScrollState())
       ) {
Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null
    , tint = MaterialTheme.colorScheme.onSecondary, modifier = Modifier
        .height(40.dp)

        .clickable {
            navController.popBackStack()
        })
        Row( modifier = Modifier
            .fillMaxWidth()
            ) {
                AsyncImage(
                    model = state.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .weight(1f)
                        .size(250.dp)
                        .clip(RoundedCornerShape(25.dp)),
                    contentScale = ContentScale.FillBounds,
                )

            Spacer(modifier = Modifier
                .width(8.dp))

            Column(modifier = Modifier.weight(1f)) {

              Text(text = state.name, color = MaterialTheme.colorScheme.onSecondary, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.size(8.dp))
                Row {
                    Icon(imageVector = Icons.Default.Star, contentDescription = null,modifier = Modifier
                        .background(color = Color.Yellow)
                        .height(17.dp))
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(text =state.score.toString(), color = MaterialTheme.colorScheme.onSecondary)
                    Spacer(modifier = Modifier.size(5.dp))
                    AutoTextSize(name = "(scored by ${state.scoredBy} users)",Modifier.align(Alignment.Bottom))
                  //  Text(text = "(scored by ${state.scoredBy} users)", fontSize = 10.sp , modifier = Modifier.align(Alignment.Bottom), color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = "status: ${state.status}", color = MaterialTheme.colorScheme.onSecondary)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = "aired: ${state.aired}", color = MaterialTheme.colorScheme.onSecondary)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = "episodes: ${state.totalEpisodes}", color = MaterialTheme.colorScheme.onSecondary)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = "rating: ${state.rating}", color = MaterialTheme.colorScheme.onSecondary)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = "studio: ${state.studio}", color = MaterialTheme.colorScheme.onSecondary)

            }

        }
        Divider(Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())) {
            genreBox(genreList = state.genres)
        }
        Text(text = "About", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp,
            modifier= Modifier.padding(top = 16.dp, bottom = 6.dp), color = MaterialTheme.colorScheme.onSecondary)
Text(text = "${state.synopsis!!.substringBefore("[")}", fontSize = 15.sp, color = MaterialTheme.colorScheme.onSecondary)



    }
}


@Composable
fun AutoTextSize(name:String,modifier: Modifier) {
    val textStyleBody1 = MaterialTheme.typography.bodyLarge
    var textStyle by remember { mutableStateOf(textStyleBody1) }
    var readyToDraw by remember { mutableStateOf(false) }
    Text(
        text = name,
        style = textStyle,
        maxLines = 3,
        softWrap = false,
        modifier = Modifier.drawWithContent {
            if (readyToDraw) drawContent()
        }.then(modifier), color = MaterialTheme.colorScheme.onSecondary,
        onTextLayout = { textLayoutResult ->
            if (textLayoutResult.didOverflowWidth) {
                textStyle = textStyle.copy(fontSize = textStyle.fontSize * 0.9)
            } else {
                readyToDraw = true
            }
        }
    )
}
