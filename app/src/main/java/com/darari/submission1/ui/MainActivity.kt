package com.darari.submission1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.darari.submission1.R
import com.darari.submission1.adapter.MainListAdapter
import com.darari.submission1.engine.datamodel.Makanan
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainListAdapter
    private val list: ArrayList<Makanan> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (list.size == 0)
            loadDummyData()

        prepareRv(rvMainFoods)
    }

    private fun goToAbout(){
        val i = Intent(this@MainActivity, AboutActivity::class.java)
        this@MainActivity.startActivity(i)
    }

    private fun prepareRv(rv: RecyclerView){
        val layoutManager = LinearLayoutManager(rv.context)
        rv.layoutManager = layoutManager
        adapter = MainListAdapter(list, this, object : MainListAdapter.OnBindCallback{
            override fun onBind(holder: MainListAdapter.MainListAdapterViewHolder, position: Int) {
                holder.btn.setOnClickListener {
                    val i = Intent(this@MainActivity, DetailActivity::class.java)
                    i.putExtra("DATA", list[position])
                    this@MainActivity.startActivity(i)
                }
            }
        })
        rv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun loadDummyData(){
        list.clear()
        list.add(Makanan(1, "Rendang"
            , "Rendang makanan dari Sumatera Barat"
            , "Rendang makanan dari Sumatera Barat Yang enak sekali"
            , arrayListOf(R.drawable.i1a, R.drawable.i1b, R.drawable.i1c, R.drawable.i1d)))
        list.add(Makanan(2, "Soto"
            , "Soto merupakan masakan Indonesia"
            , "Masakan Indonesia ini yang terkenal salah satunya dari Lamongan"
            , arrayListOf(R.drawable.i2a, R.drawable.i2b, R.drawable.i2c, R.drawable.i2d, R.drawable.i2e)))
        list.add(Makanan(3, "Ayam Geprek"
            , "Ayam Geprek Kekinian di kalangan millenial"
            , "Ayam Geprek sangat terkenal di kalangan millenial sejak 2015"
            , arrayListOf(R.drawable.i3a, R.drawable.i3b, R.drawable.i3c)))
        list.add(Makanan(4, "Ayam Goreng"
            , "Ayam Goreng Enak"
            , "Ayam goreng asli Indonesia yang enak sekali"
            , arrayListOf(R.drawable.i4a)))
        list.add(Makanan(5, "Nasi Goreng"
            , "Nasi Goreng makanan asli Indonesia"
            , "Salah satu nasi goreng terenak yang pernah ada adalah nasi goreng pak bejo"
            , arrayListOf(R.drawable.i5a, R.drawable.i5b)))
        list.add(Makanan(6, "Nasi Tempong"
            , "Nasi Tempong adalah makanan khas Banyuwangi"
            , "Nasi tempong enak sekali dari banyuwangi dengan sambal khasnya"
            , arrayListOf(R.drawable.i6a)))
        list.add(Makanan(7, "Mie Goreng"
            , "Mie Goreng adalah makanan terkenal di kalangan Millenial"
            , "Mie goreng terenak yang pernah ada adalah mie goreng pak de Jo"
            , arrayListOf(R.drawable.i7a)))
        list.add(Makanan(8, "Mie Ayam Solo"
            , "Mie ayam solo adalah pangsit Mie yang berasal dari solo"
            , "Mie solo terenak adalah yang terdapat di bagu, Lumajang"
            , arrayListOf(R.drawable.i8a, R.drawable.i8b, R.drawable.i8c)))
        list.add(Makanan(9, "Mie Setan"
            , "Mie Setan adalah makanan Kekinian dengan tingkat kepedasan ekstrim"
            , "Kober mie setan adalah salah satu mie setan terenak"
            , arrayListOf(R.drawable.i9a)))
        list.add(Makanan(10, "Indomie"
            , "Indomie adalah makanan paling enak di seluruh dunia"
            , "Indomie belum tentu sehat tapi kenikmatannya bagaikan surga dunia."
            , arrayListOf(R.drawable.i10a, R.drawable.i10b)))
        list.add(Makanan(11, "Ayam Nelongso"
            , "Ayam goreng berasal dari Malang"
            , "Murah meriah dan enak"
            , arrayListOf(R.drawable.i11a)))
        list.add(Makanan(12, "Bebek Goreng"
            , "Adalah bebek yang digoreng"
            , "Enak sih, tapi rela bagi bagi wklwkwkwkwk"
            , arrayListOf(R.drawable.i12a)))

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.menuMainAbout -> {
                goToAbout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putSerializable("LIST", list)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        list.clear()
        list.addAll(savedInstanceState.getSerializable("LIST") as ArrayList<Makanan>)
    }
}
