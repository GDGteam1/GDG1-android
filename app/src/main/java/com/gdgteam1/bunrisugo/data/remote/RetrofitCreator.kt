package com.gdgteam1.bunrisugo.data.remote

import com.gdgteam1.bunrisugo.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCreator {
    companion object {
        private const val baseUrl = "http://172.20.66.237:8080/"

        fun createRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun createOkHttpClient(): OkHttpClient {

            val interceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                interceptor.level = HttpLoggingInterceptor.Level.BODY
            }
            val builder = OkHttpClient.Builder()
            builder.addNetworkInterceptor(interceptor)

            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        }
    }
}