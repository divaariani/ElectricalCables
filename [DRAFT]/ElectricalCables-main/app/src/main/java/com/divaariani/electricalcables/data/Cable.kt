package com.divaariani.electricalcables.data

import android.os.Parcel
import android.os.Parcelable

data class Cable(
    val id: Int,
    val name: String,
    val photoUrl: String,
    val application: String,
    val specification: String,
    val construction: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(photoUrl)
        parcel.writeString(application)
        parcel.writeString(specification)
        parcel.writeString(construction)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cable> {
        override fun createFromParcel(parcel: Parcel): Cable {
            return Cable(parcel)
        }

        override fun newArray(size: Int): Array<Cable?> {
            return arrayOfNulls(size)
        }
    }
}