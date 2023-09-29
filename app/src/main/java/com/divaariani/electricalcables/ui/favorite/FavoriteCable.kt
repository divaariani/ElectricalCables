package com.divaariani.electricalcables.ui.favorite

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "favorite_cable")
data class FavoriteCable(
    @PrimaryKey
    val id: Int,
    val name: String,
    val photoUrl: String
): Serializable