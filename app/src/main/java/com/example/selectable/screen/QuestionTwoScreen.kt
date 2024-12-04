package com.example.selectable.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun QuestionTwoScreen(navController: NavHostController, prevScore: Int) {
    var selectedAnswers by remember { mutableStateOf(emptyList<Int>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "2. Какая страна первой отправила человека в космос?",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        val options = listOf(
            "США",
            "СССР",
            "Китай",
            "Франция"
        )
        options.forEachIndexed { index, option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = selectedAnswers.contains(index),
                    onCheckedChange = {
                        if (selectedAnswers.contains(index)) {
                            selectedAnswers = selectedAnswers - index
                        } else {
                            selectedAnswers = selectedAnswers + index
                        }
                    }
                )
                Text(text = option, style = MaterialTheme.typography.bodyLarge)
            }
        }
        Button(
            onClick = {
                val correctAnswers = setOf(1) // Correct answer index
                val score =
                    if (selectedAnswers.containsAll(correctAnswers) && selectedAnswers.size == correctAnswers.size) 1 else 0
                navController.navigate("question3/${prevScore + score}")
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Ответить")
        }
    }
}
