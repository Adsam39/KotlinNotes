package com.example.kotlinnotes

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView

class NoteActivity : ComponentActivity() {
    lateinit var note: TextView
    lateinit var listeNote: RecyclerView
    lateinit var btnAjouter : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_activity)

        note = findViewById(R.id.lblNote)
        listeNote = findViewById(R.id.lstNote)
        btnAjouter = findViewById(R.id.btnAdd)

        val prenomRecu = intent.getStringExtra("prenom")

        note.setText("Note de "+prenomRecu)
        note.textSize = 20f
        note.gravity = Gravity.CENTER

        btnAjouter.setOnClickListener(){
            Ajouter()
        }
    }

    fun Ajouter()
    {
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
    }
}