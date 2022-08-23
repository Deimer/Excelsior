package test.deymer.repository.utils

import test.deymer.repository.constants.RepositoryConstants.TAGS.TAG_DATE_FORMAT_IN
import test.deymer.repository.constants.RepositoryConstants.TAGS.TAG_DATE_FORMAT_OUT
import test.deymer.repository.constants.RepositoryConstants.TAGS.TAG_DATE_FORMAT_OUT_SHORT
import test.deymer.repository.constants.RepositoryConstants.TAGS.TAG_DATE_UNKNOWN
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

fun Int?.orZero() = this ?: 0

fun Float?.orZero() = this ?: 0F

fun String?.toHumanDate(): String {
    return this?.let {
        val formatIn = SimpleDateFormat(TAG_DATE_FORMAT_IN, Locale.ENGLISH)
        val formatOut = SimpleDateFormat(TAG_DATE_FORMAT_OUT, Locale.ENGLISH)
        val date = formatIn.parse(this.orEmpty())
        date?.let {
            formatOut.format(date)
        } ?: TAG_DATE_UNKNOWN
    } ?: TAG_DATE_UNKNOWN
}

fun String?.toShortHumanDate(): String {
    return this?.let {
        val formatIn = SimpleDateFormat(TAG_DATE_FORMAT_IN, Locale.ENGLISH)
        val formatOut = SimpleDateFormat(TAG_DATE_FORMAT_OUT_SHORT, Locale.ENGLISH)
        val date = formatIn.parse(this.orEmpty())
        date?.let {
            formatOut.format(date)
        } ?: TAG_DATE_UNKNOWN
    } ?: TAG_DATE_UNKNOWN
}

fun Float?.toShortRound(): Float {
    val decimalFormat = DecimalFormat("#.##")
    decimalFormat.roundingMode = RoundingMode.DOWN
    return decimalFormat.format(this.orZero()).toFloat()
}