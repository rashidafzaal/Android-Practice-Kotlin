package com.example.muhammadqamar.listviewkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.muhammadqamar.myapplication.CustomAdapter
import com.example.muhammadqamar.myapplication.MyDataClass

class SecondActivity : AppCompatActivity() {

    lateinit var myListview: ListView
    lateinit var myAdapter: CustomAdapter
    var arrayList = ArrayList<MyDataClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        myListview = findViewById(R.id.myListView);

        //Populate Objects
        val obj0 = MyDataClass(R.drawable.picture, "It has been constatntly said that no one is belong to the people of this area");
        val obj1 = MyDataClass(R.drawable.picture, "It has been to the people of this area");
        val obj2 = MyDataClass(R.drawable.picture, "It has been to the people of this area");
        val obj3 = MyDataClass(R.drawable.picture, "It has been to the people of this area");
        val obj4 = MyDataClass(R.drawable.picture, "It has been constatntly said that no one is belong to the people of this area");
        val obj5 = MyDataClass(R.drawable.picture, "It has been constatntly said that no one is belong to the people of this area");
        val obj6 = MyDataClass(R.drawable.picture, "It has been to the people of this area");
        val obj7 = MyDataClass(R.drawable.picture, "It has been constatntly said that no one is belong to the people of this area");

        //Add into ArrayList
        arrayList.add(obj0)
        arrayList.add(obj1)
        arrayList.add(obj2)
        arrayList.add(obj3)
        arrayList.add(obj4)
        arrayList.add(obj5)
        arrayList.add(obj6)
        arrayList.add(obj7)

        myAdapter = CustomAdapter(this@SecondActivity, R.layout.row, arrayList)
        myListview.adapter = myAdapter;
    }
}
