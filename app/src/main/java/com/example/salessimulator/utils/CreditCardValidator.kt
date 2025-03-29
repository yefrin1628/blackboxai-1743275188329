package com.example.salessimulator.utils

class CreditCardValidator {
    fun isValid(cardNumber: String): Boolean {
        if (cardNumber.length != 16 || !cardNumber.matches(Regex("\\d+"))) {
            return false
        }

        val digits = cardNumber.map { it.toString().toInt() }
        var sum = 0

        for (i in digits.indices) {
            var digit = digits[i]
            if (i % 2 == 0) { // Double every other digit starting from first
                digit *= 2
                if (digit > 9) {
                    digit = digit.toString().sumOf { it.toString().toInt() }
                }
            }
            sum += digit
        }

        return sum % 10 == 0
    }

    fun formatCardNumber(cardNumber: String): String {
        return cardNumber.chunked(4).joinToString(" ")
    }

    fun maskCardNumber(cardNumber: String): String {
        return "**** **** **** ${cardNumber.takeLast(4)}"
    }
}