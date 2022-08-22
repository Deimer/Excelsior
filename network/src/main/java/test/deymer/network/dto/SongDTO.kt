package test.deymer.network.dto

import com.google.gson.annotations.SerializedName

data class SongDTO(
    @SerializedName("trackId")
    val trackId: String?,
    @SerializedName("trackName")
    val trackName: String?,
    @SerializedName("artistId")
    val artistId: Int?,
    @SerializedName("artistName")
    val artistName: String?,
    @SerializedName("trackPrice")
    val trackPrice: Float?,
    @SerializedName("releaseDate")
    val releaseDate: String?,
    @SerializedName("artworkUrl60")
    val albumImageSmall: String?,
    @SerializedName("artworkUrl100")
    val albumImageBig: String?,
    @SerializedName("collectionName")
    val albumName: String?,
    @SerializedName("collectionId")
    val collectionId: Int?,
    @SerializedName("collectionName")
    val collectionName: String?,
    @SerializedName("collectionPrice")
    val collectionPrice: Float?,
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("wrapperType")
    val wrapperType: String?,
    @SerializedName("previewUrl")
    val previewUrl: String?,
    @SerializedName("primaryGenreName")
    val primaryGenreName: String?
)