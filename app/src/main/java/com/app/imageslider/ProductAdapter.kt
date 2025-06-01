package com.app.imageslider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.imageslider.databinding.ProductItemBinding

class ProductAdapter(
    private val products: List<Products>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        with(holder.binding) {
            textName.text = product.name
            textPrice.text = product.price
            composeImagePager.setContent {
                ProductImagePager(product.imageUrls)
            }
//            imageFav.setImageResource(R.drawable.fac_icon)
        }
    }

    override fun getItemCount(): Int = products.size
}
