package com.example.kotlinnotes

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import android.widget.ArrayAdapter
import android.widget.ListView

class NoteActivity : ComponentActivity() {
    lateinit var note: TextView
    lateinit var listeNote: ListView
    lateinit var btnAjouter : Button
    //lateinit var prenomRecu: String

    //val prenomRecu = intent.getStringExtra("prenom")

    var compteur = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_activity)

        note = findViewById(R.id.lblNote)
        listeNote = findViewById(R.id.lstNote)
        btnAjouter = findViewById(R.id.btnAdd)

        val prenomRecu = intent.getStringExtra("prenom")

        if(listeNote.count != 0)
        {
            val lstNotes = intent.getStringArrayListExtra("lstNotes") as ArrayList<String>
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lstNotes)
            listeNote.adapter = adapter

            for(element in lstNotes)
            {
                val builder = AlertDialog.Builder(this)
                builder.setMessage(element)
                builder.show()
            }
        }

        //LoadNote()

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

    fun LoadNote()
    {
        if(listeNote.count != 0)
        {
            val lstNotes = intent.getStringArrayListExtra("lstNotes") as ArrayList<String>
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lstNotes)
            listeNote.adapter = adapter

            for(element in lstNotes)
            {
                val builder = AlertDialog.Builder(this)
                builder.setMessage(element)
                builder.show()
            }
        }
        /*if(compteur>1)
        {
            val lstNotes = intent.getSerializableExtra("lstNotes") as ArrayList<Pair<Int, String>>
            for(element in lstNotes)
            {
                val builder = AlertDialog.Builder(this)
                builder.setMessage(element.second)
                builder.show()
            }

            val adapter = ArrayAdapter<Pair<Int, String>>(this, android.R.layout.simple_list_item_1, lstNotes)

            listeNote.adapter = adapter
        }
        else if(listeNote.count>1)
        {
            val lstNotes = intent.getSerializableExtra("lstNotes") as ArrayList<Pair<Int, String>>
            val adapter = ArrayAdapter<Pair<Int, String>>(this, android.R.layout.simple_list_item_1, lstNotes)
            listeNote.adapter = adapter
        }*/
        //val lstNotes = intent.getStringArrayListExtra("lstNotes") as ArrayList<String>
        /*if (lstNotes.isNotEmpty()) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lstNotes)
            listeNote.adapter = adapter
        }*/
    }
}