package com.musnadil.myuas.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.musnadil.myuas.MainActivity
import com.musnadil.myuas.R

class Logout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dialog_konfirmasi = AlertDialog.Builder(this)
        dialog_konfirmasi.apply{
            setTitle("Logout")
            setMessage("Apakah anda yakin ingin log out?")
            setNegativeButton("Batal"){dialog,which->
                dialog.dismiss()
                finish()
            }
            setPositiveButton("Logout"){dialog,which->
                dialog.dismiss()
                startActivity( Intent(this@Logout,MasukActivity::class.java))
                onStop()
                finish()
            }
        }
        dialog_konfirmasi.show()
    }
}