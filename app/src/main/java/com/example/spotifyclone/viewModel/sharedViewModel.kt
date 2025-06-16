package com.example.spotifyclone.viewModel

import androidx.lifecycle.ViewModel
import com.example.example.Items
import kotlinx.coroutines.flow.MutableStateFlow

class sharedViewModel : ViewModel() {
    private val _selectedItem = MutableStateFlow<Items?>(null)
    val selectedItem = _selectedItem

    fun updateSelectedItem(item : Items){
        _selectedItem.value = item
    }
}