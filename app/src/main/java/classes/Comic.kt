package classes

import java.time.temporal.ValueRange

class Comic(
         val id:Long,
         val title: String,
         val issueNumber : Long,
         val description : String,
         val pageCount: Long,
         val seriesName: String,
         val price: Double,
         val pictureURL: String
){
    override fun toString(): String {
        return "Comic(id=$id, title='$title', issueNumber=$issueNumber, description='$description', pageCount=$pageCount, seriesName='$seriesName', price=$price, pictureURL='$pictureURL')"
    }
}
