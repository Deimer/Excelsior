package test.deymer.usecase.song

import test.deymer.repository.repositories.song.ISongRepository
import javax.inject.Inject

class GetSongByIdUseCase @Inject constructor(
    private val songRepository: ISongRepository
) {

    suspend fun invoke(songId: Int) =
        songRepository.fetchSongById(songId)
}