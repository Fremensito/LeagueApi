package com.leagueapi.data

import com.leagueapi.model.Response

interface BaseDataService {
    abstract val leagueApi: ()-> Response
    fun getGeneralData()
}