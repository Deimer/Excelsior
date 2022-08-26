package test.deymer.network.dto

import com.squareup.moshi.Json

data class SongDTO(
    @Json(name="trackId")
    val trackId: Int?,
    @Json(name="trackName")
    val trackName: String?,
    @Json(name="artistId")
    val artistId: Int?,
    @Json(name="artistName")
    val artistName: String?,
    @Json(name="trackPrice")
    val trackPrice: Float?,
    @Json(name="releaseDate")
    val releaseDate: String?,
    @Json(name="artworkUrl60")
    val artworkUrl60: String?,
    @Json(name="artworkUrl100")
    val artworkUrl100: String?,
    @Json(name="collectionId")
    val collectionId: Int?,
    @Json(name="collectionName")
    val collectionName: String?,
    @Json(name="collectionPrice")
    val collectionPrice: Float?,
    @Json(name="currency")
    val currency: String?,
    @Json(name="wrapperType")
    val wrapperType: String?,
    @Json(name="previewUrl")
    val previewUrl: String?,
    @Json(name="primaryGenreName")
    val primaryGenreName: String?,
    @Json(name="country")
    val country: String?
)