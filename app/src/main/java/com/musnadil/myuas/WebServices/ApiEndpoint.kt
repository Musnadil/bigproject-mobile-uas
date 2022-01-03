package com.musnadil.myuas.WebServices

import com.musnadil.myuas.Models.RekapModel
import com.musnadil.myuas.Models.ResponseLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiEndpoint {
    @POST("datajoin.php")
    fun dataHistoryMasuk(): Call<RekapModel>

    @FormUrlEncoded
    @POST("login.php")
    fun login(
        @Field("post_nipy") nipy : String,
        @Field("post_password") pass : String
    ):Call<ResponseLogin>
}