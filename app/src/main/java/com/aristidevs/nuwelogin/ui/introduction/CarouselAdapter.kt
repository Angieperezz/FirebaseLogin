package com.aristidevs.nuwelogin.ui.introduction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.aristidevs.nuwelogin.R

class CarouselAdapter(private val items: List<CarouselItem>) : PagerAdapter() {

    var currentImageIndex = 0
    override fun getCount(): Int {
        return items.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(parent: ViewGroup, position: Int): Any {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel, parent, false)
        val imageView = viewHolder.findViewById<ImageView>(R.id.carousel_card_image)
        imageView.setImageResource(items[position].imageResource)

        if (position == 0) {
            currentImageIndex = 0
        } else if (position == 1) {
            currentImageIndex = 1
        } else if (position == 2) {
            currentImageIndex = 2
        }
        parent.addView(viewHolder)
        return viewHolder
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}