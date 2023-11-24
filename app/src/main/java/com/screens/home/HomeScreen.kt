package com.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.model.Movie
import com.model.getMovies
import com.navigation.MovieScreens
import com.widgets.movieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
            Text("Movies")
        }

    }) {
        mainContent(navController)
    }

}
@Composable
fun mainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(movieList) {
                movieRow(movie = it ) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie/50")

                }
            }
        }
    }
}
