package com.newyorktimesbooks.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookDetailResponse (
    @Json(name = "title")
    val titulo : String,
    @Json(name = "author")
    val autor : String,
    @Json(name = "description")
    val descricao : String
)