@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.booktunes.ui.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.booktunes.ui.testBooks
import com.example.booktunes.ui.theme.BookTunesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookTunesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    BookTunesApp()
                }
            }
        }
    }
}

@Composable
fun BookTunesApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") { MainScreen(onclick = { navController.navigate("bookSelection") }) }
        composable("bookSelection") { BookSelectionScreen(books = testBooks) }
    }

}

@Composable
fun MainScreen(onclick: () -> Unit, modifier: Modifier = Modifier) {
    Scaffold(topBar = { TopBar() }) {
        Column(modifier = Modifier.padding(it)) {
            Text(text = "some text ")
            Button(onClick = onclick) {
                Text(text = "Book Selection Screen")
            }
        }
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = { Text("Book Tunes") },
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookTunesTheme {
        MainScreen(onclick = {})
    }
}