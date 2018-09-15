package com.lianda.kotlin.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class ClubAdapter(private val context:Context,
                  private val clubList : List<Club>,
                  private val listener: (Club) -> Unit)
    : RecyclerView.Adapter<ClubAdapter.ClubViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ClubViewHolder {
        return ClubViewHolder(ClubUI().createView(AnkoContext.Companion.create(p0.context, p0)))
    }

    override fun getItemCount(): Int {
        return clubList.size
    }

    override fun onBindViewHolder(p0: ClubViewHolder, p1: Int) {
        p0.bind(clubList[p1], listener)
    }

    class ClubViewHolder (view : View) : RecyclerView.ViewHolder(view){
        private var name = view.find<TextView>(ClubUI.tvName)
        private var image = view.find<ImageView>(ClubUI.imgId)

        fun bind (clubs : Club, listener: (Club) -> Unit){
            name.text = clubs.name
            Glide.with(itemView.context).load(clubs.image).into(image)

            itemView.setOnClickListener {
                listener(clubs)
            }
        }
    }

}
