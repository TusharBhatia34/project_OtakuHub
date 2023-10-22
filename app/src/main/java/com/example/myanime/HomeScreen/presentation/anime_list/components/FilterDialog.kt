package com.example.myanime.HomeScreen.presentation.anime_list.components

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.myanime.HomeScreen.presentation.AnimeViewModel


@Composable
fun filterDialog(viewModel: AnimeViewModel) {
    Dialog(
        onDismissRequest = { viewModel.HideDialog()},
        properties = DialogProperties(
            dismissOnClickOutside = true
        )
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
//               .height(560.dp)
                .width(350.dp)
            , colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Column( modifier = Modifier.padding(15.dp)) {
                Icon(imageVector = Icons.Default.Close, contentDescription = null,modifier = Modifier
                    .clickable { }
                    .align(Alignment.End)
                       , tint = MaterialTheme.colorScheme.onSecondary
                   )

                Text("Filter by genres", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSecondary)
                Spacer(modifier = Modifier.size(15.dp))
                Row(Modifier.fillMaxWidth()) {

                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                          ,modifier = Modifier.size(20.dp)
                    )
                    Text("Action", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))
                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                        ,modifier = Modifier.size(20.dp)


                    )
                    Text("Slice of life", modifier = Modifier.padding(start = 8.dp,end = 8.dp), color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(Modifier.fillMaxWidth()) {

                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                          ,modifier = Modifier.size(20.dp)
                    )
                    Text("Award Winning", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))
                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                        ,modifier = Modifier.size(20.dp)

                    )
                    Text("Drama", modifier = Modifier.padding(start = 8.dp,end = 44.dp), color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(Modifier.fillMaxWidth()) {

                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                          ,modifier = Modifier.size(20.dp)
                    )
                    Text("Comedy", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))
                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                        ,modifier = Modifier.size(20.dp)

                    )
                    Text("Adventure", modifier = Modifier.padding(start = 8.dp,end = 16.dp), color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(Modifier.fillMaxWidth()) {

                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                          ,modifier = Modifier.size(20.dp)
                    )
                    Text("Supernatural", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))
                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                        ,modifier = Modifier.size(20.dp)

                    )
                    Text("Romance", modifier = Modifier.padding(start = 8.dp,end = 22.dp), color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(Modifier.fillMaxWidth()) {

                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                          ,modifier = Modifier.size(20.dp)
                    )
                    Text("Sports", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))
                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                        ,modifier = Modifier.size(20.dp)

                    )
                    Text("Suspense", modifier = Modifier.padding(start = 8.dp,end = 19.dp), color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(Modifier.fillMaxWidth()) {

                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                          ,modifier = Modifier.size(20.dp)
                    )
                    Text("Horror", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))
                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                        ,modifier = Modifier.size(20.dp)

                    )
                    Text("Mystery", modifier = Modifier.padding(start = 8.dp,end = 33.dp), color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(Modifier.fillMaxWidth()) {

                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                          ,modifier = Modifier.size(20.dp)
                    )
                    Text("Sci-fi", modifier = Modifier.padding(start = 8.dp), color = MaterialTheme.colorScheme.onSecondary )
Spacer(modifier = Modifier.weight(1f))
                    Checkbox(
                        checked = false,
                        onCheckedChange = { }
                        ,modifier = Modifier.size(20.dp)

                    )
                    Text("Fantasy", modifier = Modifier.padding(start = 8.dp,end = 34.dp), color = MaterialTheme.colorScheme.onSecondary)
                }

                Spacer(modifier = Modifier.size(15.dp))
                Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(
                        onClick = { }
                        , colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                        , shape = RoundedCornerShape(15.dp)
                        , border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                        ,modifier = Modifier.height(35.dp)
                    ) {
                        Text(
                            text = "Apply"
                            , color = MaterialTheme.colorScheme.background
                        )
                    }
                    Button(
                        onClick = { }
                        , colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.background
                        )
                        , shape = RoundedCornerShape(15.dp)

                            ,modifier = Modifier.height(35.dp)
                    ) {
                        Text(
                            text = "Reset All"
                            , color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
                }

        }
    }
}

@Preview
@Composable
fun fil() {

}