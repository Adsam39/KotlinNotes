package com.example.kotlinnotes

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import androidx.activity.ComponentActivity
import android.widget.EditText

class AddNoteActivity : ComponentActivity() {
    lateinit var text: EditText
    lateinit var btnAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note)

        text = findViewById(R.id.txtNote)
        btnAdd = findViewById(R.id.btnAddNote)
    }
}