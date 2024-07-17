package com.example.mymovie.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.mymovie.R

val interFont = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
)

private val defaultTypography = Typography()

val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = interFont),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = interFont),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = interFont),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = interFont),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = interFont),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = interFont),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = interFont),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = interFont),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = interFont),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = interFont),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = interFont),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = interFont),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = interFont),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = interFont),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = interFont)
)