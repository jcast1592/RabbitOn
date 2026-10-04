package com.javisoft.rabbiton.ui.calendar

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
    SelectableCalendar(calendarState = calendarState)
    val selectedDay = calendarState.selectionState.selection.firstOrNull()
    LaunchedEffect(selectedDay) {
        Log.d("Calendar", "onDateSelected called")
        selectedDay?.let { onDateSelected(it) }
    }
}
