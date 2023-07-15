package com.tugcearas.surveyapp_thirdhomework.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(
    val personalInfo: PersonalInfo,
    val bookName: String?,
    val songName: String?,
    val movieName: String?
):Parcelable
