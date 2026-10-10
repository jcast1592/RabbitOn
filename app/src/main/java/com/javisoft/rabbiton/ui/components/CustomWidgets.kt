package com.javisoft.rabbiton.ui.components

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
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

@Composable
fun FloatingActionEvent(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = onClick
    ) {
        Text("Add Event")
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(R.drawable.heart_plus_24dp),
            contentDescription = "Add Event"
        )
    }
}


@Composable
fun FABEvent(onSexualIntercourseClick: () -> Unit,
             onCruisingClick: () -> Unit,
             onMasturbationClick: () -> Unit
) {

    ExtendedFloatingActionButton(onClick = {
        Log.i("FABEvent", "Sexual Intercourse clicked")
        onSexualIntercourseClick()
    }) {
        Text("Sexual Intercourse")
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(R.drawable.heart_smile_24dp),
            contentDescription = "Add Event"
        )
    }

    Spacer(modifier = Modifier.height(8.dp))

    ExtendedFloatingActionButton(onClick = {
        Log.i("FABEvent", "Cruising clicked")
        onCruisingClick()
    }) {
        Text("Cruising")
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(R.drawable.fire_24dp),
            contentDescription = "Add Event"
        )
    }

    Spacer(modifier = Modifier.height(8.dp))

    ExtendedFloatingActionButton(onClick = {
        Log.i("FABEvent", "Masturbation clicked")
        onMasturbationClick()
    }) {
        Text("Masturbation")
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(R.drawable.hand_gesture_24dp),
            contentDescription = "Add Event"
        )
    }

    Spacer(modifier = Modifier.height(16.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetEvent(isBottomSheetVisible: Boolean, onVisibleChanged: (Boolean) -> Unit) {
    Log.i("ModalBottomSheetEvent", "isBottomSheetVisible: $isBottomSheetVisible")
    if (isBottomSheetVisible) {
        ModalBottomSheet(
            onDismissRequest = {
                onVisibleChanged(false)
            }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ActivityCard(R.drawable.heart_plus_24dp, "Sexual\nIntercourse")
                ActivityCard(R.drawable.fire_24dp, "Cruising")
                ActivityCard(R.drawable.hand_gesture_24dp, "Masturbation")
            }
        }
    }
}

@Composable
fun ActivityCard(@DrawableRes activityIcon: Int, activityText: String) {
    Card(
        modifier = Modifier.width(120.dp)
    ) {
        Column {
            Icon(
                painter = painterResource(activityIcon),
                contentDescription = activityText
            )
            Text(text = activityText)
        }
    }
}
