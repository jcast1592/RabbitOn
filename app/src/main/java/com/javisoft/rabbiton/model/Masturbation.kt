package com.javisoft.rabbiton.model

import java.time.LocalDate
import java.time.LocalTime
import kotlin.time.Duration

data class Masturbation(
    val duration: Duration,
    val additionalItems: Set<AdditionalItem>,
    override val id: Long,
    override val date: LocalDate,
    override val time: LocalTime,
    override val notes: String?,
) : SexualEvent
