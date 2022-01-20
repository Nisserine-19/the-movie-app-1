package com.gmail.eamosse.imdb.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.eamosse.idbdata.data.Video
import com.gmail.eamosse.imdb.databinding.RecyclerVideoYtBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class VideoAdapter(private val items: List<Video>) :
    RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: RecyclerVideoYtBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val video = binding.bandeAnnonce

        fun bind(item: Video) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(RecyclerVideoYtBinding.inflate(inflater, parent, false))
    }

    private val limit = 3
    override fun getItemCount(): Int {
        return if (items.size > limit) {
            limit
        } else {
            items.size
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.bind(items[position])

        if (items[position].site.toLowerCase() == "youtube") {
            holder.video.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(items[position].key, 0F)
                }
            })
        }
    }
}
