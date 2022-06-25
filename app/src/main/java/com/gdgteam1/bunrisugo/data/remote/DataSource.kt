package com.gdgteam1.bunrisugo.data.remote

class DataSource {
    val service = RetrofitCreator.createRetrofit().create(Bunrisugo::class.java)
}