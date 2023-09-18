package br.com.fiap.hello

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.navArgument
import br.com.fiap.hello.screens.AnnouncementScreen
import br.com.fiap.hello.screens.ListOfAnnouncementsScreen
import br.com.fiap.hello.screens.LoginScreen
import br.com.fiap.hello.screens.SplashScreen
import br.com.fiap.hello.ui.theme.HelloTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "splash",
                    ) {
                        composable(route = "splash") {
                            SplashScreen(navController)
                        }
                        composable(route = "login") {
                            LoginScreen(navController)
                        }
                        composable(route = "listOfAnnouncements") {
                            ListOfAnnouncementsScreen(navController)
                        }
                        composable(route = "announcement?announcementId={announcementId}",
                            arguments = listOf(navArgument(name = "announcementId") {
                                defaultValue = 0
                            })
                        ) {
                            val announcementId = it.arguments?.getInt("announcementId")!!
                            AnnouncementScreen(id = announcementId, navController)
                        }
                    }
                }
            }
        }
    }
}