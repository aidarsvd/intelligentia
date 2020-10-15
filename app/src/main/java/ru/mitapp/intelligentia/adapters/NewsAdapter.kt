package ru.mitapp.intelligentia.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.mitapp.intelligentia.R
import ru.mitapp.intelligentia.databinding.NewsItemBinding
import ru.mitapp.intelligentia.models.News
import ru.mitapp.intelligentia.models.NewsResponse
import java.util.ArrayList

class NewsAdapter(var list: ArrayList<News>, var listener: Listener) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)

        return NewsViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        holder.onBind(list[position], listener)
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var newsImage = itemView.findViewById(R.id.news_image) as ImageView
        var newsTitle = itemView.findViewById(R.id.news_title) as TextView
        var newsDescription = itemView.findViewById(R.id.news_description) as TextView


        fun onBind(news: News, listener : Listener){
            newsTitle.text = news.title
            newsDescription.text = news.description
            Glide.with(itemView.context).load(news.urlToImage).placeholder(R.drawable.ic_logo).into(newsImage)

            itemView.setOnClickListener {
                listener.onItemClick(news)
            }
        }

    }

    interface Listener {
        fun onItemClick(news : News)
    }


}