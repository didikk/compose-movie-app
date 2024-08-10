package com.example.mymovie.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mymovie.presentation.theme.SoftWhite

@Composable
fun Header(
    title: String, rightIcon: @Composable () -> Unit = {}, leftIcon: @Composable () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.width(24.dp)) {
            leftIcon()
        }
        Spacer(Modifier.weight(1f))
        Text(text = title, fontWeight = FontWeight.SemiBold, color = SoftWhite)
        Spacer(Modifier.weight(1f))
        Box(modifier = Modifier.width(24.dp)) {
            rightIcon()
        }
    }
}