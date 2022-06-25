package com.gdgteam1.bunrisugo.data.remote

import com.gdgteam1.bunrisugo.data.remote.model.ResponseBadge
import com.gdgteam1.bunrisugo.data.remote.model.ResponseCategory
import com.gdgteam1.bunrisugo.data.remote.model.ResponseStep
import okhttp3.MultipartBody
import retrofit2.http.*

interface Bunrisugo {
    @GET("user/badges/recent/1")
    suspend fun getRecentBadgeList(): ResponseBadge

    @GET("user/categories/recent")
    suspend fun getRecentCategoryList(@Query("userId") userId: Int = 1,
                                      @Query("size") size: Int = 4): ResponseCategory

    @GET("user/badges/all")
    suspend fun getAllBadgeList(@Query("userId") userId: Int = 1): ResponseBadge

    @GET("user/categories/all")
    suspend fun getAllCategoryList(@Query("userId") userId: Int = 1): ResponseCategory

    @Multipart
    @POST("image-detect")
    suspend fun getGuide(@Part file: MultipartBody.Part): ResponseStep
}