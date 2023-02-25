package com.example.dinotis20.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dinotis20.R
import com.example.dinotis20.model.Meeting
import com.squareup.picasso.Picasso

class MeetingScheduleBannerAdapter(private val items: List<Meeting>): RecyclerView.Adapter<MeetingScheduleBannerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imgProfpic: ImageView = itemView.findViewById(R.id.rv_schedule_banner_profpic)
        private val txtCreatorName: TextView = itemView.findViewById(R.id.rv_schedule_banner_creator_name)
        private val txtDate: TextView = itemView.findViewById(R.id.rv_schedule_banner_date)
        private val txtTitle: TextView = itemView.findViewById(R.id.rv_schedule_banner_title)
        private val txtTime: TextView = itemView.findViewById(R.id.rv_schedule_banner_time)
        private val txtPremium: TextView = itemView.findViewById(R.id.rv_schedule_banner_premium_status)
        private val btJoin: Button = itemView.findViewById(R.id.rv_schedule_banner_join_meet)

        fun bindItem(meeting: Meeting) {
            Picasso.get()
                .load(meeting.creator.profilPhoto)
                .into(imgProfpic)
            txtCreatorName.text = meeting.creator.name
            txtDate.text = meeting.startAt
            txtTitle.text = meeting.title
            txtTime.text = meeting.startAt
            if (meeting.isPrivate) {
                txtPremium.text = "Premium"
            } else {
                txtPremium.text = "Free"
            }
            btJoin.setOnClickListener {
                // TODO: Join meet with external link
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_schedule_banner, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }
}