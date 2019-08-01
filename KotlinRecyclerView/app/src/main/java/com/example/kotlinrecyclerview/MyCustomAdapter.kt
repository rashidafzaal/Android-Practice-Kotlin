package com.example.kotlinrecyclerview

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import android.widget.Toast
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MyCustomAdapter(val arrayList: ArrayList<MyModelClass>,
                      var mainfilteredList : ArrayList<MyModelClass> = arrayList)
    : RecyclerView.Adapter<MyCustomAdapter.ViewHolder>(), Filterable {

    var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomAdapter.ViewHolder {
        context = parent.context
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_view, parent, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: MyCustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(mainfilteredList[position])
        val model : MyModelClass = mainfilteredList.get(position)

        holder.row_ID.text = model.id.toString()
        holder.row_name.text = model.name
        holder.row_gender.text = model.gender
        holder.row_designation.text = model.designation
        holder.row_date.text = truncateDate(position, model)
    }

    private fun truncateDate(position: Int, model : MyModelClass): CharSequence? {
        var format = SimpleDateFormat("yyyy-MM-dd")
        var newDate: Date? = null
        try {
            newDate = format.parse(model.date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        format = SimpleDateFormat("dd MMM, yyyy")
        val date = format.format(newDate)
        return date
    }

    override fun getItemCount(): Int {
        return mainfilteredList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var row_ID : TextView;
        lateinit var row_name : TextView;
        lateinit var row_gender : TextView;
        lateinit var row_designation : TextView;
        lateinit var row_date : TextView;

        fun bindItems(user: MyModelClass) {
            row_ID = itemView.findViewById(R.id.row_ID) as TextView
            row_name =  itemView.findViewById(R.id.row_name) as TextView
            row_gender = itemView.findViewById(R.id.row_gender) as TextView
            row_designation = itemView.findViewById(R.id.row_designation) as TextView
            row_date = itemView.findViewById(R.id.row_date) as TextView
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    mainfilteredList = arrayList
                } else {
                    val filteredList = java.util.ArrayList<MyModelClass>()
                    for (row in arrayList) {

                        if (row.designation!!.toLowerCase().contains(charString)) {
                            filteredList.add(row)
                        }
                    }
                    if (filteredList.size > 0) {
                        mainfilteredList = filteredList
                    } else {
                        Toast.makeText(context, "No Match", Toast.LENGTH_SHORT).show()
                    }
                }
                val filterResults = Filter.FilterResults()
                filterResults.values = mainfilteredList
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
                mainfilteredList = filterResults.values as java.util.ArrayList<MyModelClass>
                notifyDataSetChanged()
            }
        }
    }
}