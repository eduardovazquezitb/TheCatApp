package com.example.thecatapp.ui.helpers

import android.text.TextUtils
import androidx.annotation.StringRes
import com.example.thecatapp.R

private const val MIN_LENGTH = 8
private const val vowels = "AEIOU"
private const val numbers = "0123456789"

data class PasswordCheckerReturn (
    val isOk : Boolean,
    @StringRes val message: Int? = null,
    val parameter: String = ""
)

fun String.isPasswordWellFormatted(): PasswordCheckerReturn {
    if(TextUtils.isEmpty(this))
        return PasswordCheckerReturn(
            isOk = false,
            message = R.string.no_empty_password
        )

    if(this.length < MIN_LENGTH)
        return PasswordCheckerReturn(
            isOk = false,
            message = R.string.min_length_password,
            parameter = MIN_LENGTH.toString()
        )

    if(vowels.filter { this.contains(it, ignoreCase = true) }.isEmpty())
        return PasswordCheckerReturn(
            isOk = false,
            message = R.string.no_vowels_password
        )

    if(numbers.filter { this.contains(it, ignoreCase = true) }.isEmpty())
        return PasswordCheckerReturn(
            isOk = false,
            message = R.string.no_numbers_password
        )

    return PasswordCheckerReturn(isOk = true)
}