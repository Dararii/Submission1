package com.darari.submission1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.darari.submission1.R
import com.darari.submission1.adapter.DetailCarouselAdapter
import com.darari.submission1.engine.datamodel.Makanan
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private var data: Makanan? = null
    private lateinit var adapter: DetailCarouselAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent?.getSerializableExtra("DATA")?.let {
            data = it as Makanan
        }

        data?.let {
            Glide.with(imgDetailCover)
                .asBitmap()
                .centerCrop()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .load(data!!.drawableIdCarousel[0])
                .into(imgDetailCover)

            prepareRv(rvDetailCarousel)
            textDetailFoodName.text = it.name
            textDetailFoodDesc.text = it.desc
            textDetailInfo.text = it.info
        }

        btnDetailBack.setOnClickListener {
            super.onBackPressed()
        }
    }

    private fun prepareRv(rv: RecyclerView){
        val layoutManager = LinearLayoutManager(rv.context, LinearLayoutManager.HORIZONTAL, false)
        rv.layoutManager = layoutManager
        adapter = DetailCarouselAdapter(data!!.drawableIdCarousel, rv.context, object: DetailCarouselAdapter.OnBindCallback{
            override fun onBind(holder: DetailCarouselAdapter.DetailCarouselAdapter, position: Int) {
                holder.img.setOnClickListener {
                    Glide.with(imgDetailCover)
                        .asBitmap()
                        .centerCrop()
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                        .load(data!!.drawableIdCarousel[position])
                        .into(imgDetailCover)
                }
            }
        })
        rv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        data?.let {
            outState.putSerializable("MAKANAN", it)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState.getSerializable("MAKANAN")?.let {
            data = it as Makanan
        }
    }
}
