package com.example.week_5_assignment_1.model

import android.os.Parcel
import android.os.Parcelable

data class posts (
        val user : String? = null,
        val profile: String? = null,
        val status  : String? = null,
        val link : String? = null

        ):Parcelable{
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(user)
                parcel.writeString(profile)
                parcel.writeString(status)
                parcel.writeString(link)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<posts> {
                override fun createFromParcel(parcel: Parcel): posts {
                        return posts(parcel)
                }

                override fun newArray(size: Int): Array<posts?> {
                        return arrayOfNulls(size)
                }
        }
}