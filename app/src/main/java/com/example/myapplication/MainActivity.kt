package com.example.myapplication

import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.myapplication.ui.theme.MyApplicationTheme

import androidx.fragment.app.FragmentActivity
import com.example.myapplication.ui.theme.Greeting

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Greeting( "Android" )
            }
        }
    }
}

