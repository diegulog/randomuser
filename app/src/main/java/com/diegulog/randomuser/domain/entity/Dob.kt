package com.diegulog.randomuser.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Keep
@Parcelize
data class Dob(
	@field:SerializedName("date")
	val date: Date,

	@field:SerializedName("age")
	val age: Int
) : Parcelable{

	fun getDateFormat(): String{
		val format = SimpleDateFormat("dd/MM/yyyy", Locale.ROOT)
		return format.format(date)
	}
}