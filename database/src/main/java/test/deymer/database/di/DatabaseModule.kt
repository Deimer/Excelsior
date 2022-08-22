package test.deymer.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import test.deymer.database.constants.DatabaseConstants.KEY_NAME_DATABASE
import test.deymer.database.manager.ExcelsiorDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            ExcelsiorDatabase::class.java,
            KEY_NAME_DATABASE
        ).build()

    @Singleton
    @Provides
    fun provideMovieDao(
        database: ExcelsiorDatabase
    ) = database.getSongDao()
}