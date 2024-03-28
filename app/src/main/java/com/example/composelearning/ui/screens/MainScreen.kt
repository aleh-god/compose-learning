package com.example.composelearning.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composelearning.ui.navigation.AppDestinations

@Composable
fun MainScreen(
    onClickItem: (String) -> Unit,
    modifier: Modifier = Modifier,
) {

    var currentScreen by remember { mutableStateOf(AppDestinations.MAIN.label) }

    Column(
        modifier
            .fillMaxHeight()
            .width(IntrinsicSize.Max)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppDestinations.entries
            .map { it.label }
            .forEachIndexed { index, screen ->
                Button(
                    onClick = {
                        currentScreen = screen
                        onClickItem(screen)
                    },
                    content = {
                        Row(
                            Modifier.fillMaxWidth()
                        ) {
                            Text(text = "$index.")
                            Spacer(Modifier.width(5.dp))
                            Text(text = screen)
                        }
                    }
                )
                Spacer(Modifier.height(12.dp))
            }
    }
}
