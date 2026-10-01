package com.javisoft.rabbiton.model

import java.time.LocalDate
import java.time.LocalTime

data class SexualEvent(
    val id: Long,
    val date: LocalDate,
    val time: LocalTime,
    val activityType: ActivityType,
    val sexualPractice: Set<SexualPractice>,
    val protectionType: Set<ProtectionType>,
    val participantCount: Int,
    val notes: String?
)
