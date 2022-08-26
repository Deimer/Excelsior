package test.deymer.network.dto

import com.squareup.moshi.Json

data class BaseResponseDTO<T>(
    @Json(name="resultCount")
    val resultCount: Int?,
    @Json(name="results")
    val results: T
)