package test.deymer.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import test.deymer.network.BuildConfig
import test.deymer.network.api.ApiService
import test.deymer.network.constants.NetworkConstants.DEFAULTS.DEFAULT_TIMEOUT
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ActivityRetainedComponent::class)
object ApiModule {

    @Provides
    fun provideOkHttpClientApi(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .callTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) okHttpClient.addInterceptor(logging)
        return okHttpClient.build()
    }

    @Provides
    fun provideRetrofitApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(provideOkHttpClientApi())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiApi(): ApiService {
        return provideRetrofitApi()
            .create(ApiService::class.java)
    }
}