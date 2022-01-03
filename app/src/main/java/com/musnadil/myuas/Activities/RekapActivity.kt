package com.musnadil.myuas.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.RecyclerView
import com.musnadil.myuas.Adapters.RekapAdapter
import com.musnadil.myuas.MainActivity
import com.musnadil.myuas.Models.RekapModel
import com.musnadil.myuas.R
import com.musnadil.myuas.Util.ApiRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_rekap.*
import kotlinx.android.synthetic.main.activity_rekap.toolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RekapActivity : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var rekapAdapter: RekapAdapter
    private lateinit var rvHistoryMasuk :RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rekap)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Rekap Masuk Keluar"

        setupList()
    }

    override fun onStart() {
        super.onStart()
        getHistoryMasuk()
    }

    private fun setupList(){
        rvHistoryMasuk = rv_hist_masuk
        rekapAdapter = RekapAdapter(arrayListOf())
        rvHistoryMasuk.adapter = rekapAdapter
    }
    private fun getHistoryMasuk(){
        api.dataHistoryMasuk().enqueue(object: Callback<RekapModel>{
            override fun onResponse(call: Call<RekapModel>, response: Response<RekapModel>) {
                if (response.isSuccessful){
                    val listHistoryMasuk = response.body()!!.history_masuk
                    rekapAdapter.setData(listHistoryMasuk)
                }
            }
            override fun onFailure(call: Call<RekapModel>, t: Throwable) {
                Log.e("RecapActivity",t.toString())
            }

        })
    }
}