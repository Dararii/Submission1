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
import com.darari.submission1.engine.datamodel.Makanan
import kotlinx.android.synthetic.main.item_list_main.view.*

class MainListAdapter(private val items: ArrayList<Makanan>, private val context: Context, private val c: OnBindCallback) : RecyclerView.Adapter<MainListAdapter.MainListAdapterViewHolder>() {

    companion object {
        private const val TAG = "ADAPTER_MAIN_LIST"
    }

    // Gets the number of months in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListAdapterViewHolder {
        return MainListAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_main, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: MainListAdapterViewHolder, position: Int) {
        val food = items[position]

        Glide.with(holder.pict)
            .asBitmap()
            .centerCrop()
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .load(food.drawableIdCarousel[0])
            .into(holder.pict)

        holder.name.text = food.name
        holder.desc.text = food.desc
        holder.id.text = "No. ${food.id}"

        c.onBind(holder, position)

        Log.d(TAG, "Loaded $position")

    }

    interface OnBindCallback {
        fun onBind(holder: MainListAdapterViewHolder, position: Int)
    }

    class MainListAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the views
        val pict = view.imgItemMainCover!!
        val name = view.textItemMainName!!
        val id = view.textItemMainNumber!!
        val desc = view.textItemMainShortDesc!!
        val btn = view.btnItemMainDetail!!
    }
}

