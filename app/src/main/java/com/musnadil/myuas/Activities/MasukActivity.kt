package com.musnadil.myuas.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.musnadil.myuas.MainActivity
import com.musnadil.myuas.Models.ResponseLogin
import com.musnadil.myuas.R
import com.musnadil.myuas.Util.ApiRetrofit
import com.musnadil.myuas.databinding.ActivityMasukBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MasukActivity : AppCompatActivity() {
    private var binding : ActivityMasukBinding?=null
    private var nipy : String = ""
    private var pass : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMasukBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding!!.btnMasuk.setOnClickListener {
            nipy = binding!!.etNipy.text.toString()
            pass = binding!!.etPassword.text.toString()
            when {
                nipy == ""->{
                    binding!!.nipyWrap.error = "NIPY tidak boleh kosong"
                }
                pass == "" ->{
                    binding!!.passwordWrap.error = "Password tidak boleh kosong"
                } else ->{
                getData()
            }
            }
        }
    }
    private fun getData(){
        val api = ApiRetrofit().getInstance()
        api.login(nipy,pass).enqueue(object: Callback<ResponseLogin>{
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                if(response.isSuccessful){
                    if(response.body()?.response==true){
                        startActivity(Intent(this@MasukActivity, MainActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(
                            this@MasukActivity,
                            "Login gagal, periksa kembali NIPY dan Password",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this@MasukActivity,
                        "error response failure",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.e("Terjadi kesalahan","${t.message}")
            }

        })
    }
}