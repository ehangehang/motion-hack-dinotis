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

class MeetingScheduleAdapter(private val items: List<Meeting>): RecyclerView.Adapter<MeetingScheduleAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imgProfpic: ImageView = itemView.findViewById(R.id.rv_scd_img_profpic)
        private val txtTitle: TextView = itemView.findViewById(R.id.rv_scd_txt_title)
        private val txtName: TextView = itemView.findViewById(R.id.rv_scd_txt_creator_name)
        private val txtDate: TextView = itemView.findViewById(R.id.rv_scd_txt_date)
        private val txtTime: TextView = itemView.findViewById(R.id.rv_scd_txt_time)
        private val txtPrice: TextView = itemView.findViewById(R.id.rv_scd_txt_price)

        fun bindItem(meeting: Meeting) {
            Picasso.get()
                .load(meeting.creator?.profilPhoto)
                .into(imgProfpic)
            txtTitle.text = meeting.title
            txtName.text = meeting.creator?.name
            txtDate.text = meeting.startAt
            txtTime.text = meeting.endAt
            txtPrice.text = meeting.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_schedule, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size
}