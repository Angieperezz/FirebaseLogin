package com.aristidevs.nuwelogin.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.nuwelogin.R

class CarouselCardAdapter(private val carouselDataList: ArrayList<Int>) :
    RecyclerView.Adapter<CarouselCardAdapter.CarouselCardViewHolder>() {

    class CarouselCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.carousel_card_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselCardViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel, parent, false)
        return CarouselCardViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: CarouselCardViewHolder, position: Int) {
        holder.imageView.setImageResource(carouselDataList[position])
    }

    override fun getItemCount(): Int {
        return carouselDataList.size
    }

}