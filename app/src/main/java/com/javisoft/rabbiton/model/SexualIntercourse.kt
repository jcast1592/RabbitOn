package com.javisoft.rabbiton.model

import java.time.LocalDate
import java.time.LocalTime
import kotlin.time.Duration

data class SexualIntercourse(
    val duration: Duration,
    val sexualPractice: Set<SexualPractice>,
    val protectionType: Set<ProtectionType>,
    val sexualIntercoursePlace: Set<SexualIntercoursePlace>,
    val participantCount: Int,
    override val id: Long,
    override val date: LocalDate,
    override val time: LocalTime,
    override val notes: String?,
) : SexualEvent
