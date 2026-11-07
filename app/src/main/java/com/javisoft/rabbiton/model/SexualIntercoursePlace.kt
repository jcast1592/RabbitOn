package com.javisoft.rabbiton.model

enum class SexualIntercoursePlace {
    MY_HOME,
    THEIR_HOME,
    HOTEL,
    MOTEL,
    OTHER
}

fun SexualIntercoursePlace.getName() : String = when (this) {
    SexualIntercoursePlace.MY_HOME -> "My Home"
    SexualIntercoursePlace.THEIR_HOME -> "Their Home"
    SexualIntercoursePlace.HOTEL -> "Hotel"
    SexualIntercoursePlace.MOTEL -> "Motel"
    SexualIntercoursePlace.OTHER -> "Other"
}
