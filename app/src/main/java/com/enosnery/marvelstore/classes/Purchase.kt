package com.enosnery.marvelstore.classes

import java.io.Serializable

class Purchase(
        val title : String,
        val price : Double,
        val amount : Int,
        val rare : Boolean,
        val url : String
):Serializable