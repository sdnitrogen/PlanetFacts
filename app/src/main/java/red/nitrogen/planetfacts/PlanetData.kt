package red.nitrogen.planetfacts

import android.os.Parcel
import android.os.Parcelable

data class PlanetData(
    val id:Int?,
    val name:String?,
    val galaxy:String?,
    val distance:String?,
    val gravity:String?,
    val rotation:String?,
    val revolution:String?,
    val radius:String?,
    val temperature:String?,
    val overview:String?,
    val structure:String?,
    val geology:String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(galaxy)
        parcel.writeString(distance)
        parcel.writeString(gravity)
        parcel.writeString(rotation)
        parcel.writeString(revolution)
        parcel.writeString(radius)
        parcel.writeString(temperature)
        parcel.writeString(overview)
        parcel.writeString(structure)
        parcel.writeString(geology)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlanetData> {
        override fun createFromParcel(parcel: Parcel): PlanetData {
            return PlanetData(parcel)
        }

        override fun newArray(size: Int): Array<PlanetData?> {
            return arrayOfNulls(size)
        }
    }

}
