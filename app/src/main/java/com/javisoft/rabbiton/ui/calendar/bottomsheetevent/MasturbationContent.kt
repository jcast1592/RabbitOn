package com.javisoft.rabbiton.ui.calendar.bottomsheetevent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.javisoft.rabbiton.ui.components.FormSubtitle
import com.javisoft.rabbiton.ui.components.FormTitle

@Composable
fun MasturbationContent() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .verticalScroll(scrollState)
            .imePadding(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        FormTitle("Masturbation")
        Spacer(modifier = Modifier.padding(8.dp))

        FormSubtitle("Duration")
        DurationMinutesInput { duration ->
            // Handle duration change
        }
        Spacer(modifier = Modifier.padding(8.dp))

        FormSubtitle("Additional Items")
        AdditionalItems()
        Spacer(modifier = Modifier.padding(8.dp))

        SubmitButton()

    }
}

@Composable
fun DurationMinutesInput(
    onDurationChanged: (Int) -> Unit
) {
    var textState by remember { mutableStateOf("") }

    OutlinedTextField(
        value = textState,
        onValueChange = { newValue ->
            // TODO("Evaluate if we need to accept less than 120min")
            if (newValue.isBlank()) {
                textState = ""
                onDurationChanged(0)
                return@OutlinedTextField
            }
            if (newValue.toIntOrNull() == null) {
                return@OutlinedTextField
            }
            if (newValue.toInt() <= 0) {
                textState = ""
                onDurationChanged(0)
                return@OutlinedTextField
            }
            val duration = newValue.toInt()
            textState = duration.toString()
            onDurationChanged(duration)
        },
        label = { Text("Duration (minutes)") },
        singleLine = true,
        suffix = { Text("min") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )
}