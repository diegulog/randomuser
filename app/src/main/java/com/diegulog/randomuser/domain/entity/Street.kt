package com.diegulog.randomuser.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Street(

	@field:SerializedName("number")
	val numberStreet: Int,

	@field:SerializedName("name")
	val nameStreet: String
) : Parcelable