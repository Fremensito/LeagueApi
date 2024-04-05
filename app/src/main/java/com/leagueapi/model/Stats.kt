package com.leagueapi.model

import com.google.gson.annotations.SerializedName

data class Stats (

  @SerializedName("hp"                   ) var hp                   : Int?    = null,
  @SerializedName("hpperlevel"           ) var hpperlevel           : Int?    = null,
  @SerializedName("mp"                   ) var mp                   : Int?    = null,
  @SerializedName("mpperlevel"           ) var mpperlevel           : Float?    = null,
  @SerializedName("movespeed"            ) var movespeed            : Int?    = null,
  @SerializedName("armor"                ) var armor                : Int?    = null,
  @SerializedName("armorperlevel"        ) var armorperlevel        : Double? = null,
  @SerializedName("spellblock"           ) var spellblock           : Int?    = null,
  @SerializedName("spellblockperlevel"   ) var spellblockperlevel   : Double? = null,
  @SerializedName("attackrange"          ) var attackrange          : Int?    = null,
  @SerializedName("hpregen"              ) var hpregen              : Double? = null,
  @SerializedName("hpregenperlevel"      ) var hpregenperlevel      : Double? = null,
  @SerializedName("mpregen"              ) var mpregen              : Float?    = null,
  @SerializedName("mpregenperlevel"      ) var mpregenperlevel      : Double? = null,
  @SerializedName("crit"                 ) var crit                 : Int?    = null,
  @SerializedName("critperlevel"         ) var critperlevel         : Int?    = null,
  @SerializedName("attackdamage"         ) var attackdamage         : Int?    = null,
  @SerializedName("attackdamageperlevel" ) var attackdamageperlevel : Double? = null,
  @SerializedName("attackspeedperlevel"  ) var attackspeedperlevel  : Double? = null,
  @SerializedName("attackspeed"          ) var attackspeed          : Double? = null

)