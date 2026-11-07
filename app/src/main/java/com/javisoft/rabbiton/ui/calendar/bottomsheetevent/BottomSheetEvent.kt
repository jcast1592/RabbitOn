package com.javisoft.rabbiton.ui.calendar.bottomsheetevent

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import com.javisoft.rabbiton.model.EventCreationType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetEvent(
    selectedEventType: EventCreationType?,
    onSelectedEventTypeChanged: (EventCreationType?) -> Unit
) {
    selectedEventType?.let { eventType ->
        ModalBottomSheet(
            onDismissRequest = {
                onSelectedEventTypeChanged(null)
            },
            sheetState = rememberModalBottomSheetState(
                skipPartiallyExpanded = true
            )
        ) {
            when (eventType) {
                EventCreationType.SEXUAL_INTERCOURSE -> {
                    SexualIntercourseContent()
                }

                EventCreationType.CRUISING -> {
                    CruisingContent()
                }

                EventCreationType.MASTURBATION -> {
                    MasturbationContent()
                }
            }
        }
    }
}

@Composable
private fun CruisingContent() {
    Text("Cruising Event Creation")
}

@Composable
private fun MasturbationContent() {
    Text("Masturbation Event Creation")
}
