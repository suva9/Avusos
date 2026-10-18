package com.avusos.app.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private enum class Screen(
    val title: String,
    val subtitle: String
) {
    Dashboard("Dashboard", ""),
    Rules("Rules", "Manage your custom rules"),
    Log("Action Log", "View recorded actions"),
    Settings("Settings", "Safety and app options")
}

@Composable
fun AvusApp() {
    var screen by remember { mutableStateOf(Screen.Dashboard) }

    BackHandler(enabled = screen != Screen.Dashboard) {
        screen = Screen.Dashboard
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (screen) {
            Screen.Dashboard -> DashboardScreen {
                screen = it
            }

            else -> Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TextButton(
                    onClick = { screen = Screen.Dashboard }
                ) {
                    Text("← Back")
                }

                Text(
                    text = screen.title,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = screen.subtitle,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Text("This section will be implemented in the next stage.")
            }
        }
    }
}

@Composable
private fun DashboardScreen(onOpen: (Screen) -> Unit) {
    var automationOn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Spacer(Modifier.height(8.dp))

        Text(
            text = "AVUS OS",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 5.sp,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Version 0.1 · Prototype",
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        "Automation",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        if (automationOn) "Enabled" else "Disabled",
                        color = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        "Demo switch · Rules are not active yet",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Switch(
                    checked = automationOn,
                    onCheckedChange = { automationOn = it }
                )
            }
        }

        NavigationCard(Screen.Rules, onOpen)
        NavigationCard(Screen.Log, onOpen)
        NavigationCard(Screen.Settings, onOpen)
    }
}

@Composable
private fun NavigationCard(
    screen: Screen,
    onOpen: (Screen) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onOpen(screen) },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = screen.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = screen.subtitle,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
