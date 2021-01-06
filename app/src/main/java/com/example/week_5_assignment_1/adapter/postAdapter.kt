package com.example.week_5_assignment_1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week_5_assignment_1.R
import com.example.week_5_assignment_1.model.posts
import de.hdodenhof.circleimageview.CircleImageView

data class postAdapter (
        val postList: ArrayList<posts>,
        val context: Context

): RecyclerView.Adapter<postAdapter.PostViewHolder>() {
    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUser: TextView
        val imgProfile:CircleImageView
        val imgPost: ImageView
        val tvStatus: TextView

        init {
            imgPost = view.findViewById(R.id.imgPost)
            imgProfile = view.findViewById(R.id.imgProfile)
            tvUser = view.findViewById(R.id.tvUser)
            tvStatus = view.findViewById(R.id.tvStatus)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_layout, parent, false)
        return PostViewHolder(view)
    }
    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.tvUser.text=post.user
        holder.tvStatus.text=post.status
        Glide.with(context)
            .load(post.profile)
            .into(holder.imgProfile)
        Glide.with(context)
            .load(post.link)
            .into(holder.imgPost)
    }



}