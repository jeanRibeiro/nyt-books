package com.newyorktimesbooks.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class BookResultsResponse (
    @Json(name = "book_details")
    val bookDetailResponse : List<BookDetailResponse>
)