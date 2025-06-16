package com.example.spotifyclone.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.spotifyclone.util.YouTubePlayer
import com.example.spotifyclone.viewModel.sharedViewModel

@Composable
fun playerLayout(
    sharedViewModel: sharedViewModel
){
    val item by sharedViewModel.selectedItem.collectAsState(null)
    Scaffold {paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            val videoId = item?.id?.videoId // ?: "Q3iZyW2etm4" // Default videoId
            if (videoId != null) {
                YouTubePlayer(
                    youtubeVideoId = videoId,
                    lifecycleOwner = LocalLifecycleOwner.current
                )
            }

            Text(
                text = item?.snippet?.title.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,

            )
        }
    }
}