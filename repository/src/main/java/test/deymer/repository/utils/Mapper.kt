package test.deymer.repository.utils

import test.deymer.database.entities.SongEntity
import test.deymer.network.dto.SongDTO
import test.deymer.repository.models.SongModel

fun SongDTO.toEntity(): SongEntity {
    val dto = this
    return SongEntity(
        trackId = dto.trackId.orZero(),
        trackName = dto.trackName.orEmpty(),
        artistId = dto.artistId.orZero(),
        artistName = dto.artistName.orEmpty(),
        trackPrice = dto.trackPrice.orZero(),
        releaseDate = dto.releaseDate.orEmpty(),
        albumAvatar = dto.albumImageBig.orEmpty(),
        albumBackdrop = dto.albumImageSmall.orEmpty(),
        albumName = dto.albumName.orEmpty(),
        collectionId = dto.collectionId.orZero(),
        collectionName = dto.collectionName.orEmpty(),
        collectionPrice = dto.collectionPrice.orZero(),
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
        albumName = entity.albumName,
        collectionId = entity.collectionId,
        collectionName = entity.collectionName,
        collectionPrice = "${entity.currency} ${entity.collectionPrice}",
        preview = entity.previewUrl
    )
}