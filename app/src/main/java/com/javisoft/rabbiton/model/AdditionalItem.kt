package com.javisoft.rabbiton.model

enum class AdditionalItem {
    SEXUAL_TOY,
    COCK_RING,
    LUBRICANT,
    OTHER
}

fun AdditionalItem.getName() : String = when (this) {
    AdditionalItem.SEXUAL_TOY -> "Sexual Toy"
    AdditionalItem.COCK_RING -> "Cock Ring"
    AdditionalItem.LUBRICANT -> "Lubricant"
    AdditionalItem.OTHER -> "Other"
}
