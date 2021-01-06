package com.example.week_5_assignment_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.week_5_assignment_1.model.user

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etuser : EditText
    private lateinit var etpass : EditText
    private lateinit var btnlogin : Button
    private lateinit var tvsignup : TextView
    private lateinit var currentUser:String
    private lateinit var profile:String
    var userdata = ArrayList<user>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loadUser()
        etuser = findViewById(R.id.etuser)
        etpass = findViewById(R.id.etpass)
        tvsignup = findViewById(R.id.tvsignup)
        btnlogin = findViewById(R.id.btnlogin)

        btnlogin.setOnClickListener(this)
        tvsignup.setOnClickListener(this)


    }
    private fun loadUser(){
        userdata.add(user(10250163,"ram", "pandey", "ram123", "password", "https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80"))

        /*val intent = intentram123
        userdata = intent.getParcelableArrayListExtra<user>("userdata") as ArrayList<user>
    */}
    fun validateInput(): Boolean {
        if (etuser.text.toString() == "") {
            etuser.setError("Please enter username")
            return false
        }
        if (etuser.text.toString() == "") {
            etuser.setError("Please enter password")
            return false
        }
        return true
    }
    fun logincheck(): Boolean{
        if(validateInput()){
            for (i in userdata.indices){
                val username = userdata.get(i).etusername
                val password = userdata.get(i).etpassword
                if (etuser.text.toString() == username &&  etpass.text.toString() == password){
                    currentUser = username.toString()
                    profile = userdata.get(i).etimage.toString()
                    return true
                }
            }
        }
        return false
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnlogin->{
                if (logincheck()){
                    Toast.makeText(this, "Login Sucessfull", Toast.LENGTH_SHORT).show()
                    val intent = Intent(
                        this,
                        MainActivity::class.java
                    )
                        .putExtra("currentUser", currentUser)
                        .putExtra("userList", userdata)
                        .putExtra("profile", profile)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show()
                }


            }
            R.id.tvsignup->{
                val intent = Intent(
                    this,
                    RegisterActivity::class.java
                )
                startActivityForResult(intent, 1)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                val user = data?.getParcelableExtra<user>("user")
                userdata.add(user!!)
            }
        }
    }

}