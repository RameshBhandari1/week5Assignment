package com.example.week_5_assignment_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.week_5_assignment_1.model.user


class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etcovid : EditText
    private lateinit var etfname : EditText
    private lateinit var etlname : EditText
    private lateinit var etusername : EditText
    private lateinit var etpassword : EditText
    private lateinit var batchspinner : Spinner
    private lateinit var etimage : EditText
    private lateinit var btnregister : Button
    private lateinit var tvsignin : TextView
    val MIN_PASSWORD_LENGTH = 6
    private var userdata = arrayListOf<user>()
    private val batch = arrayOf("25A","25B","25C","25D")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etcovid = findViewById(R.id.etcovid)
        etfname = findViewById(R.id.etfname)
        etlname = findViewById(R.id.etlname)
        etusername = findViewById(R.id.etusername)
        etpassword = findViewById(R.id.etpassword)
        etimage = findViewById(R.id.etimage)
        tvsignin = findViewById(R.id.tvsignin)
        batchspinner = findViewById(R.id.batchspinner)
        btnregister = findViewById(R.id.btnregister)
        btnregister.setOnClickListener(this)
        tvsignin.setOnClickListener(this)


        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            batch
        )
        //setting the adapter to spinner's adapter
        batchspinner.adapter = adapter
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    fun validateInput(): Boolean{
        if (etcovid.text.toString() == ""){
            etcovid.setError("Please enter Coventry ID")
            return false
        }
        if (etfname.text.toString() == ""){
            etfname.setError("Please enter first name")
            return false
        }
        if (etlname.text.toString() == ""){
            etlname.setError("Please enter last name")
            return false
        }
        if (etusername.text.toString() == ""){
            etusername.setError("Please enter username")
            return false
        }
        if (etpassword.text.toString() == ""){
            etpassword.setError("Please enter password")
            return false
        }
        if (etimage.text.toString() == ""){
            etimage.setError("Please enter Coventry ID")
            return false
        }
        if (etpassword.text.length < MIN_PASSWORD_LENGTH){
            etpassword.setError("Please fulfil password requirement")
            return false
        }
        return true
    }


    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnregister-> {
                if (validateInput()) {
                    val user = user(
                            etcovid.text.toString().toInt(),
                            etfname.text.toString(),
                            etlname.text.toString(),
                            etusername.text.toString(),
                            etpassword.text.toString(),
                            etimage.text.toString(),

                            )
                    val intent = Intent()
                    intent.putExtra("user", user)
                    setResult(Activity.RESULT_OK, intent)
                    Toast.makeText(this, "Register Sucessfull", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
            R.id.tvsignin->{
                Companion.loadLogin(this)
            }
        }
    }
    companion object {
        fun loadLogin(activity: RegisterActivity){
            val intent = Intent(activity, LoginActivity::class.java)
           // intent.putExtra("userdata", activity.userdata)
            activity.startActivity(intent)
        }
    }

}