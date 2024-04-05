package com.leagueapi.data

import kotlinx.coroutines.flow.flow

class ChampionsService {

    companion object{
        private val leagueApi = LeagueApi.getRetrofit2Api()

        fun getChampions() = flow{
            emit(leagueApi.getChampions())
        }
    }
}