package com.musnadil.myuas.WebServices

import com.musnadil.myuas.Models.RekapModel
import retrofit2.Call
import retrofit2.http.POST

interface ApiEndpoint {
    @POST("datajoin.php")
    fun dataHistoryMasuk(): Call<RekapModel>
}