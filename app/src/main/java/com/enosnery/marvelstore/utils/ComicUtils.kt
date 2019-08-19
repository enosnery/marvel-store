package com.enosnery.marvelstore.utils

import com.enosnery.marvelstore.classes.Comic
import org.json.JSONObject

object ComicUtils {

    fun prepareArray(response : String?) : MutableList<Comic> {

        val responseJSON = JSONObject(response)
        val obj1 = responseJSON.getJSONObject("data")
        val dataJSON = obj1.getJSONArray("results")
        val comicsList = mutableListOf<Comic>()
        for(i in 0 until dataJSON.length()) {
            val chance = Math.random() * 100
            val rare = chance <= 12
            var item = dataJSON.getJSONObject(i)
            val pictureURL = item.getJSONArray("images").getJSONObject(0).get("path").toString()+"/portrait_xlarge."+item.getJSONArray("images").getJSONObject(0).get("extension").toString()
            val comicItem = Comic(
                    item.get("id").toString().toLong(),
                    item.get("title").toString(),
                    item.get("issueNumber").toString().toLong(),
                    item.get("description").toString(),
                    item.get("pageCount").toString().toLong(),
                    item.getJSONObject("series").get("name").toString(),
                    item.getJSONArray("prices").getJSONObject(0).get("price").toString().toDouble(),
                    pictureURL,
                    rare
                    )
            comicsList.add(comicItem)
            println(comicItem.toString())
        }
        return comicsList
    }
}