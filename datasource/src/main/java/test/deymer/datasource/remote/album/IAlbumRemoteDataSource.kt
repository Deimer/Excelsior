package test.deymer.datasource.remote.album

import test.deymer.network.dto.SongDTO

interface IAlbumRemoteDataSource {

    suspend fun getSongsAlbum(
        albumId: Int
    ): List<SongDTO>
}