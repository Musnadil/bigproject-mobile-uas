package com.musnadil.myuas.Models

data class RekapModel (
    val history_masuk :List<Data_masuk>
){
    data class Data_masuk(
        val nomer_plat:String?,
        val tanggal:String?,
        val waktu_masuk:String?,
        val waktu_keluar:String?
    )
}