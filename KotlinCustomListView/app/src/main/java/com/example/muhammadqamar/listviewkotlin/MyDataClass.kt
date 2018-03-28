package com.example.muhammadqamar.myapplication

import android.widget.ImageView

/**
 * Created by Rashid on 3/26/2018.
 */

class MyDataClass {
    var image: Int
    var text: String

    constructor(img: Int, txt: String) {
        this.image = img;
        this.text = txt;
    }
}

//=========================================Another Method==========================================

//class MyDataClass constructor(image: Int, text: String) {
//    var image: Int
//    var text: String
//
//    init {
//        this.image = image
//        this.text = text
//    }
//}
//=========================================Another Method==========================================

//class MyDataClass constructor(var image: Int, var text: String)