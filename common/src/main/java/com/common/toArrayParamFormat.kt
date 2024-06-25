package com.common

fun List<String>.toArrayParamFormat(): String {
    return joinToString(separator = ",", prefix = "[", postfix = "]", transform = { "\"$it\"" })
}