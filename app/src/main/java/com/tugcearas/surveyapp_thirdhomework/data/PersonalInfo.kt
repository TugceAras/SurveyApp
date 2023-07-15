package com.tugcearas.surveyapp_thirdhomework.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonalInfo(
    val nameSurname:String?,
    val mail:String?,
    val phoneNumber:String?,
    val city:String?
):Parcelable
