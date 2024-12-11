package com.example.playlistmaker

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class TracksViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val albumCover: ImageView = itemView.findViewById(R.id.album_cover)
    private val nameOfSong: TextView = itemView.findViewById(R.id.song_name)
    private val authorOfSong: TextView = itemView.findViewById(R.id.author_of_song)
    private val durationOfSong: TextView = itemView.findViewById(R.id.duration_of_song)

    fun bind(item: Track) {
        val imageUrl = item.artworkUrl100
        Glide.with(itemView)
            .load(imageUrl)
            .placeholder(R.drawable.placeholder)
            .centerCrop()
            .transform(RoundedCorners(2))
            .into(albumCover)
        nameOfSong.text = item.trackName
        authorOfSong.text = item.artistName
        durationOfSong.text = item.trackTime
    }
}