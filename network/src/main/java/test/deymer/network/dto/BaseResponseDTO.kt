package test.deymer.network.dto

import com.google.gson.annotations.SerializedName

class BaseResponseDTO<T>(
    @SerializedName("resultCount")
    val resultCount: Int?,
    @SerializedName("results")
    val results: T
)