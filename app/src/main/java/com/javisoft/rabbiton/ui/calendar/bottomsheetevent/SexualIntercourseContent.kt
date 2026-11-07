package com.javisoft.rabbiton.ui.calendar.bottomsheetevent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.javisoft.rabbiton.model.ProtectionType
import com.javisoft.rabbiton.model.SexualIntercoursePlace
import com.javisoft.rabbiton.model.SexualPractice
import com.javisoft.rabbiton.model.getName
import com.javisoft.rabbiton.ui.components.FormChip
import com.javisoft.rabbiton.ui.components.FormSubtitle
import com.javisoft.rabbiton.ui.components.FormTitle
import com.javisoft.rabbiton.ui.components.OtherOptionField

@Composable
fun SexualIntercourseContent() {
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
        FormTitle("Sexual Intercourse")
        Spacer(modifier = Modifier.padding(8.dp))

        FormSubtitle("Practices")
        SexualIntercoursePractices()
        Spacer(modifier = Modifier.padding(8.dp))

        FormSubtitle("Protections")
        SexualIntercourseProtections()
        Spacer(modifier = Modifier.padding(8.dp))

        FormSubtitle("Places")
        SexualIntercoursePlaces()
        Spacer(modifier = Modifier.padding(8.dp))

        FormSubtitle("Participants")
        SexualIntercourseParticipants()
        Spacer(modifier = Modifier.padding(8.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { /*TODO*/ }
        ) {
            Text("Submit")
        }
        Spacer(modifier = Modifier.padding(8.dp))
    }
}

@Composable
private fun SexualIntercoursePractices() {
    var selectedPractices by remember { mutableStateOf(setOf<SexualPractice>()) }
    val otherTextFieldState = rememberTextFieldState()
    val otherSelected = SexualPractice.OTHER in selectedPractices

    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SexualPractice.entries.forEach { practice ->
            val isPracticeSelected: Boolean = practice in selectedPractices
            FormChip(
                chipSelected = isPracticeSelected,
                chipText = practice.getName(),
                selectedChanged = {
                    selectedPractices = if (isPracticeSelected) {
                        selectedPractices - practice
                    } else {
                        selectedPractices + practice
                    }
                }
            )
        }
        OtherOptionField(
            otherTextFieldState = otherTextFieldState,
            isOtherSelected = otherSelected,
            otherTextFieldMessage = "Which other practice?"
        )
    }
}

@Composable
private fun SexualIntercourseProtections() {
    var selectedProtections by remember { mutableStateOf(setOf<ProtectionType>()) }

    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ProtectionType.entries.forEach { protectionType ->
            val isProtectionSelected: Boolean = protectionType in selectedProtections
            FormChip(
                chipSelected = isProtectionSelected,
                chipText = protectionType.getName(),
                selectedChanged = {
                    selectedProtections = if (isProtectionSelected) {
                        selectedProtections - protectionType
                    } else {
                        selectedProtections + protectionType
                    }
                }
            )
        }
    }
}

@Composable
private fun SexualIntercoursePlaces() {
    var selectedPlaces by remember { mutableStateOf(setOf<SexualIntercoursePlace>()) }
    val otherSelected = SexualIntercoursePlace.OTHER in selectedPlaces
    val otherTextFieldState = rememberTextFieldState()


    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SexualIntercoursePlace.entries.forEach { place ->
            val isPlaceSelected: Boolean = place in selectedPlaces
            FormChip(
                chipSelected = isPlaceSelected,
                chipText = place.getName(),
                selectedChanged = {
                    selectedPlaces = if (isPlaceSelected) {
                        selectedPlaces - place
                    } else {
                        selectedPlaces + place
                    }
                }
            )
        }

        OtherOptionField(
            otherTextFieldState = otherTextFieldState,
            isOtherSelected = otherSelected,
            otherTextFieldMessage = "Which other place?"
        )
    }
}

@Composable
private fun SexualIntercourseParticipants() {

    val radioOptions = listOf(
        "1 Participant",
        "Two Participants",
        "Three to Five Participants",
        "More than Five Participants"
    )

    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    radioOptions.forEach { text ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .selectable(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) },
                    role = Role.RadioButton
                )
                .padding(vertical = 12.dp, horizontal = 4.dp),
        ) {
            RadioButton(
                selected = (text == selectedOption),
                onClick = null
            )
            Text(
                text = text,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}
