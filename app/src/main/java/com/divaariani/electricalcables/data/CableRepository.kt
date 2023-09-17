package com.divaariani.electricalcables.data

class CableRepository {
    fun searchCables(query: String): List<Cable>{
        return CableData.cable.filter{
            it.name.contains(query, ignoreCase = true)
        }
    }

    fun favoriteCables(): List<Cable>{
        return CableData.cable
    }
}