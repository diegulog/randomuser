package com.diegulog.randomuser.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Id(
	@field:SerializedName("name")
	val name: String?,

	@field:SerializedName("value")
	val value: String?
) : Parcelable