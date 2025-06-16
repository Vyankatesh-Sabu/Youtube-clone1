package com.example.spotifyclone.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.example.Items

@Composable
fun CroppedCardImage(
    item: Items,
    onClick : () -> Unit) {
    val cropAmount = 78.dp
    val thumbnails = item.snippet.thumbnails
    val originalHeight = (thumbnails.high.height ?: 371).toInt().dp
    val url = thumbnails.high.url ?: "https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?cs=srgb&dl=pexels-souvenirpixels-414612.jpg&fm=jpg"

    Card(
        modifier = Modifier.padding(vertical = 0.dp)
            .clickable {
                onClick()
            },
        colors = CardDefaults.cardColors().copy(Color.White),
        shape = RoundedCornerShape(0.dp),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(originalHeight - (cropAmount * 2))
                .clipToBounds()

        ) {
            AsyncImage(
                model = url,
                contentDescription = "Cropped Image",
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(originalHeight) // Use full image height
                    .align(Alignment.Center) // Center image in parent so both top & bottom get cropped
            )
        }
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(
                text = item.snippet.title ?: "Title Failure - Plz Try again",
                fontSize = 14.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Text(
                text = item.snippet.publishTime.toString(),
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 16.dp),
                color = Color.LightGray
            )
        }

    }
}