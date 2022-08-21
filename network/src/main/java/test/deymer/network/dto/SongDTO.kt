package test.deymer.network.dto

import com.google.gson.annotations.SerializedName

data class SongDTO(
    @SerializedName("artistId")
    val artistId: Int,
    @SerializedName("trackName")
    val trackName: String,
    @SerializedName("artistName")
    val artistName: String,
    @SerializedName("artworkUrl60")
    val albumImageSmall: String,
    @SerializedName("artworkUrl100")
    val albumImageBig: String,
    @SerializedName("collectionName")
    val albumName: String,
    @SerializedName("collectionId")
    val collectionId: Int,
    @SerializedName("collectionName")
    val collectionName: String,
    @SerializedName("wrapperType")
    val wrapperType: String,
    @SerializedName("previewUrl")
    val previewUrl: String
)