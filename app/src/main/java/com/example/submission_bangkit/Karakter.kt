package com.example.submission_bangkit

import android.os.Parcel
import android.os.Parcelable

//@Parcelize
data class Karakter(
    val name: String?,
    val description: String?,
    val photo: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Karakter> {
        override fun createFromParcel(parcel: Parcel): Karakter {
            return Karakter(parcel)
        }

        override fun newArray(size: Int): Array<Karakter?> {
            return arrayOfNulls(size)
        }
    }
}
