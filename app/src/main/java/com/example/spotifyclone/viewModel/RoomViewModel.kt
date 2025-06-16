package com.example.spotifyclone.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spotifyclone.MainApplication
import com.example.spotifyclone.db.model.searchHistory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant

class RoomViewModel : ViewModel() {

    val searchHistoryDao = MainApplication.searchHistoryDB.getAllsearches()
    val searchHistoryList : LiveData<List<searchHistory>> = searchHistoryDao.getSearchHistory()

    fun addSearchHistory(titile : String){
        viewModelScope.launch(Dispatchers.IO) {
            searchHistoryDao.addSearch(searchHistory(
                title = titile, createdAt = Instant.now().toEpochMilli()
            ))
        }
    }

    fun deleteSearchHistory(id: Long){
        viewModelScope.launch(Dispatchers.IO) {
            searchHistoryDao.deleteSearch(id = id)
        }
    }

}