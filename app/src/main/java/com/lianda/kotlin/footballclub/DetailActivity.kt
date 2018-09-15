package com.lianda.kotlin.footballclub

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var name:String = " "
    lateinit var nameTextView: TextView

    private var description:String = " "
    lateinit var descTextView: TextView

    private var image : Int = 0
    lateinit var imageClub: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        scrollView(){
            verticalLayout {
                padding = dip(16)

                nameTextView = textView(){
                    textSize = 24F
                    textColor = Color.BLUE
                }.lparams(){
                    bottomMargin = 24
                }

                imageClub = imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(200, 250){
                    horizontalGravity = Gravity.CENTER_HORIZONTAL
                    bottomMargin = 16
                }

                descTextView = textView()
            }
        }
        val intent = intent
        name = intent.getStringExtra("name")
        nameTextView.text = name

        description = intent.getStringExtra("description")
        descTextView.text = description

        image = intent.getIntExtra("image", 0)
        imageClub.imageResource = image


    }

}
