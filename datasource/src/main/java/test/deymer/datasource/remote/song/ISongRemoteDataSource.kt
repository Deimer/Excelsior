package test.deymer.datasource.remote.song

import test.deymer.network.dto.SongDTO

interface ISongRemoteDataSource {

    suspend fun searchSongs(
        term: String
    ): List<SongDTO>

    suspend fun getSongDetail(
        songId: Int
    ): List<SongDTO>
}