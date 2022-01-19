package com.gmail.eamosse.imdb.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gmail.eamosse.idbdata.data.PopularMovies
import com.gmail.eamosse.imdb.databinding.PopularListItemBinding

class DashboardAdapter(private val items: List<PopularMovies>) :
    RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: PopularListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val popularimage = binding.popularImg
        fun bind(item: PopularMovies) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(PopularListItemBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

        Glide.with(holder.popularimage.context)
            .load("https://image.tmdb.org/t/p/w500/" + items[position].posterPath)
            .into(holder.popularimage)

        holder.itemView.setOnClickListener {
            val action =
                DashboardFragmentDirections.actionDashboardFragmentToDashboardSecondFragment(items[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }
}
