package com.javisoft.rabbiton.ui.calendar.bottomsheetevent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.javisoft.rabbiton.model.CruisingPlace
import com.javisoft.rabbiton.model.getName
import com.javisoft.rabbiton.ui.components.FormChip
import com.javisoft.rabbiton.ui.components.FormSubtitle
import com.javisoft.rabbiton.ui.components.FormTitle
import com.javisoft.rabbiton.ui.components.OtherOptionField

@Composable
fun CruisingContent() {
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
        FormTitle("Cruising")
        Spacer(modifier = Modifier.padding(8.dp))

        FormSubtitle("Practices")
        SexualPractices()
        Spacer(modifier = Modifier.padding(8.dp))

        FormSubtitle("Protections")
        SexualProtections()
        Spacer(modifier = Modifier.padding(8.dp))

        FormSubtitle("Places")
        CruisingPlaces()
        Spacer(modifier = Modifier.padding(8.dp))

        FormSubtitle("Participants")
        Participants()
        Spacer(modifier = Modifier.padding(8.dp))

        SubmitButton()

        Spacer(modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun CruisingPlaces() {
    var selectedPlaces by remember { mutableStateOf(setOf<CruisingPlace>()) }
    val otherSelected = CruisingPlace.OTHER in selectedPlaces
    val otherTextFieldState = rememberTextFieldState()

    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CruisingPlace.entries.forEach { place ->
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
