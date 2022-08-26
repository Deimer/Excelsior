package test.deymer.repository.repositories.album

import test.deymer.repository.models.SongModel
import test.deymer.repository.utils.OnResult

interface IAlbumRepository {

    suspend fun getSongsAlbum(
        albumId: Int
    ): OnResult<List<SongModel>>
}