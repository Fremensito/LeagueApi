package com.leagueapi.ui.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.leagueapi.data.LeagueApi
import com.leagueapi.databinding.ChampionItemBinding
import com.leagueapi.model.Champion

class ChampionsAdapter(val screenWidth: Int):
    ListAdapter<Champion, ChampionsAdapter.ChampionViewHolder>(ChampionsDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder {
        val binding = ChampionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return ChampionViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int){
        holder.bind(getItem(position))
    }

    internal class ChampionsDiffCallback: DiffUtil.ItemCallback<Champion>(){
        override fun areItemsTheSame(oldItem: Champion, newItem: Champion): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Champion, newItem: Champion): Boolean {
            return oldItem == newItem
        }
    }

    inner class ChampionViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val binding = ChampionItemBinding.bind(view)

        fun bind(champion: Champion){
            binding.champName.text = champion.name
            Glide.with(binding.root)
                .load("${LeagueApi.BASE_URL}cdn/14.7.1/img/champion/${champion.image?.full}")
                .override(screenWidth/6)
                .into(binding.imageView)
        }
    }
}