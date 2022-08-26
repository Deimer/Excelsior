package test.deymer.repository.repositories.song

import test.deymer.repository.models.SongModel
import test.deymer.repository.utils.OnResult

interface ISongRepository {

    suspend fun deleteSongs()

    suspend fun fetchSongById(songId: Int): OnResult<SongModel>

    suspend fun searchSong(term: String, offset: Int): OnResult<List<SongModel>>
}