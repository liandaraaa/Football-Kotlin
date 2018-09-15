package com.lianda.kotlin.footballclub

import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import org.jetbrains.anko.*

class ClubUI : AnkoComponent<ViewGroup>{

    companion object {
        val imgId = 1
        val tvName = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        relativeLayout {
            lparams(matchParent, wrapContent)
            padding = dip(16)
            backgroundColor = Color.WHITE

            imageView {
                id = imgId
            }.lparams(100,100)

            textView {
                id = tvName
                gravity = Gravity.CENTER_VERTICAL
            }.lparams(wrapContent, wrapContent){
                margin = 16
                rightOf(imgId)
            }
        }
    }

}