package com.ankurshukla.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ankurshukla.recyclerview.databinding.ActivityMainBinding

class Item(
    val id: Int,
    val title: String,
    val price: Int,
    val image: Int
)

interface ItemListener {
    fun onItemClick(position: Int, quantity: Int)
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val items = arrayListOf<Item>(
        Item(100, "Belt", 1000, R.drawable.belt),
        Item(101, "Bracelet", 500, R.drawable.bracelet),
        Item(102, "Cap", 200, R.drawable.cap),
        Item(103, "Cardigan", 1500, R.drawable.cardigan),
        Item(104, "Coat", 3000, R.drawable.coat),
        Item(105, "Glove", 200, R.drawable.glove),
        Item(106, "Gown", 5000, R.drawable.gown),
        Item(107, "Jacket", 4000, R.drawable.jacket),
        Item(108, "Jeans", 1200, R.drawable.jeans),
        Item(109, "Pants", 1250, R.drawable.pants),
        Item(110, "Ring", 15000, R.drawable.ring),
        Item(111, "Scarf", 900, R.drawable.scarf),
        Item(112, "Shirt", 2600, R.drawable.shirt),
        Item(113, "Skirt", 2000, R.drawable.skirt),
        Item(114, "Slip-on Shoes", 3000, R.drawable.slip_on_shoes),
        Item(115, "Socks", 450, R.drawable.socks),
        Item(116, "T Shirt", 1700, R.drawable.t_shirt),
        Item(117, "Tie", 850, R.drawable.tie),
        Item(118, "Turtleneck", 2850, R.drawable.turtleneck),
        Item(119, "Winter Hat", 700, R.drawable.winter_hat)
    )

    private var totalPrice = 0

    private val listener = object: ItemListener {
        override fun onItemClick(position: Int, quantity: Int) {
            totalPrice += (items[position].price * quantity)
            binding.btCheckout.text = "Checkout (Rs. ${totalPrice})"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.layoutManager = LinearLayoutManager(this)

        val myAdapter = MainAdapter(items, listener)
        binding.rvMain.adapter = myAdapter

    }


}