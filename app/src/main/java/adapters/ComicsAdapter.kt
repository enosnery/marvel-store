package adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import classes.Comic
import com.enosnery.swissknife.R
import com.enosnery.swissknife.R.id.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_view_item.view.*

class ComicsAdapter(private val context: Context, private val dataSource: ArrayList<Comic>) : BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_view_item, p2, false)

        val titleTextView = rowView.findViewById<TextView>(R.id.list_item_title)

        val priceTextView = rowView.findViewById<TextView>(R.id.list_item_price)

        val imageView = rowView.findViewById<ImageView>(R.id.list_item_image)

        val comic = getItem(p0) as Comic

        titleTextView.text = comic.title
        priceTextView.text = comic.price.toString()
        Picasso.get().load(comic.pictureURL).into(imageView)

        return rowView
    }

    override fun getItem(p0: Int): Any {
        return dataSource[p0]
    }

    override fun getItemId(p0: Int): Long {
        return dataSource[p0].id
    }

    override fun getCount(): Int {
        return dataSource.size

    }
}