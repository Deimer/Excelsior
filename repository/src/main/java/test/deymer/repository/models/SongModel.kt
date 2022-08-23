package test.deymer.repository.models

data class SongModel(
    val trackId: Int,
    val trackName: String,
    val trackPrice: String,
    val artistId: Int,
    val artistName: String,
    val albumId: Int,
    val albumName: String,
    val albumAvatar: String,
    val albumBackdrop: String,
    val albumPrice: String,
    val releaseDate: String,
    val preview: String
)