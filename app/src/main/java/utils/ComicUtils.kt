package utils

import classes.Comic
import org.json.JSONObject

object ComicUtils {

    fun prepareArray(response : String?) : MutableList<Comic> {
        val responseJSON = JSONObject(response)
        val obj1 = responseJSON.getJSONObject("data")
        val dataJSON = obj1.getJSONArray("results")
        val comicsList = mutableListOf<Comic>()
        for(i in 0..(dataJSON.length() - 1)) {
            var item = dataJSON.getJSONObject(i)
            val comicItem = Comic(
                    item.get("id").toString().toLong(),
                    item.get("title").toString(),
                    item.get("issueNumber").toString().toLong(),
                    item.get("description").toString(),
                    item.get("pageCount").toString().toLong(),
                    item.getJSONObject("series").get("name").toString(),
                    item.getJSONArray("prices").getJSONObject(0).get("price").toString().toDouble(),
                    item.getJSONObject("thumbnail").get("path").toString()
                    )
            comicsList.add(comicItem)
            println(comicItem.toString())
        }
        return comicsList
    }
}