package com.example.week_5_assignment_1.model

import android.os.Parcel
import android.os.Parcelable

data class user (
    var etcovid : Int? = null,
    var etfname : String? = null,
    var etlname : String? = null,
    var etusername : String? = null,
    var etpassword : String? = null,
    var etimage : String? = null

):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(etcovid)
        parcel.writeString(etfname)
        parcel.writeString(etlname)
        parcel.writeString(etusername)
        parcel.writeString(etpassword)
        parcel.writeString(etimage)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<user> {
        override fun createFromParcel(parcel: Parcel): user {
            return user(parcel)
        }

        override fun newArray(size: Int): Array<user?> {
            return arrayOfNulls(size)
        }
    }


}