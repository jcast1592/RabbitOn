package com.javisoft.rabbiton.ui.calendar

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import java.time.LocalDate

@Composable
fun EventsCalendar(selectedDate: LocalDate, onDateSelected: (LocalDate) -> Unit) {
    val calendarState = rememberSelectableCalendarState(
        initialSelectionMode = SelectionMode.Single,
        initialSelection = listOf(selectedDate)
    )
    SelectableCalendar(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        calendarState = calendarState
    )
    val selectedDay = calendarState.selectionState.selection.firstOrNull()
    LaunchedEffect(selectedDay) {
        Log.d("Calendar", "onDateSelected called")
        selectedDay?.let { onDateSelected(it) }
    }
}
