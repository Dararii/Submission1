package com.darari.submission1.engine.datamodel

import java.io.Serializable

data class Makanan(var id: Int,
                   var name: String,
                   var desc: String,
                   var info: String,
                   var drawableIdCarousel: ArrayList<Int>) : Serializable {

    constructor(): this (0, "", "", "", ArrayList())
}