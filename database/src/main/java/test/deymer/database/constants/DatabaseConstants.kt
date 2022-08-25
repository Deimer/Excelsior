package test.deymer.database.constants

object DatabaseConstants {

    const val DATABASE_VERSION = 1
    const val KEY_NAME_DATABASE = "excelsior_database"

    object Tables {
        const val SONG_TABLE = "song_table"
    }

    object Columns {
        const val TRACK_ID = "track_id"
        const val TRACK_NAME = "track_name"
        const val ARTIST_ID = "artist_id"
        const val ARTIST_NAME = "artist_name"
        const val TRACK_PRICE = "track_price"
        const val RELEASE_DATE = "release_date"
        const val ALBUM_AVATAR = "album_avatar"
        const val ALBUM_BACKDROP = "album_backdrop"
        const val ALBUM_ID = "album_id"
        const val ALBUM_NAME = "album_name"
        const val ALBUM_PRICE = "album_price"
        const val CURRENCY = "currency"
        const val WRAPPER_TYPE = "wrapper_type"
        const val PREVIEW_URL = "preview_url"
        const val GENRE = "genre_name"
        const val COUNTRY = "country"
    }
}