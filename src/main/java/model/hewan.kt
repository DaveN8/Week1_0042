package model

import android.os.Parcel
import android.os.Parcelable

data class hewan (
    var nama:String?,
    var jenis:String?,
    var usia:Int?
        ):Parcelable{
            constructor(parcel: Parcel):this(
                parcel.readString(),
                parcel.readString(),
                parcel.readValue(Int::class.java.classLoader) as? Int
            )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeString(jenis)
        parcel.writeValue(usia)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<hewan> {
        override fun createFromParcel(parcel: Parcel): hewan {
            return hewan(parcel)
        }

        override fun newArray(size: Int): Array<hewan?> {
            return arrayOfNulls(size)
        }
    }
}

