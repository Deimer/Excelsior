package test.deymer.excelsior.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import test.deymer.repository.repositories.album.IAlbumRepository
import test.deymer.repository.repositories.song.ISongRepository
import test.deymer.usecase.album.GetSongsAlbumUseCase
import test.deymer.usecase.song.GetSongByIdUseCase
import test.deymer.usecase.song.SearchSongUseCase

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCaseModule {

    @Provides
    @ActivityRetainedScoped
    fun provideSearchSongUseCase(
        songRepository: ISongRepository
    ) = SearchSongUseCase(songRepository)

    @Provides
    @ActivityRetainedScoped
    fun provideGetSongByIdUseCase(
        songRepository: ISongRepository
    ) = GetSongByIdUseCase(songRepository)

    @Provides
    @ActivityRetainedScoped
    fun provideGetSongsAlbumUseCase(
        albumRepository: IAlbumRepository
    ) = GetSongsAlbumUseCase(albumRepository)
}