package com.diegulog.randomuser.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class Timezone(

	@field:SerializedName("offset")
	val offset: String,

	@field:SerializedName("description")
	val description: String
) : Parcelable