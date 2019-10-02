package com.darari.submission1.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.darari.submission1.R
import kotlinx.android.synthetic.main.item_list_carousel.view.*

class DetailCarouselAdapter(private val items: ArrayList<Int>, private val context: Context, private val c: OnBindCallback) : RecyclerView.Adapter<DetailCarouselAdapter.DetailCarouselAdapter>() {

    companion object {
        private const val TAG = "ADAPTER_CAROUSEL_LIST"
    }

    // Gets the number of months in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailCarouselAdapter {
        return DetailCarouselAdapter(LayoutInflater.from(context).inflate(R.layout.item_list_carousel, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: DetailCarouselAdapter, position: Int) {
        val image = items[position]

        Glide.with(holder.img)
            .asBitmap()
            .centerCrop()
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .load(image)
            .into(holder.img)

        Log.d(TAG, "Loaded $position")

        c.onBind(holder, position)
    }

    interface OnBindCallback {
        fun onBind(holder: DetailCarouselAdapter, position: Int)
    }

    class DetailCarouselAdapter(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the views
        val img = view.imgCarousel!!
    }
}

