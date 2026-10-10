package com.javisoft.rabbiton.navigation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.javisoft.rabbiton.R
import com.javisoft.rabbiton.model.EventCreationType
import com.javisoft.rabbiton.navigation.Destinations.CALENDAR
import com.javisoft.rabbiton.navigation.Destinations.SETTINGS
import com.javisoft.rabbiton.navigation.Destinations.STATISTICS
import com.javisoft.rabbiton.ui.calendar.CalendarScreen
import com.javisoft.rabbiton.ui.components.FABEvent
import com.javisoft.rabbiton.ui.components.FloatingActionEvent
import com.javisoft.rabbiton.ui.settings.SettingsScreen
import com.javisoft.rabbiton.ui.statistics.StatisticsScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    var isFabExpanded by remember {
        mutableStateOf(false)
    }

    var selectedTypeEvent by remember {
        mutableStateOf<EventCreationType?>(null)
    }

    Scaffold(
        floatingActionButton = {
            Log.i("AppNavigation", "currentRoute: $currentRoute")
            if (currentRoute == CALENDAR) {
                Box(
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        if (isFabExpanded) {
                            FABEvent(
                                onSexualIntercourseClick = {
                                    selectedTypeEvent = EventCreationType.SEXUAL_INTERCOURSE
                                    isFabExpanded = false
                                },
                                onCruisingClick = {
                                    selectedTypeEvent = EventCreationType.CRUISING
                                    isFabExpanded = false
                                },
                                onMasturbationClick = {
                                    selectedTypeEvent = EventCreationType.MASTURBATION
                                    isFabExpanded = false
                                }
                            )
                        }
                        FloatingActionEvent(isFabExpanded) {
                            Log.d("AppNavigation", "FloatingActionEvent clicked")
                            isFabExpanded = !isFabExpanded
                        }
                    }
                }


            }
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = navController.currentDestination?.route == CALENDAR,
                    onClick = { navController.navigate(CALENDAR) },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.calendar_month_24dp),
                            contentDescription = "Calendar"
                        )
                    },
                    label = { Text("Calendar") }
                )
                NavigationBarItem(
                    selected = navController.currentDestination?.route == STATISTICS,
                    onClick = { navController.navigate(STATISTICS) },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.statistics_24dp),
                            contentDescription = "Statistics"
                        )
                    },
                    label = { Text("Statistics") }
                )
                NavigationBarItem(
                    selected = navController.currentDestination?.route == SETTINGS,
                    onClick = { navController.navigate(SETTINGS) },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.settings_24dp),
                            contentDescription = "Settings"
                        )
                    },
                    label = { Text("Settings") }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = CALENDAR,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(CALENDAR) { CalendarScreen() }
            composable(STATISTICS) { StatisticsScreen() }
            composable(SETTINGS) { SettingsScreen() }
        }

        /*ModalBottomSheetEvent(isBottomSheetVisible, onVisibleChanged = { isVisible ->
            isBottomSheetVisible = isVisible
        })*/
    }
}
