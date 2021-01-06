package com.newyorktimesbooks.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class BookBodyResponse (
    @Json(name = "results")
    val bookResults: List<BookResultsResponse>
)