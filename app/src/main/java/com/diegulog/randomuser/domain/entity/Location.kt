package com.diegulog.randomuser.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Location(

    @field:SerializedName("country")
	val country: String,

    @field:SerializedName("city")
	val city: String,

    @Embedded
    @field:SerializedName("street")
	val street: Street,

    @Embedded
    @field:SerializedName("timezone")
	val timezone: Timezone,

    @field:SerializedName("postcode")
	val postcode: String,

    @Embedded
    @field:SerializedName("coordinates")
	val coordinates: Coordinates,

    @field:SerializedName("state")
	val state: String
) : Parcelable {
    fun fullAddress(): String {
        val streetInfo = "${street.numberStreet} ${street.nameStreet}"
        return "$streetInfo, $city, $state, $country, $postcode"
    }
}