package test.deymer.datasource.local.song

import test.deymer.database.dao.SongDao
import test.deymer.database.entities.SongEntity
import javax.inject.Inject

class SongLocalDataSource @Inject constructor(
    private val songDao: SongDao
): ISongLocalDataSource {

    override suspend fun insertSongs(songs: List<SongEntity>) {
        songDao.insertSongs(songs)
    }

    override suspend fun deleteSongs() {
        songDao.deleteSongs()
    }

    override suspend fun fetchSongs() =
        songDao.fetchSongs()

    override suspend fun fetchSongById(songId: Int) =
        songDao.fetchSongById(songId)
}