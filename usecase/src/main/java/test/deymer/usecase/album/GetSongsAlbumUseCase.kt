package test.deymer.usecase.album

import test.deymer.repository.repositories.album.IAlbumRepository
import javax.inject.Inject

class GetSongsAlbumUseCase @Inject constructor(
    private val albumRepository: IAlbumRepository
) {

    suspend fun invoke(albumId: Int) =
        albumRepository.getSongsAlbum(albumId)
}