package com.example.spotifyclone.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.example.Items
import com.example.spotifyclone.R
import com.example.spotifyclone.SearchLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeLayout(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )

        Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                Topbar(
                    scrollBehavior = scrollBehavior,
                    navController = navController
                )
            }
        ) {paddingValues ->
            Surface(modifier = Modifier.padding(paddingValues)){
                Text("Remove comment mark")
            }
            //screenContent(modifier = Modifier.padding(paddingValues))
        }

}


@Composable
fun screenContent(modifier: Modifier) {

        Box(
            modifier = modifier
        ) {
            var search by remember { mutableStateOf<List<Items>?>(null) }

//            LaunchedEffect(true) {
//                withContext(Dispatchers.IO){
//                    val result: youtubeSearch = client.getSearches(
//                        "Career247",
//                        "snippet,id",
//                        regionCode = "IN",
//                        maxResults = 50,
//                        order = "date",
//                        pageToken = null
//                    )
//                    search = result.items // Assuming `items` is a list in `youtubeSearch`
//                }
//            }

//            LazyColumn {
//                search?.let { items ->
//                    itemsIndexed(items) { index, item ->
//                        Text(index.toString())
//                        item.id.playlistId?.let {
//                            Text(text = it)
//                            println(it + ": Video id ")
//                        }
//                        Text(item.snippet.thumbnails.medium?.url ?: "Url NOt Found")
//                        println("Image URL: ${item.snippet.thumbnails.medium?.url}")
//                        CroppedCardImage(item)
//                    }
//                }
//            }
//                    YouTubePlayer("wEvnVODxa_c", lifecycleOwner = LocalLifecycleOwner.current)
        }
//            }

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topbar(
    scrollBehavior: TopAppBarScrollBehavior,
    navController: NavHostController
){
    TopAppBar(
        title = {
            Image(
                painter = painterResource(R.drawable.yt_logo_pms_light),
                contentDescription = null,
                modifier = Modifier.size(width = 90.dp, height = 20.dp)
                )
        },
        actions = {
            Icon(
                painter =  painterResource(R.drawable.baseline_search_24),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { navController.navigate(SearchLayout) })
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.6f)
        ),
        scrollBehavior = scrollBehavior

    )
}

