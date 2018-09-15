package com.lianda.kotlin.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvClubs.layoutManager = LinearLayoutManager(this)

        val list:ArrayList<Club> = arrayListOf()
        list.add(Club(R.drawable.img_acm, getString(R.string.label_acmilan), getString(R.string.desc_acmilan)))
        list.add(Club(R.drawable.img_arsenal, getString(R.string.label_arsenal), getString(R.string.desc_arsenal)))
        list.add(Club(R.drawable.img_barca, getString(R.string.label_barcelona), getString(R.string.desc_barcelona)))
        list.add(Club(R.drawable.img_bayern, getString(R.string.label_bayern), getString(R.string.desc_bayern)))
        list.add(Club(R.drawable.img_chelsea, getString(R.string.label_chelsea), getString(R.string.desc_chelsea)))
        list.add(Club(R.drawable.img_city, getString(R.string.label_mancity), getString(R.string.desc_mancity)))
        list.add(Club(R.drawable.img_mu, getString(R.string.label_manunited), getString(R.string.desc_manunited)))
        list.add(Club(R.drawable.img_madrid, getString(R.string.label_madrid), getString(R.string.desc_realmadrid)))

        rvClubs.adapter = ClubAdapter(this, list){
            startActivity<DetailActivity>("name" to "${it.name}", "image" to it.image, "description" to "${it.descripstion}")
        }

    }
}
