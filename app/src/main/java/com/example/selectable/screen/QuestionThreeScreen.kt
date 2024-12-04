package com.example.selectable.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.selectable.R

@Composable
fun QuestionThreeScreen(navController: NavHostController, prevScore: Int) {
    var selectedImage by remember { mutableIntStateOf(-1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "3. Кто из этих людей был президентом США?",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        val options = listOf(
            painterResource(id = R.drawable.washington),
            painterResource(id = R.drawable.lincoln),
            painterResource(id = R.drawable.einstein),
            painterResource(id = R.drawable.elvis)
        )
        options.forEachIndexed { index, image ->
            Box(modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clickable { selectedImage = index }
                        .border(2.dp, if (selectedImage == index) Color.Blue else Color.Transparent)
                )
            }
        }
        Button(
            onClick = {
                val score = if (selectedImage == 1) 1 else 0 // Correct answer index
                navController.navigate("results/${prevScore + score}")
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Ответить")
        }
    }
}