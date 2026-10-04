package com.javisoft.rabbiton.ui.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import java.time.LocalDate

@Composable
fun CalendarScreen() {

    var selectedDate by remember {
        mutableStateOf(LocalDate.now())
    }

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        EventsCalendar(
            selectedDate = selectedDate,
            onDateSelected = { date ->
                selectedDate = date
            }
        )

        SelectedDateSection(
            selectedDate = selectedDate
        )
    }
}

@Composable
fun SelectedDateSection(
    selectedDate: LocalDate
) {
    Text(
        text = "Selected Date: " +
                "${selectedDate.dayOfMonth}/${selectedDate.monthValue}/${selectedDate.year}"
    )
}
