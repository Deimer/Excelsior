package test.deymer.usecase.song

import test.deymer.repository.repositories.song.ISongRepository
import javax.inject.Inject

class SearchSongUseCase @Inject constructor(
    private val songRepository: ISongRepository
) {

    suspend fun invoke(term: String, offset: Int) =
        songRepository.searchSong(term, offset)
}