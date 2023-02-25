package com.example.dinotis20.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dinotis20.R
import com.example.dinotis20.model.Creator
import com.squareup.picasso.Picasso

class SearchCreatorAdapter(private val items: List<Creator>): RecyclerView.Adapter<SearchCreatorAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imgProfpic: ImageView = itemView.findViewById(R.id.rv_search_img_profpic)
        private val txtName : TextView = itemView.findViewById(R.id.rv_search_creator_name)

        fun bindItem(creator: Creator) {
            Picasso.get()
                .load(creator?.profilPhoto)
                .into(imgProfpic)
            txtName.text = creator.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_creator, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size
}