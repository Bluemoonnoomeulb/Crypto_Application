package com.example.cryptoapp.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun convertTimestampToTime(timestamp: Long?): String {
    if (timestamp == null) return ""
    val date = Date(Timestamp(timestamp * 1000).time)
    val pattern = "HH:mm:ss"
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())
    sdf.timeZone = TimeZone.getDefault()
    return sdf.format(date)
}