package com.example.spotifyclone.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.example.Items
import com.example.spotifyclone.util.CroppedCardImage

@Composable
fun searchResultLayout(
    item: List<Items>,
    paddingValues: PaddingValues,
    onClick : (Items) -> Unit){
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
    ) {
        items(item) {item->
            CroppedCardImage(
                item = item,
                onClick = {
                    onClick(item)
                }
            )
        }
    }
}

