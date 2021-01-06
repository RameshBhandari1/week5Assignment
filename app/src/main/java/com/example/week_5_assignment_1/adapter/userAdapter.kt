package com.example.week_5_assignment_1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week_5_assignment_1.R
import com.example.week_5_assignment_1.model.user
import de.hdodenhof.circleimageview.CircleImageView

class userAdapter (
        val lstuser : ArrayList<user>,
        val context : Context
        ): RecyclerView.Adapter<userAdapter.UserViewHolder>(){
           class UserViewHolder(view: View):RecyclerView.ViewHolder(view){
               val storyimg: CircleImageView
               val tvstoryuser: TextView

               init {
                   storyimg = view.findViewById(R.id.storyimg)
                   tvstoryuser = view.findViewById(R.id.tvstoryuser)
               }

           }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.stories_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = lstuser[position]
        holder.tvstoryuser.text = user.etfname

        //Load image with Glide library
        Glide.with(context)
                .load(user.etimage)
                .into(holder.storyimg)

    }

    override fun getItemCount(): Int {
        return lstuser.size
    }
}