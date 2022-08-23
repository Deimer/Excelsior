package test.deymer.repository.utils

import test.deymer.repository.constants.RepositoryConstants.TAGS.TAG_BIG
import test.deymer.repository.constants.RepositoryConstants.TAGS.TAG_DATE_FORMAT_IN
import test.deymer.repository.constants.RepositoryConstants.TAGS.TAG_DATE_FORMAT_OUT
import test.deymer.repository.constants.RepositoryConstants.TAGS.TAG_DATE_FORMAT_OUT_SHORT
import test.deymer.repository.constants.RepositoryConstants.TAGS.TAG_DATE_UNKNOWN
import test.deymer.repository.constants.RepositoryConstants.TAGS.TAG_SMALL
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Locale

fun Int?.orZero() = this ?: 0

fun Float?.orZero() = this ?: 0F

fun String?.enlargeBackdrop() = this
    ?.takeIf { it.isNotEmpty() }
    ?.replace(TAG_SMALL, TAG_BIG)
    .orEmpty()

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