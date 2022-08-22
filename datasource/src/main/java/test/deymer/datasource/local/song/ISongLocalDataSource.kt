package test.deymer.datasource.local.song

import test.deymer.database.entities.SongEntity

interface ISongLocalDataSource {

    suspend fun insertSongs(songs: List<SongEntity>)

    suspend fun deleteSongs()

    suspend fun fetchSongs(): List<SongEntity>

    suspend fun fetchSongById(songId: Int): SongEntity
}