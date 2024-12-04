package com.example.selectable.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.selectable.screen.MainMenu
import com.example.selectable.screen.QuestionOneScreen
import com.example.selectable.screen.QuestionThreeScreen
import com.example.selectable.screen.QuestionTwoScreen
import com.example.selectable.screen.ResultsScreen

@Composable
fun NavApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainMenu") {
        composable("mainMenu") { MainMenu(navController) }
        composable("question1") {
            QuestionOneScreen(navController)
        }
        composable("question2/{prevScore}") { backStackEntry ->
            QuestionTwoScreen(
                navController,
                backStackEntry.arguments?.getString("prevScore")?.toInt() ?: 0
            )
        }
        composable("question3/{prevScore}") { backStackEntry ->
            QuestionThreeScreen(
                navController,
                backStackEntry.arguments?.getString("prevScore")?.toInt() ?: 0
            )
        }
        composable("results/{score}") { backStackEntry ->
            ResultsScreen(navController, backStackEntry.arguments?.getString("score") ?: "0")
        }
    }
}