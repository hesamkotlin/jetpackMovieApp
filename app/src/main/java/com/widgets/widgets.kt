package com.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.model.Movie
import com.model.getMovies

@Preview
@Composable
fun movieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(movie.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(12.dp)), elevation = 6.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                Image(
                    painter = rememberImagePainter(data = movie.images[0], builder = {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }),
                    contentDescription = "Movie Poster"
                )

//                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie image")
            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(movie.title, style = MaterialTheme.typography.h6)
                Text("director:${movie.director}", style = MaterialTheme.typography.caption)
                Text("released: ${movie.year}")
            }

        }
    }
}