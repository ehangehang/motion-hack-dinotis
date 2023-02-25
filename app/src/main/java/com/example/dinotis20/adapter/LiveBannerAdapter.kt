package com.example.dinotis20.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dinotis20.R
import com.example.dinotis20.model.Meeting
import com.squareup.picasso.Picasso

class LiveBannerAdapter(private val items: List<Meeting>): RecyclerView.Adapter<LiveBannerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imgProfpic: ImageView = itemView.findViewById(R.id.rv_banner_img_profpic)
        private val imgBanner: ImageView = itemView.findViewById(R.id.rv_banner_img_banner)
        private val txtName: TextView = itemView.findViewById(R.id.rv_banner_txt_creator_name)

        fun bindItem(meeting: Meeting) {
            Picasso.get()
                .load(meeting.creator?.profilPhoto)
                .into(imgProfpic)
            Picasso.get()
                .load(meeting.creator?.profilPhoto)
                .into(imgBanner)
            txtName.text = meeting.creator?.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_live_banner, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }
}