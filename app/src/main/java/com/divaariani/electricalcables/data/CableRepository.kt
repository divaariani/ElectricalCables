package com.divaariani.electricalcables.data

class CableRepository {
    private val favoriteCables: MutableList<Cable?> = mutableListOf()

    fun searchCables(query: String): List<Cable>{
        return CableData.cable.filter{
            it.name.contains(query, ignoreCase = true)
        }
    }

    fun favoriteCables(): List<Cable?> {
        return favoriteCables
    }

    fun addToFavorites(cable: Cable?) {
        if (cable != null && !favoriteCables.contains(cable)) {
            favoriteCables.add(cable)
        }
    }

    fun removeFromFavorites(cable: Cable?) {
        favoriteCables.remove(cable)
    }
}