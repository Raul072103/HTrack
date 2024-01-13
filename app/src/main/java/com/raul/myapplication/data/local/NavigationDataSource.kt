package com.raul.myapplication.data.local

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import com.raul.myapplication.ui.navigation.NavigationItem

object NavigationDataSource {

    val navigationItems = listOf<NavigationItem>(
        NavigationItem(
            title = "Biometrics",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = "BiometricsScreen"
        ),
        NavigationItem(
            title = "Med Record",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            route = "MedRecordScreen"
        ),
        NavigationItem(
            title = "Medications",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
            route = "MedicationRecordScreen"
        ),
        NavigationItem(
            title = "Alerts",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            route = "AlertsScreen"
        ),
        NavigationItem(
            title = "Assessments",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            route = "   AssessmentsScreen"
        ),
        NavigationItem(
            title = "Contact Info",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            route = "ContactInfoScreen"
        )
    )

}