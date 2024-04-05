package com.leagueapi.ui.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.leagueapi.data.LeagueApi
import com.leagueapi.databinding.ChampionItemBinding
import com.leagueapi.model.Champion

class ChampionsAdapter(val champions: ArrayList<Champion>, val screenWidth: Int):
RecyclerView.Adapter<ChampionsAdapter.ChampionViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder {
        return ChampionViewHolder(
            ChampionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
        )
    }

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        holder.bind(champions[position])
    }

    override fun getItemCount() = champions.size

    inner class ChampionViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val binding = ChampionItemBinding.bind(view)

        fun bind(champion: Champion){
            binding.champName.text = champion.name
            Glide.with(binding.root)
                .load("${LeagueApi.BASE_URL}cdn/14.7.1/img/champion/${champion.image?.full}")
                .override(screenWidth/8)
                .into(binding.imageView)
        }
    }
}