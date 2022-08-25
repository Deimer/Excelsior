package test.deymer.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import test.deymer.database.constants.DatabaseConstants.Tables
import test.deymer.database.constants.DatabaseConstants.Columns.ALBUM_AVATAR
import test.deymer.database.constants.DatabaseConstants.Columns.ALBUM_BACKDROP
import test.deymer.database.constants.DatabaseConstants.Columns.ALBUM_ID
import test.deymer.database.constants.DatabaseConstants.Columns.ALBUM_NAME
import test.deymer.database.constants.DatabaseConstants.Columns.ALBUM_PRICE
import test.deymer.database.constants.DatabaseConstants.Columns.ARTIST_ID
import test.deymer.database.constants.DatabaseConstants.Columns.ARTIST_NAME
import test.deymer.database.constants.DatabaseConstants.Columns.COUNTRY
import test.deymer.database.constants.DatabaseConstants.Columns.CURRENCY
import test.deymer.database.constants.DatabaseConstants.Columns.GENRE
import test.deymer.database.constants.DatabaseConstants.Columns.PREVIEW_URL
import test.deymer.database.constants.DatabaseConstants.Columns.RELEASE_DATE
import test.deymer.database.constants.DatabaseConstants.Columns.TRACK_ID
import test.deymer.database.constants.DatabaseConstants.Columns.TRACK_NAME
import test.deymer.database.constants.DatabaseConstants.Columns.TRACK_PRICE
import test.deymer.database.constants.DatabaseConstants.Columns.WRAPPER_TYPE

@Entity(tableName = Tables.SONG_TABLE)
data class SongEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = TRACK_ID)
    val trackId: Int,
    @ColumnInfo(name = TRACK_NAME)
    val trackName: String,
    @ColumnInfo(name = GENRE)
    val genreName: String,
    @ColumnInfo(name = ARTIST_ID)
    val artistId: Int,
    @ColumnInfo(name = ARTIST_NAME)
    val artistName: String,
    @ColumnInfo(name = TRACK_PRICE)
    val trackPrice: Float,
    @ColumnInfo(name = RELEASE_DATE)
    val releaseDate: String,
    @ColumnInfo(name = ALBUM_AVATAR)
    val albumAvatar: String,
    @ColumnInfo(name = ALBUM_BACKDROP)
    val albumBackdrop: String,
    @ColumnInfo(name = ALBUM_ID)
    val albumId: Int,
    @ColumnInfo(name = ALBUM_NAME)
    val albumName: String,
    @ColumnInfo(name = ALBUM_PRICE)
    val albumPrice: Float,
    @ColumnInfo(name = CURRENCY)
    val currency: String,
    @ColumnInfo(name = WRAPPER_TYPE)
    val wrapperType: String,
    @ColumnInfo(name = PREVIEW_URL)
    val previewUrl: String,
    @ColumnInfo(name = COUNTRY)
    val country: String
)