package com.example.kotlinrecyclerview

/*for retrofit
implementation 'com.squareup.retrofit2:converter-gson:2.1.0'

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@SerializedName("id")
@Expose
private var id: Int? = null
@SerializedName("arePrerequisitesCompleted")
@Expose
private var arePrerequisitesCompleted: Boolean? = null
@SerializedName("registrationDate")
@Expose
private var registrationDate: String? = null
@SerializedName("stage")
@Expose
private var stage: String? = null*/


class MyModelClass {

    var id: Int = 0
    var name: String = ""
    var gender : String = ""
    var designation : String = ""
    var date: String = ""

    constructor()

    constructor(_id: Int, _name: String, _gender : String, _designation : String, _date: String) {
        this.id = _id
        this.name = _name
        this.gender = _gender
        this.designation = _designation
        this.date = _date
    }

}