package com.javisoft.rabbiton.model

enum class SexualPractice {
    MASTURBATION,
    ORAL_ACTIVE,
    ORAL_PASSIVE,
    ANAL_ACTIVE,
    ANAL_PASSIVE,
    FROTTAGE,
    KISSING,
    OTHER
}

fun SexualPractice.getName(): String = when (this) {
    SexualPractice.MASTURBATION -> "Masturbation"
    SexualPractice.ORAL_ACTIVE -> "Oral Active"
    SexualPractice.ORAL_PASSIVE -> "Oral Passive"
    SexualPractice.ANAL_ACTIVE -> "Anal Active"
    SexualPractice.ANAL_PASSIVE -> "Anal Passive"
    SexualPractice.FROTTAGE -> "Frottage"
    SexualPractice.KISSING -> "Kissing"
    SexualPractice.OTHER -> "Other"
}
