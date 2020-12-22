package com.nytimespopular.assigenment.di

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.nytimespopular.assigenment.BuildConfig
import com.nytimespopular.assigenment.data.network.ApiService
import com.nytimespopular.assigenment.data.network.NetworkHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    single { provideOkHttpClient() }
    single { provideApiService(get()) }
    single { provideNetworkHelper(get()) }
}


private fun provideNetworkHelper(context: Context) = NetworkHelper(context)

/**
 * Create Provider for OkHttp Client
 * if app is in debug mode then api response will not log in logcate
 */
private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .readTimeout(15, TimeUnit.SECONDS).
        connectTimeout(15, TimeUnit.SECONDS)
        .build()
} else {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE

    OkHttpClient
        .Builder().addInterceptor(loggingInterceptor).readTimeout(20, TimeUnit.SECONDS)
        .connectTimeout(20, TimeUnit.SECONDS)
        .build()
}

/**
 * Create Provider for Rest Clint
 * this taking one parameter
 * @param okHttpClient OkHtpp clint
 */
private fun provideApiService(
    okHttpClient: OkHttpClient
): ApiService =
    Retrofit.Builder()
        .addConverterFactory(JacksonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build().create(ApiService::class.java)


