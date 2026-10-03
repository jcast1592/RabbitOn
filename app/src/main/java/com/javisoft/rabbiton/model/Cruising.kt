package com.javisoft.rabbiton.model

import java.time.LocalDate
import java.time.LocalTime

data class Cruising(
    val sexualPractice: Set<SexualPractice>,
    val protectionType: Set<ProtectionType>,
    val cruisingPlace: Set<CruisingPlace>,
    val participantCount: Int,
    override val id: Long,
    override val date: LocalDate,
    override val time: LocalTime,
    override val notes: String?,
) : SexualEvent
