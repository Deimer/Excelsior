package test.deymer.datasource.remote.album

import test.deymer.network.api.ApiService
import javax.inject.Inject

class AlbumRemoteDataSource @Inject constructor(
    private val apiService: ApiService
): IAlbumRemoteDataSource {

    override suspend fun getSongsAlbum(albumId: Int) =
        apiService.getSongsAlbum(albumId).results
}