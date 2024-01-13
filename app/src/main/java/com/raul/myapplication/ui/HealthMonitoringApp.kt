package com.raul.myapplication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raul.myapplication.R
import com.raul.myapplication.data.local.NavigationDataSource
import com.raul.myapplication.data.local.NavigationDataSource.navigationItems
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealthMonitoringApp(
    navController: NavHostController = rememberNavController()
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        //MAIN NAVIGATION COMPONENT
        // HERE WE NAVIGATE THROUGH SCREENS
        //LogInScreen()
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        //coroutine for opening and closing drawer state
        val scope = rememberCoroutineScope()
        //this is to check which items from the ModalDrawerSheet are clicked and highlight them
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }

        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    Spacer(modifier = Modifier.height(16.dp))
                    navigationItems.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            label = {
                                Text(text = item.title)
                            },
                            selected = index == selectedItemIndex,
                            onClick = {
                                selectedItemIndex = index
                                navController.navigate(item.route)
                                scope.launch {
                                    drawerState.close()
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector =
                                    if (index == selectedItemIndex)
                                        item.selectedIcon
                                    else
                                        item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            },
                            badge = {
                                if (item.badgeCount != null)
                                    Text(text = item.badgeCount.toString())
                            },
                            modifier = Modifier
                                .padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }

            },
            drawerState = drawerState
        ) {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.icon_htrack),
                                    contentDescription = "app icon"
                                )
                                Text(text = "HTrack")
                            }

                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menu"
                                )
                            }
                        }
                    )
                }
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = navigationItems[0].route,
                    modifier = Modifier
                        .padding(innerPadding)
                ) {
                    composable(route = navigationItems[0].route) {
                        //ChartScreen()
                    }

                    composable(route = navigationItems[1].route) {
                        //MedRecordScreen()
                    }

                    composable(route = navigationItems[2].route) {
                        //MedicationScreen()
                    }

                    composable(route = navigationItems[3].route) {
                        //AllertsScreen()
                    }

                    composable(route = navigationItems[4].route) {
                        //AssesmentsScreen()
                    }

                    composable(route = navigationItems[5].route) {
                        //ContactInfoScreen()
                    }
                }
            }
        }
    }
}