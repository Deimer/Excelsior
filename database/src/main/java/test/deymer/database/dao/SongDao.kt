package test.deymer.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import test.deymer.database.constants.DatabaseConstants.Columns.ID
import test.deymer.database.constants.DatabaseConstants.Tables.SONG_TABLE
import test.deymer.database.entities.SongEntity

@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongs(songs: List<SongEntity>)

    @Query("DELETE FROM $SONG_TABLE")
    suspend fun deleteSongs()

    @Query("SELECT * FROM $SONG_TABLE")
    suspend fun fetchSongs(): List<SongEntity>

    @Query("SELECT * FROM $SONG_TABLE WHERE $ID = :songId")
    suspend fun fetchSongById(songId: Int): SongEntity
}