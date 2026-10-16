package com.seanagueiro.a1076012510014_assignmentweek4vp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.screen.Soal1
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.screen.Soal2


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            Soal1()
        }
//        setContent{
//            Soal2()
//        }
    }
}

