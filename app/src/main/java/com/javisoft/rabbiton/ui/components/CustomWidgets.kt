package com.javisoft.rabbiton.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.javisoft.rabbiton.R

@Composable
fun FloatingActionEvent() {
    ExtendedFloatingActionButton (
        onClick = { Log.d("FloatingActionEvent", "Add Event clicked") }
    ) {
        Text("Add Event")
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(R.drawable.heart_plus_24dp),
            contentDescription = "Add Event"
        )
    }
}
