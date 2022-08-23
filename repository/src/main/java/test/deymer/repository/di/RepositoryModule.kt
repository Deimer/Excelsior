package test.deymer.repository.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import test.deymer.repository.repositories.song.ISongRepository
import test.deymer.repository.repositories.song.SongRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSongRepository(
        implRepository: SongRepository
    ): ISongRepository
}