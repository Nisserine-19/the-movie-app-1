package com.gmail.eamosse.imdb.ui.favoris

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gmail.eamosse.idbdata.local.entities.FavoriteEntity
import com.gmail.eamosse.imdb.R
import com.gmail.eamosse.imdb.databinding.ItemMovieBinding

class FavorisAdapter : RecyclerView.Adapter<FavorisAdapter.ViewHolder>() {

    private lateinit var list: List<FavoriteEntity>

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setMovieList(list: List<FavoriteEntity>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(favoriteMovie: FavoriteEntity) {
            with(binding) {

                Glide.with(itemView)
                    .load("${favoriteMovie.baseUrl}${favoriteMovie.poster_path}")
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(ivMoviePoster)
                tvMovieTitle.text = favoriteMovie.original_title
                binding.root.setOnClickListener { onItemClickCallback?.onItemClick(favoriteMovie) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("adapter", "Masuk bind view holder")
        holder.bind(list[position])
    }

    interface OnItemClickCallback {
        fun onItemClick(favoriteMovie: FavoriteEntity)
    }
}