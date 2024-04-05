package com.leagueapi.model

import com.google.gson.annotations.SerializedName


data class Champion (

    @SerializedName("version" ) var version : String?           = null,
    @SerializedName("id"      ) var id      : String?           = null,
    @SerializedName("key"     ) var key     : String?           = null,
    @SerializedName("name"    ) var name    : String?           = null,
    @SerializedName("title"   ) var title   : String?           = null,
    @SerializedName("blurb"   ) var blurb   : String?           = null,
    @SerializedName("info"    ) var info    : Info?             = Info(),
    @SerializedName("image"   ) var image   : Image?            = Image(),
    @SerializedName("tags"    ) var tags    : ArrayList<String> = arrayListOf(),
    @SerializedName("partype" ) var partype : String?           = null,
    @SerializedName("stats"   ) var stats   : Stats?            = Stats()
)