package com.ankurshukla.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val itemImage = view.findViewById<ImageView>(R.id.iv_item)
    val itemTitle = view.findViewById<TextView>(R.id.tv_item)
    val itemPrice = view.findViewById<TextView>(R.id.tv_item_price)
    val incButton = view.findViewById<ImageButton>(R.id.bt_inc)
    val currentCount = view.findViewById<TextView>(R.id.tv_current_count)
    val decButton = view.findViewById<ImageButton>(R.id.bt_dec)
}

class MainAdapter(private val items: ArrayList<Item>, private val itemListener: ItemListener): RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.layout_row, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemTitle.text = items[position].title
        holder.itemPrice.text = "Rs. ${items[position].price}"
        holder.itemImage.setImageResource(items[position].image)
        holder.incButton.setOnClickListener {
            val currentQuantity = holder.currentCount.text.toString().toInt()
            holder.currentCount.text = (currentQuantity + 1).toString()
            itemListener.onItemClick(position, 1)
        }
        holder.decButton.setOnClickListener {
            val currentQuantity = holder.currentCount.text.toString().toInt()
            if(currentQuantity > 0) {
                holder.currentCount.text = (currentQuantity - 1).toString()
                itemListener.onItemClick(position, -1)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}