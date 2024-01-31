package com.example.booktunes.ui.mainActivity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.booktunes.R
import com.example.booktunes.ui.Book
import com.example.booktunes.ui.testBooks
import com.example.booktunes.ui.theme.BookTunesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookSelectionScreen(books: List<Book>, modifier: Modifier = Modifier) {
    Scaffold(floatingActionButton = { FloatingNewBookButton() }, modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 152.dp),
            modifier = Modifier.padding(it)
        ) {
            items(books) { book ->
                BookItem(
                    book = book,
                    {
                        //TODO: on card click

                    },
                    Modifier.padding(12.dp)
                )
            }
        }
    }
}

@Composable
fun FloatingNewBookButton() {
    ExtendedFloatingActionButton(
        onClick = { /*TODO*/ },
        icon = { Icon(Icons.Filled.Add, "Add new book") },
        text = { Text(text = "Add Book")}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookItem(book: Book, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        modifier = modifier,
        onClick = onClick
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = book.cover ?: R.drawable.default_cover),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(160.dp)
                    .padding(start = 12.dp, end = 12.dp, top = 12.dp)
            )
            Text(
                text = book.name,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .padding(12.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BookSelectionScreenPreview() {
    BookTunesTheme {
        Surface {
            BookSelectionScreen(testBooks, Modifier.fillMaxSize())
        }
    }
}