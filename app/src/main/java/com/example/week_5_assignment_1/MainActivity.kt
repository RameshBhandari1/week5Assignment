package com.example.week_5_assignment_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week_5_assignment_1.adapter.postAdapter
import com.example.week_5_assignment_1.adapter.userAdapter
import com.example.week_5_assignment_1.model.posts
import com.example.week_5_assignment_1.model.user
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var stories:RecyclerView
    private lateinit var feed:RecyclerView
    private lateinit var addPost:FloatingActionButton
    private lateinit var currentUser:String
    private lateinit var profile:String
    var userList = ArrayList<user>()
    var postList = ArrayList<posts>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stories = findViewById(R.id.stories)
        feed = findViewById(R.id.feed)
        addPost = findViewById(R.id.addPost)

        addPost.setOnClickListener(this)
        userposts()
        val intent = intent
        currentUser = intent.getStringExtra("currentUser").toString()
        profile = intent.getStringExtra("profile").toString()
        userList = intent.getParcelableArrayListExtra<user>("userList") as ArrayList<user>
        user()
//        profile = intent.getStringExtra("profile").toString()
        val storyAdapter = userAdapter(userList, this)
        //val stotyAdapter = StoryAdapter(storyList, this)
        val feetAdapter = postAdapter(postList, this)
        val mLayoutManager = LinearLayoutManager(this)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        stories.layoutManager = mLayoutManager
        feed.layoutManager = LinearLayoutManager(this)
        feed.adapter=feetAdapter
        stories.adapter = storyAdapter
    }

    private fun userposts() {
        postList.add(posts("Ramesh Bhandari", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTU53EcOIyxE7pOZJBvGHJGbDk39EYxvOhbdw&usqp=CAU"
            ,"Practice make the man perfect","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTU53EcOIyxE7pOZJBvGHJGbDk39EYxvOhbdw&usqp=CAU"))
        postList.add(posts("Sabin Chapagain", "https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                ,"Practice make the man perfect","https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"))
        postList.add(posts("Dinesh Karki", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpX-CIEliwCQf3b_V8qSLCaTVx-9Lnq76JHQ&usqp=CAU"
            ,"Practice make the man perfect","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpX-CIEliwCQf3b_V8qSLCaTVx-9Lnq76JHQ&usqp=CAU"))
        postList.add(posts("Sita Rai", "https://i.pinimg.com/originals/2e/2f/ac/2e2fac9d4a392456e511345021592dd2.jpg"
            ,"Practice make the man perfect","https://i.pinimg.com/originals/2e/2f/ac/2e2fac9d4a392456e511345021592dd2.jpg"))
        postList.add(posts("Ram Charan", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTq2hiMM4LY3J-nPX9QFO0URL2siUWeJP-t-A&usqp=CAU"
            ,"Practice make the man perfect","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTq2hiMM4LY3J-nPX9QFO0URL2siUWeJP-t-A&usqp=CAU"))
        postList.add(posts("Killer Boy", "https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/06/27/15/tom-sodoge-59546-0.jpg"
            ,"Practice make the man perfect","https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/06/27/15/tom-sodoge-59546-0.jpg"))
        postList.add(posts("Aanam Bro", "https://upload.wikimedia.org/wikipedia/commons/5/5f/Alberto_conversi_profile_pic.jpg"
            ,"Practice make the man perfect","https://upload.wikimedia.org/wikipedia/commons/5/5f/Alberto_conversi_profile_pic.jpg"))
        postList.add(posts("Siva Ji", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGqeiMvcMA8ATx6McIgv0QgGq9njL6_9Q9Ww&usqp=CAU"
            ,"Practice make the man perfect","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGqeiMvcMA8ATx6McIgv0QgGq9njL6_9Q9Ww&usqp=CAU"))
        postList.add(posts("Bishal JR", "https://www.nicasiabank.com/assets/backend/uploads/Members/management%20committee/ranjan.jpeg"
            ,"Practice make the man perfect","https://www.nicasiabank.com/assets/backend/uploads/Members/management%20committee/ranjan.jpeg"))
        postList.add(posts("Unish Bhattarai", "https://images.unsplash.com/photo-1518806118471-f28b20a1d79d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80"
            ,"Practice make the man perfect","https://images.unsplash.com/photo-1518806118471-f28b20a1d79d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80"))
    }


    private fun user(){
       userList.add(user(123, "Ramesh", "Bhandari", "ramesh", "ramesh1",
            "https://i.pinimg.com/originals/7d/1a/3f/7d1a3f77eee9f34782c6f88e97a6c888.jpg"))
       userList.add(user(123, "Sabin", "Chapagain", "ramesh", "ramesh1",
            "https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"))
       userList.add(user(123, "Unish", "Bhattarai", "ramesh", "ramesh1",
            "https://images.unsplash.com/photo-1518806118471-f28b20a1d79d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80"))
       userList.add(user(123, "Dinesh", "Karki", "", "",
           "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpX-CIEliwCQf3b_V8qSLCaTVx-9Lnq76JHQ&usqp=CAU"))
       userList.add(user(123, "Sita", "Rai", "", "",
           "https://i.pinimg.com/originals/2e/2f/ac/2e2fac9d4a392456e511345021592dd2.jpg"))
       userList.add(user(123, "Ram", "Charan", "", "",
           "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTq2hiMM4LY3J-nPX9QFO0URL2siUWeJP-t-A&usqp=CAU"))
       userList.add(user(123, "Killer", "Boy", "", "",
           "https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/06/27/15/tom-sodoge-59546-0.jpg"))
       userList.add(user(123, "Aanam", "Bro", "", "",
           "https://upload.wikimedia.org/wikipedia/commons/5/5f/Alberto_conversi_profile_pic.jpg"))
       userList.add(user(123, "Siva", "Ji", "", "",
           "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGqeiMvcMA8ATx6McIgv0QgGq9njL6_9Q9Ww&usqp=CAU"))
       userList.add(user(123, "Bishal", "Jr", "", "",
           "https://www.nicasiabank.com/assets/backend/uploads/Members/management%20committee/ranjan.jpeg"))

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.addPost->{
                val intent = Intent(this, Post_Activity::class.java)
                startActivityForResult(intent, 1)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                val status = data?.getStringExtra("status").toString()
                val link = data?.getStringExtra("link").toString()
                postList.add(posts(currentUser, profile,status, link))
            }
        }
    }
}