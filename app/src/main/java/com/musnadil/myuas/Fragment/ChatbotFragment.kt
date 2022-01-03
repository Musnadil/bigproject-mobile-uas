package com.musnadil.myuas.Fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.musnadil.myuas.R


class ChatbotFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(
            Uri.parse
            ("http://192.168.43.61:5000/")
        )
        startActivity(intent)
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

}