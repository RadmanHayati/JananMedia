package com.example.jm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vipulasri.multiplebackstacknavigation.databinding.ItemViewBinding
import ir.kotlinx.mytask.UserModel

class HomeAdapter(private val data: MutableList<UserModel> ): RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val itemBinding: ItemViewBinding):RecyclerView.ViewHolder(itemBinding.root)
    {

        val id = itemBinding.itemID
        val name = itemBinding.textViewName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(
           ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent , false)

       )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.id.text = data[position].id.toString()
        holder.name.text = data[position].name
    }

    override fun getItemCount(): Int {
     return data.size
    }
}