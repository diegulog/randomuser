package com.diegulog.randomuser.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Name(
	@field:SerializedName("title")
					val title: String,

	@field:SerializedName("last")
	val last: String,

	@field:SerializedName("first")
	val first: String
) : Parcelable