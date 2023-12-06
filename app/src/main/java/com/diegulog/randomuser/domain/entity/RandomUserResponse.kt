package com.diegulog.randomuser.domain.entity

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
@Parcelize
data class RandomUserResponse(

	@field:SerializedName("results")
	val results: List<User>,

	@field:SerializedName("info")
	val info: Info
) : Parcelable

