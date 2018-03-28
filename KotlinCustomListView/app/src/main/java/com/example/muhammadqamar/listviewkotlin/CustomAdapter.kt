package com.example.muhammadqamar.myapplication

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.muhammadqamar.listviewkotlin.R

/**
 * Created by Rashid on 3/26/2018.
 */

class CustomAdapter : ArrayAdapter<MyDataClass>{

    var layout: Int
    var c: Context?
    var arrList: ArrayList<MyDataClass>

    constructor(context: Context?, resource: Int, objects: ArrayList<MyDataClass>) : super(context, resource, objects) {
        this.c = context
        this.layout = resource
        this.arrList = objects
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var row: View;
        val vh: ViewHolder
        if (convertView == null) {
            val inflater = (c as Activity).layoutInflater
            row = inflater.inflate(R.layout.row, parent, false)
            vh = ViewHolder(row)
            row.tag = vh
        } else {
            row = convertView
            vh = row.tag as ViewHolder
        }

        vh.tvImg!!.setImageResource(arrList!!.get(position).image)
        vh.tvContent!!.text = arrList!!.get(position).text

        return row!!
    }


    private class ViewHolder(view: View?) {
        val tvImg: ImageView?
        val tvContent: TextView?

        init {
            this.tvImg = view?.findViewById(R.id.row_ImageView)
            this.tvContent = view?.findViewById(R.id.row_TextView)
        }
    }

}
