package test.deymer.repository.repositories.song

import test.deymer.datasource.local.song.ISongLocalDataSource
import test.deymer.datasource.remote.song.ISongRemoteDataSource
import test.deymer.repository.models.SongModel
import test.deymer.repository.utils.OnResult
import test.deymer.repository.utils.toEntity
import test.deymer.repository.utils.toModel
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class SongRepository @Inject constructor(
    private val songRemoteDataSource: ISongRemoteDataSource,
    private val songLocalDataSource: ISongLocalDataSource
): ISongRepository {

    override suspend fun deleteSongs() {
        songLocalDataSource.deleteSongs()
    }

    override suspend fun getSongDetail(songId: Int): OnResult<SongModel> {
        return try {
            val song = songRemoteDataSource.getSongDetail(songId).first().toEntity()
            songLocalDataSource.insertSongs(listOf(song))
            OnResult.Success(songLocalDataSource.fetchSongById(songId).toModel())
        } catch (ioException: IOException) {
            OnResult.Error(ioException)
        } catch (exception: Exception) {
            OnResult.Error(exception)
        }
    }

    override suspend fun fetchSongById(songId: Int): OnResult<SongModel> {
        return try {
            OnResult.Success(songLocalDataSource.fetchSongById(songId).toModel())
        } catch (ioException: IOException) {
            OnResult.Error(ioException)
        } catch (exception: Exception) {
            OnResult.Error(exception)
        }
    }

    override suspend fun searchSong(term: String): OnResult<List<SongModel>> {
        return try {
            val songsSearch = songRemoteDataSource.searchSongs(term).map { it.toEntity() }
            songLocalDataSource.insertSongs(songsSearch)
            OnResult.Success(songLocalDataSource.fetchSongs().map { it.toModel() })
        } catch (ioException: IOException) {
            OnResult.Error(ioException)
        } catch (exception: Exception) {
            OnResult.Error(exception)
        }
    }
}