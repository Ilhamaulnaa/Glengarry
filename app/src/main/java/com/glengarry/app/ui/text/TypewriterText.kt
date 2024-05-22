package com.glengarry.app.ui.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.glengarry.app.ui.theme.poppinsFontFamily
import kotlinx.coroutines.delay
import kotlin.streams.toList

@Composable
fun TypewriterText(texts: List<String>) {

    var textIndex by remember {
        mutableIntStateOf(0)
    }
    var textToDisplay by remember {
        mutableStateOf("")
    }
    val textCharList: List<List<String>> = remember {
        texts.map {
            it.splitToCodePoint()
        }
    }

    LaunchedEffect(
        key1 = texts,
    ){
        while (textIndex < textCharList.size){
            textCharList[textIndex].forEachIndexed{ charIndex, _ ->
                textToDisplay = textCharList[textIndex]
                    .take(
                        n = charIndex + 1,
                    ).joinToString(
                        separator = ""
                    )
                delay(100)
            }
            textIndex = (textIndex + 1) % texts.size
            delay(800)
        }
    }

    Text(
        text = textToDisplay,
        fontSize = 12.sp,
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Medium,
        maxLines = 1,
        color = Color(0xFF999999)
    )
    
}

fun String.splitToCodePoint(): List<String> {
    return codePoints()
        .toList()
        .map {
            String(Character.toChars(it))
        }
}
