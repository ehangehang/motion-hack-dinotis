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

// TODO: Create transaction model
class TransactionAdapter(private val items: List<Meeting>): RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imgProfpic: ImageView = itemView.findViewById(R.id.rv_trans_profpic)
        private val txtCreatorName: TextView = itemView.findViewById(R.id.rv_trans_creator_name)
        private val txtDate: TextView = itemView.findViewById(R.id.rv_trans_date)
        private val txtStatus: TextView = itemView.findViewById(R.id.rv_trans_status)
        private val txtTitle: TextView = itemView.findViewById(R.id.rv_trans_title)
        private val txtTime: TextView = itemView.findViewById(R.id.rv_trans_time)
        private val txtPrice: TextView = itemView.findViewById(R.id.rv_trans_price)
        private val txtPremium: TextView = itemView.findViewById(R.id.rv_trans_premium_status)

        fun bindItem(meeting: Meeting) {
            Picasso.get()
                .load(meeting.creator.profilPhoto)
                .into(imgProfpic)
            txtCreatorName.text = meeting.creator.name
            txtDate.text = meeting.startAt
//            txtStatus.text = meeting.
            txtTitle.text = meeting.title
            txtTime.text = meeting.startAt
            txtPrice.text = meeting.price.toString()
            if (meeting.isPrivate) {
                txtPremium.text = "Premium"
            } else {
                txtPremium.text = "Free"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_transaction, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }
}