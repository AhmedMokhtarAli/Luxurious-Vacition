package com.example.luxuriousvacation.ui.screens.terms

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TermsAndConditionsScreen(
    modifier: Modifier = Modifier
) {
    var accepted by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Terms and Conditions",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .padding(12.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = """
                    Welcome to Luxurious Vacation!

                    Please read the following terms and conditions carefully before proceeding.

                    1. You agree not to misuse the platform or engage in illegal activities.
                    2. Luxurious Vacation reserves the right to change terms at any time.
                    3. All bookings are subject to availability and confirmation.
                    4. Refunds are governed by the refund policy provided at the time of booking.
                    5. By continuing, you agree to abide by our community rules and policies.

                    Thank you for choosing us!
                """.trimIndent(),
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}
