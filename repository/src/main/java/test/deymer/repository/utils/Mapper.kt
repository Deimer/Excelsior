package test.deymer.repository.utils

import test.deymer.database.entities.SongEntity
import test.deymer.network.dto.SongDTO
import test.deymer.repository.constants.RepositoryConstants.TAGS.TAG_NA
import test.deymer.repository.models.SongModel

fun SongDTO.toEntity(): SongEntity {
    val dto = this
    return SongEntity(
        trackId = dto.trackId.orZero(),
        trackName = dto.trackName.orEmpty().ifEmpty { TAG_NA },
        artistId = dto.artistId.orZero(),
        artistName = dto.artistName.orEmpty(),
        trackPrice = dto.trackPrice.toShortRound(),
        releaseDate = dto.releaseDate.orEmpty(),
        albumAvatar = dto.artworkUrl60.orEmpty(),
        albumBackdrop = dto.artworkUrl100.orEmpty(),
        albumId = dto.collectionId.orZero(),
        albumName = dto.collectionName.orEmpty(),
        albumPrice = dto.collectionPrice.toShortRound(),
        currency = dto.currency.orEmpty(),
        wrapperType = dto.wrapperType.orEmpty(),
        previewUrl = dto.previewUrl.orEmpty()
    )
}

fun SongEntity.toModel(): SongModel {
    val entity = this
    return SongModel(
        trackId = entity.trackId,
        trackName = entity.trackName,
        artistId = entity.artistId,
        artistName = entity.artistName,
        trackPrice = "${entity.currency} ${entity.trackPrice.orZero()}",
        releaseDate = entity.releaseDate.toHumanDate(),
        albumAvatar = entity.albumAvatar,
        albumBackdrop = entity.albumBackdrop,
        albumId = entity.albumId,
        albumName = entity.albumName,
        albumPrice = "${entity.currency} ${entity.albumPrice}",
        preview = entity.previewUrl
    )
}