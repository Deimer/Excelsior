package test.deymer.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import test.deymer.network.constants.NetworkConstants.DEFAULTS.DEFAULT_ENTITY
import test.deymer.network.constants.NetworkConstants.DEFAULTS.DEFAULT_LIMIT
import test.deymer.network.constants.NetworkConstants.DEFAULTS.DEFAULT_MEDIA_TYPE
import test.deymer.network.constants.NetworkConstants.QUERIES.ENTITY
import test.deymer.network.constants.NetworkConstants.QUERIES.ID
import test.deymer.network.constants.NetworkConstants.QUERIES.LIMIT
import test.deymer.network.constants.NetworkConstants.QUERIES.MEDIA_TYPE
import test.deymer.network.constants.NetworkConstants.QUERIES.TERM
import test.deymer.network.constants.NetworkConstants.URLs
import test.deymer.network.dto.BaseResponseDTO
import test.deymer.network.dto.SongDTO

interface ApiService {

    @GET(URLs.SEARCH_PATH)
    suspend fun searchSongs(
        @Query(TERM) term: String,
        @Query(LIMIT) limit: Int = DEFAULT_LIMIT,
        @Query(MEDIA_TYPE) mediaType: String = DEFAULT_MEDIA_TYPE
    ): BaseResponseDTO<List<SongDTO>>

    @GET(URLs.LOOKUP_PATH)
    suspend fun getSongsAlbum(
        @Query(ID) id: Int,
        @Query(ENTITY) entity: String = DEFAULT_ENTITY
    ): BaseResponseDTO<List<SongDTO>>
}