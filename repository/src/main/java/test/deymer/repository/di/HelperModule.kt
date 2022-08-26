package test.deymer.repository.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import test.deymer.repository.helpers.CheckNetworkHelper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HelperModule {

    @Singleton
    @Provides
    fun provideCheckNetwork(
        @ApplicationContext context: Context
    ) = CheckNetworkHelper(context)
}