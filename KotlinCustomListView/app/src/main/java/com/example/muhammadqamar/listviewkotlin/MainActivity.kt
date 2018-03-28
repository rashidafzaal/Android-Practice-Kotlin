package com.example.muhammadqamar.listviewkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var myIntent:Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goNextBtn.setOnClickListener {
            myIntent = Intent (this@MainActivity, SecondActivity::class.java)
            startActivity(myIntent)
        }
    }
}
