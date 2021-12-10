package com.amalip.students.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Error(

    val error: Int,
    val message: String

)
