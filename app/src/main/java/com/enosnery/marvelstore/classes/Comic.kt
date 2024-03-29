package com.enosnery.marvelstore.classes

import java.io.Serializable

class Comic (
         val id:Long,
         val title: String,
         val issueNumber : Long,
         val description : String,
         val pageCount: Long,
         val seriesName: String,
         val price: Double,
         val pictureURL: String,
         val rare : Boolean
): Serializable