package com.example.spotifyclone.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.spotifyclone.PlayerLayout
import com.example.spotifyclone.viewModel.RoomViewModel
import com.example.spotifyclone.viewModel.searchViewModel
import com.example.spotifyclone.viewModel.sharedViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchLayout(
    navController: NavHostController,
    roomViewModel: RoomViewModel,
    searchViewModel: searchViewModel,
    sharedViewModel : sharedViewModel
) {
    var searchQuery by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(true) }
    val searchHistoryList by roomViewModel.searchHistoryList.observeAsState()
    val searchResults by searchViewModel.searchResults.collectAsState()

    Scaffold (
        containerColor = Color.White
    ){paddingValues->
        Column () {
            SearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                onSearch = {
                    searchViewModel.getSearchResults(searchQuery)
                    active = false
                    roomViewModel.addSearchHistory(searchQuery)
                },
                active = active,
                onActiveChange = {
                    active = it
                },
                placeholder = {Text("Search Youtube")},
                leadingIcon = { IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                } },
                trailingIcon = {
                    if(active){
                        IconButton(onClick = {
                            searchQuery = ""
                        }) {
                            Icon(Icons.Default.Clear, contentDescription = null)
                        }
                    }
                },
                shape = ShapeDefaults.Large,
                enabled = true,
                shadowElevation = 8.dp
            ) {
                LazyColumn(
                    modifier = Modifier.padding(16.dp)
                ) {
                    items(items = searchHistoryList ?: emptyList()){history->
                        Text(history.title,
                            fontSize = 20.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.fillMaxWidth()
                                .padding(8.dp)
                                .clickable {
                                searchQuery = history.title
                            })
                    }
                }
            }
            if(searchResults==null){
                Text("Try Searching")
            }else{
                searchResultLayout(
                    item = searchResults!!.items,
                    paddingValues = PaddingValues(top = 16.dp),
                    onClick = {item->
                        sharedViewModel.updateSelectedItem(item)
                        navController.navigate(PlayerLayout)
                    }
                )
            }
        }
    }
}
