package com.gdgteam1.bunrisugo.data.remote

import com.gdgteam1.bunrisugo.data.remote.model.ResponseBadge
import com.gdgteam1.bunrisugo.data.remote.model.ResponseCategory
import com.gdgteam1.bunrisugo.data.remote.model.ResponseStep
import okhttp3.MultipartBody

class DataSource {
    val service = RetrofitCreator.createRetrofit().create(Bunrisugo::class.java)
    suspend fun getRecentBadgeList(): ResponseBadge {
        return service.getRecentBadgeList()
    }

    suspend fun getRecentCategoryList(): ResponseCategory {
        return service.getRecentCategoryList()
    }

    suspend fun getAllBadgeList(): ResponseBadge {
        return service.getAllBadgeList()
    }

    suspend fun getAllCategoryList(): ResponseCategory {
        return service.getAllCategoryList()
    }

    suspend fun getGuide(file: MultipartBody.Part): ResponseStep {
        return service.getGuide(file)
    }
}