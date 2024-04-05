package com.leagueapi.model

data class Response(val type: String, val version: String, val data: HashMap<String, Champion>)