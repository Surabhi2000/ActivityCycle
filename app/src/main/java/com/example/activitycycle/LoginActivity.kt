package com.example.activitycycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity() : AppCompatActivity() {

    lateinit var etno: EditText
    lateinit var etpassword: EditText
    lateinit var btnLogin: Button
    lateinit var textforgot: TextView
    lateinit var textregister: TextView
    val validuser = arrayListOf("tony", "bruce", "steve", "thanos")
    val validno = "0123456789"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isloggedin = sharedPreferences.getBoolean("isloggedin", false)

        setContentView(R.layout.activity_login)

        if (isloggedin) {
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        setContentView(R.layout.activity_login)

        title = "Log In"

        etno = findViewById(R.id.etno)
        etpassword = findViewById(R.id.etpassword)
        btnLogin = findViewById(R.id.btnLogin)
        textforgot = findViewById(R.id.textforgot)
        textregister = findViewById(R.id.textregister)

        btnLogin.setOnClickListener {

            val mobileno = etno.text.toString()
            val user = etpassword.text.toString()
            var nameOfAvenger = "Avengers"
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            if (mobileno == validno) {
                if (user == validuser[0]) {

                    nameOfAvenger = "Iron Man"
                    savedpreferences(nameOfAvenger)
                    startActivity(intent)

                } else if (user == validuser[1]) {

                    nameOfAvenger = "The Hulk"
                    savedpreferences(nameOfAvenger)
                    startActivity(intent)

                } else if (user == validuser[2]) {

                    nameOfAvenger = "Caption America"
                    savedpreferences(nameOfAvenger)
                    startActivity(intent)

                } else if (user == validuser[3]) {

                    nameOfAvenger = "Thanos"
                    savedpreferences(nameOfAvenger)
                    startActivity(intent)

                }
            } else {
                Toast.makeText(this@LoginActivity, "Incorrect entry", Toast.LENGTH_LONG)
                    .show()
            }

        }
    }

    override fun OnPause() {
        super.onPause()
        finish()
    }

    fun savedpreferences(title: String) {
        sharedPreferences.edit().putBoolean("isloggedin", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }
}
