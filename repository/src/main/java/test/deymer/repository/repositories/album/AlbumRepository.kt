package test.deymer.repository.repositories.album

import test.deymer.datasource.remote.album.IAlbumRemoteDataSource
import test.deymer.repository.constants.RepositoryConstants.TAGS.TAG_TRACK
import test.deymer.repository.models.SongModel
import test.deymer.repository.utils.OnResult
import test.deymer.repository.utils.toModel
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class AlbumRepository @Inject constructor(
    private val songRemoteDataSource: IAlbumRemoteDataSource
): IAlbumRepository {

    override suspend fun getSongsAlbum(albumId: Int): OnResult<List<SongModel>> {
        return try {
            val songs = songRemoteDataSource.getSongsAlbum(albumId)
                .filter { it.wrapperType == TAG_TRACK }
                .map { it.toModel() }
            OnResult.Success(songs)
        } catch (ioException: IOException) {
            OnResult.Error(ioException)
        } catch (exception: Exception) {
            OnResult.Error(exception)
        }
    }
}