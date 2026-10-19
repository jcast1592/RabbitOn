package com.javisoft.rabbiton.ui.components

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.javisoft.rabbiton.R

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

    EventTypeFab(
        text = "Sexual Intercourse",
        iconRes = R.drawable.heart_smile_24dp,
        onClick = onSexualIntercourseClick
    )

    Spacer(modifier = Modifier.height(8.dp))

    EventTypeFab(
        text = "Cruising",
        iconRes = R.drawable.fire_24dp,
        onClick = onCruisingClick
    )

    Spacer(modifier = Modifier.height(8.dp))

    EventTypeFab(
        text = "Masturbation",
        iconRes = R.drawable.hand_gesture_24dp,
        onClick = onMasturbationClick
    )

    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
private fun EventTypeFab(
    text: String,
    @DrawableRes iconRes: Int,
    onClick: () -> Unit
) {
    ExtendedFloatingActionButton(onClick = {
        Log.i("FABEvent", "$text clicked")
        onClick()
    }) {
        FabContent(text = text, iconRes = iconRes)
    }
}

@Composable
private fun FabContent(text: String, @DrawableRes iconRes: Int) {
    Text(text)
    Spacer(modifier = Modifier.width(8.dp))
    Icon(
        painter = painterResource(iconRes),
        contentDescription = text
    )
}

@Composable
fun FormTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun FormSubtitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium
    )
}

@Composable
fun FormChip(
    chipSelected: Boolean,
    chipText: String,
    selectedChanged: () -> Unit
) {
    ElevatedFilterChip(
        selected = chipSelected,
        onClick = {
            selectedChanged()
        },
        label = { Text(chipText) },
        leadingIcon = if (chipSelected) {
            {
                Icon(
                    painter = painterResource(R.drawable.check_circle_24dp),
                    contentDescription = null,
                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}

@Composable
fun OtherOptionField(
    otherTextFieldState: TextFieldState,
    isOtherSelected: Boolean,
    otherTextFieldMessage: String
) {
    if (isOtherSelected) {
        TextField(
            state = otherTextFieldState,
            label = { Text(otherTextFieldMessage) },
            modifier = Modifier.fillMaxWidth(),
            lineLimits = TextFieldLineLimits.SingleLine
        )
    }
}
