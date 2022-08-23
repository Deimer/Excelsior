package test.deymer.excelsior.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import test.deymer.repository.repositories.song.ISongRepository
import test.deymer.usecase.song.SearchSongUseCase

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCaseModule {

    @Provides
    @ActivityRetainedScoped
    fun provideSearchSongUseCase(
        songRepository: ISongRepository
    ) = SearchSongUseCase(songRepository)
}