package com.diegulog.randomuser.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Coordinates(

	@field:SerializedName("latitude")
	val latitude: String,

	@field:SerializedName("longitude")
	val longitude: String
) : Parcelable