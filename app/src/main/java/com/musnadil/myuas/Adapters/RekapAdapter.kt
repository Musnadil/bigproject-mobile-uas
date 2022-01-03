package com.musnadil.myuas.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.musnadil.myuas.Models.RekapModel
import com.musnadil.myuas.R

class RekapAdapter (
    val rekap: ArrayList<RekapModel.Data_masuk>
        ): RecyclerView.Adapter<RekapAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.history_list,parent,false)
    )

    override fun onBindViewHolder(holder: RekapAdapter.ViewHolder, position: Int) {
        val history = rekap[position]
        holder.tv_plat.text = history.nomer_plat
        holder.tv_tanggal.text = history.tanggal
        holder.tv_waktu_masuk.text = history.waktu_masuk
        holder.tv_waktu_keluar.text = history.waktu_keluar

    }

    override fun getItemCount()=rekap.size
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tv_plat = view.findViewById<TextView>(R.id.tv_plat)
        val tv_tanggal = view.findViewById<TextView>(R.id.tv_tanggal)
        val tv_waktu_masuk = view.findViewById<TextView>(R.id.tv_waktu_masuk)
        val tv_waktu_keluar = view.findViewById<TextView>(R.id.tv_waktu_keluar)
    }
    public fun setData(recapdata : List<RekapModel.Data_masuk>){
        rekap.clear()
        rekap.addAll(recapdata)
        notifyDataSetChanged()
    }

}
