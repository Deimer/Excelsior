package test.deymer.datasource.remote.song

import test.deymer.network.api.ApiService
import javax.inject.Inject

class SongRemoteDataSource @Inject constructor(
    private val apiService: ApiService
): ISongRemoteDataSource {

    override suspend fun searchSongs(term: String, offset: Int) =
        apiService.searchSongs(term = term, offset = offset).results
}