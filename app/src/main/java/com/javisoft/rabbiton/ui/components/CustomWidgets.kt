package com.javisoft.rabbiton.ui.components

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.javisoft.rabbiton.R
import com.javisoft.rabbiton.model.EventCreationType

@Composable
fun FloatingActionEvent(isFabExpanded: Boolean, onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = onClick
    ) {
        val floatActionButtonText = if (isFabExpanded) "Close" else "Add Event"
        val floatActionButtonIcon =
            if (isFabExpanded) R.drawable.cancel_24dp else R.drawable.heart_plus_24dp
        Text(floatActionButtonText)
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(floatActionButtonIcon),
            contentDescription = "Add Event"
        )
    }
}


@Composable
fun EventCreationMenu(
    onSexualIntercourseClick: () -> Unit,
    onCruisingClick: () -> Unit,
    onMasturbationClick: () -> Unit
) {

    ExtendedFloatingActionButton(onClick = {
        Log.i("FABEvent", "Sexual Intercourse clicked")
        onSexualIntercourseClick()
    }) {
        FABContent(text = "Sexual Intercourse", iconRes = R.drawable.heart_smile_24dp)
    }

    Spacer(modifier = Modifier.height(8.dp))

    ExtendedFloatingActionButton(onClick = {
        Log.i("FABEvent", "Cruising clicked")
        onCruisingClick()
    }) {
        FABContent(text = "Cruising", iconRes = R.drawable.fire_24dp)
    }

    Spacer(modifier = Modifier.height(8.dp))

    ExtendedFloatingActionButton(onClick = {
        Log.i("FABEvent", "Masturbation clicked")
        onMasturbationClick()
    }) {
        FABContent(text = "Masturbation", iconRes = R.drawable.hand_gesture_24dp)
    }

    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
private fun FABContent(text: String, @DrawableRes iconRes: Int) {
    Text(text)
    Spacer(modifier = Modifier.width(8.dp))
    Icon(
        painter = painterResource(iconRes),
        contentDescription = text
    )
}

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
            }
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
private fun SexualIntercourseContent() {
    Text("Sexual Intercourse Event Creation")
}

@Composable
private fun CruisingContent() {
    Text("Cruising Event Creation")
}

@Composable
private fun MasturbationContent() {
    Text("Masturbation Event Creation")
}
