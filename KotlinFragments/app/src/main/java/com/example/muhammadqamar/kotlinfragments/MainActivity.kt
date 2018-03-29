package com.example.muhammadqamar.kotlinfragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var firstFragment: Fragment? = null
    var secondFragment: Fragment? = null
    var transaction: FragmentTransaction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstFragment = FragmentOne()
        secondFragment = FragmentTwo()

        //setting first time
        transaction = supportFragmentManager.beginTransaction()
        transaction?.replace(R.id.xml_fragment, firstFragment)
        transaction?.commit()

        mybutton.setOnClickListener { changeFragment() }
    }

    private fun changeFragment() {

        if (firstFragment!!.isVisible) {

            transaction = supportFragmentManager.beginTransaction()
            transaction?.replace(R.id.xml_fragment, secondFragment)?.addToBackStack(null)?.commit()
            mybutton.text = "Show Fragment 1"
        }

        else if (secondFragment!!.isVisible) {

            transaction = supportFragmentManager.beginTransaction()
            transaction?.replace(R.id.xml_fragment, firstFragment)?.addToBackStack(null)?.commit()
            mybutton.text = "Show Fragment 2"
        }

    }
}
