package test.deymer.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import test.deymer.database.constants.DatabaseConstants.Columns.ALBUM_NAME
import test.deymer.database.constants.DatabaseConstants.Columns.ARTIST_NAME
import test.deymer.database.entities.SongEntity
import test.deymer.database.constants.DatabaseConstants.Columns.TRACK_ID
import test.deymer.database.constants.DatabaseConstants.Columns.TRACK_NAME
import test.deymer.database.constants.DatabaseConstants.Tables.SONG_TABLE

@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongs(songs: List<SongEntity>)

    @Query("DELETE FROM $SONG_TABLE")
    suspend fun deleteSongs()

    @Query("SELECT * FROM $SONG_TABLE")
    suspend fun fetchSongs(): List<SongEntity>

    @Query("SELECT * FROM $SONG_TABLE WHERE $TRACK_ID = :songId")
    suspend fun fetchSongById(songId: Int): SongEntity

    @Query("SELECT * FROM $SONG_TABLE " +
            "WHERE $TRACK_NAME LIKE :term " +
            "OR $ARTIST_NAME LIKE :term " +
            "OR $ALBUM_NAME LIKE :term")
    suspend fun searchSong(term: String): List<SongEntity>
}