package com.javisoft.rabbiton.model

import java.time.LocalDate
import java.time.LocalTime

sealed interface SexualEvent {
    val id: Long
    val date: LocalDate
    val time: LocalTime
    val notes: String?
}
