package com.example.dinotis20.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.dinotis20.R
import com.example.dinotis20.model.Meeting
import com.squareup.picasso.Picasso

class LiveAdapter(private val items: List<Meeting>): RecyclerView.Adapter<LiveAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imgProfpic: ImageView = itemView.findViewById(R.id.rv_live_img_profpic)

        fun bindItem(meeting: Meeting) {
            Picasso.get()
                .load(meeting.creator.profilPhoto)
                .into(imgProfpic)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_live, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size
}