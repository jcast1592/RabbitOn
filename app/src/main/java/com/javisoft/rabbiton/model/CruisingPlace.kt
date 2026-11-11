package com.javisoft.rabbiton.model

enum class CruisingPlace {
    STEAM_BATH,
    SEX_CLUB,
    SUBWAY,
    PARK,
    WC,
    CINEMA,
    OTHER
}

fun CruisingPlace.getName() : String = when (this) {
    CruisingPlace.STEAM_BATH -> "Steam Bath"
    CruisingPlace.SEX_CLUB -> "Sex Club"
    CruisingPlace.SUBWAY -> "Subway"
    CruisingPlace.PARK -> "Public Park"
    CruisingPlace.WC -> "WC"
    CruisingPlace.CINEMA -> "Cinema"
    CruisingPlace.OTHER -> "Other"
}
