package com.diegulog.randomuser.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Info(

	@field:SerializedName("seed")
	val seed: String,

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("results")
	val results: Int,

	@field:SerializedName("version")
	val version: String
) : Parcelable