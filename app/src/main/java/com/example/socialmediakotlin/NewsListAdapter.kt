package com.example.socialmediakotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class NewsListAdapter() :
    RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    private var newsList: List<News>? = null
    private var listener: ItemClickListener? = null

    constructor(newsList: List<News>, listener: ItemClickListener) :this(){
        this.newsList = newsList
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, null, false)
        val params: RecyclerView.LayoutParams = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        view.layoutParams = params
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList!!.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList!![position]
        holder.tvImageUrl.setImageResource(news.getImageUrl())
        holder.tvDate.text = news.getDate()
        holder.tvAuthor.text = news.getAuthor()
        holder.tvImageUrl2.setImageResource(news.getImageUrl2())
        holder.tvTheme.text = news.getTheme()
        holder.tvRatingCount.text = (news.getRatingCount())
        holder.tvComments.text = (news.getCommentsCount())

        holder.itemView.setOnClickListener {
            listener?.itemClick(position, news)
        }
    }

    class NewsViewHolder(itemView: View) : ViewHolder(itemView) {
        var tvImageUrl: ImageView = itemView.findViewById(R.id.tvImage)
        var tvImageUrl2: ImageView = itemView.findViewById(R.id.tvImage2)
        var tvDate: TextView = itemView.findViewById(R.id.tvDate)
        var tvAuthor: TextView = itemView.findViewById(R.id.tvAuthor)
        var tvTheme: TextView = itemView.findViewById(R.id.tvTheme)
        var tvRatingCount: TextView = itemView.findViewById(R.id.tvRating)
        var tvComments: TextView = itemView.findViewById(R.id.tvComments)
    }

    interface ItemClickListener {
        fun itemClick(position: Int, item: News?)
    }
}