package com.example.kotlinrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_second.*
import android.support.v7.widget.DividerItemDecoration



class SecondActivity : AppCompatActivity() {


    var arrayList: ArrayList<MyModelClass> = arrayListOf()
    lateinit var adapter : MyCustomAdapter
    lateinit var nameEditText: EditText
    lateinit var searchBtn: ImageView
    lateinit var myRecyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initUi()
        initListeners();
        setupRecyclerView()
        populateArrayListData()
    }

    private fun initUi() {
        nameEditText = findViewById(R.id.nameEditText)
        searchBtn = findViewById(R.id.searchBtn)
    }

    private fun initListeners() {
        searchBtn.setOnClickListener {
            var name = nameEditText.text.toString()
            if (!TextUtils.isEmpty(name) ) {
                adapter.getFilter().filter(name)
            } else {
                Toast.makeText(this, "No Results Found", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun setupRecyclerView() {
        myRecyclerView = findViewById(R.id.myRecyclerView) as RecyclerView
        var mLayoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        myRecyclerView.layoutManager = mLayoutManager
        var mDividerItemDecoration = DividerItemDecoration(myRecyclerView.getContext(), mLayoutManager.getOrientation())
        myRecyclerView.addItemDecoration(mDividerItemDecoration)
    }


    private fun populateArrayListData() {

        //with constructor
        var obj1 = MyModelClass(1, "Rashid", "Male", "Software Engineer", "2019-05-08")
        var obj2 = MyModelClass(2, "Shehroz Ali", "Male", "Android Developer", "2069-03-01")
        var obj3 = MyModelClass(3, "Arslan", "Male", "React Native Developer", "2619-01-01")

        //with getter setter
        var obj4 = MyModelClass()
        obj4.id = 4
        obj4.name = "Bazil Hassan"
        obj4.gender = "Male"
        obj4.designation = "iOS Developer"
        obj4.date = "2000-10-11"

        //add all objects in ArrayList
        arrayList.add(obj1)
        arrayList.add(obj2)
        arrayList.add(obj3)
        arrayList.add(obj4)

        //Pass ArrayList to Adapter
        adapter = MyCustomAdapter(arrayList)
        myRecyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }
}
