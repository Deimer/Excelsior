package test.deymer.datasource.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import test.deymer.datasource.remote.song.ISongRemoteDataSource
import test.deymer.datasource.remote.song.SongRemoteDataSource

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindSongRemoteDataSource(
        implRemoteDataSource: SongRemoteDataSource
    ): ISongRemoteDataSource
}