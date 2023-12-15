package com.example.foodiepal_culinarycompanion.fragments.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.fragments.model.BlogPost

class BlogPostAdapter(private val posts: List<BlogPost>, private val onShareClicked: (Int) -> Unit) :
    RecyclerView.Adapter<BlogPostAdapter.BlogPostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogPostViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.blog_post_card_view, parent,false)
        return BlogPostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: BlogPostViewHolder, position: Int) {
        holder.tvTitle.text = posts[position].title
        holder.tvAuthor.text = posts[position].author
        holder.tvDate.text = posts[position].dateTime
        holder.tvContent.text = posts[position].content
        holder.imageView.setImageResource(posts[position].imageId)
        holder.shareButton.setOnClickListener {
            onShareClicked(position)
        }
    }

    inner class BlogPostViewHolder(item:View): RecyclerView.ViewHolder(item){
        val tvTitle: TextView = item.findViewById(R.id.titleTextView)
        val tvAuthor: TextView = item.findViewById(R.id.authorTextView)
        val tvDate: TextView = item.findViewById(R.id.dateTextView)
        val tvContent: TextView = item.findViewById(R.id.contentTextView)
        val shareButton: ImageButton = item.findViewById(R.id.shareButton)
        val imageView: ImageView = item.findViewById(R.id.coverImageView)
    }
}