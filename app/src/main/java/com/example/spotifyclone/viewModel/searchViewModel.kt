package com.example.spotifyclone.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.example.example.youtubeSearch
import com.example.spotifyclone.data.ApiServiceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class searchViewModel(
    val repository: ApiServiceRepository
) : ViewModel() {
    private val _searchResults = MutableStateFlow<youtubeSearch?>(null)
    val searchResults : StateFlow<youtubeSearch?> = _searchResults

    fun getSearchResults(
        query: String
    ){
        viewModelScope.launch(Dispatchers.IO)
        {
            try {
                val results =  repository.getSearchResults(query = query)
                _searchResults.value = results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}