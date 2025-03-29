package com.example.salessimulator.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.salessimulator.ui.theme.Padding

@Composable
fun PriceSummary(
    subtotal: Double,
    tax: Double,
    total: Double,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        PriceRow(
            label = "Subtotal:",
            amount = subtotal
        )
        PriceRow(
            label = "Tax (16%):",
            amount = tax
        )
        Divider(
            modifier = Modifier.padding(vertical = Padding.small),
            thickness = 1.dp
        )
        PriceRow(
            label = "Total:",
            amount = total,
            isTotal = true
        )
    }
}

@Composable
private fun PriceRow(
    label: String,
    amount: Double,
    isTotal: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = if (isTotal) MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold
            ) else MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "$${"%.2f".format(amount)}",
            style = if (isTotal) MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold
            ) else MaterialTheme.typography.bodyMedium
        )
    }
}