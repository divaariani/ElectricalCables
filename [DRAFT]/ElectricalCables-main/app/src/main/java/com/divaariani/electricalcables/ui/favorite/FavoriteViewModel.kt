package com.divaariani.electricalcables.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.divaariani.electricalcables.data.Cable

class FavoriteViewModel : ViewModel() {
    private val _favoriteCable = MutableLiveData<List<Cable>>()
    val favoriteCable: LiveData<List<Cable>> get() = _favoriteCable

    init{
        _favoriteCable.value = emptyList()
    }

    fun addFavoriteCable(cable: Cable){
        val currentList = _favoriteCable.value ?: emptyList()
        val updatedList = currentList.toMutableList()
        updatedList.add(cable)
        _favoriteCable.value = updatedList
    }

    fun removeFavoriteCable(cable: Cable){
        val currentList = _favoriteCable.value ?: emptyList()
        val updatedList = currentList.toMutableList()
        updatedList.remove(cable)
        _favoriteCable.value = updatedList
    }
}