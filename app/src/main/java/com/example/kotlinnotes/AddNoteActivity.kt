package com.example.kotlinnotes

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import android.widget.EditText

class AddNoteActivity : ComponentActivity() {
    lateinit var text: EditText
    lateinit var btnAdd: Button
    lateinit var btnReturn: Button
    val lstNotes = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note)

        text = findViewById(R.id.txtNote)
        btnAdd = findViewById(R.id.btnAddNote)
        btnReturn = findViewById(R.id.btnReturn)

        btnAdd.setOnClickListener(){
            Ajouter()
        }

        btnReturn.setOnClickListener(){
            Return()
        }
    }

    fun Ajouter()
    {
        /*if(text.text.toString() == "")
        {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Veuillez écrire une note")
            /*builder.setPositiveButton("OK") { dialog, which ->
                // Code à exécuter lorsque l'utilisateur clique sur le bouton "OK"
            }*/
            builder.show()

        }
        else
        {
            var txtNote: String = text.text.toString()

            // Vérifier si la clé est déjà présente
            /*val key = 1 // La clé souhaitée
            var found = false
            for ((index, pair) in lstNotes.withIndex()) {
                if(pair.first == key){
                    lstNotes[index] = Pair(key, (pair.second.toInt()+ 1).toString())
                    found = true
                    break
                }
            }
            if (!found) {
                lstNotes.add(Pair(key, txtNote))
            }*/

            if(lstNotes.isEmpty())
            {
                lstNotes.add(Pair(0, txtNote))
            }
            else
            {
                val nbnotes = lstNotes.size
                lstNotes.add(Pair(nbnotes - 1, txtNote))
                //println(nbnotes)
            }

            // Redirection vers une autre page (nouvelle activité)
            val intent = Intent(this, NoteActivity::class.java)
            intent.putExtra("lstNote", lstNotes)
            startActivity(intent)
        }*/
        if (text.text.toString() == "") {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Veuillez écrire une note")
            builder.show()
        } else {
            val txtNote: String = text.text.toString()
            lstNotes.add(txtNote)
            val intent = Intent(this, NoteActivity::class.java)
            intent.putExtra("lstNotes", lstNotes)
            startActivity(intent)
        }
    }

    fun Return()
    {
        val intent = Intent(this, NoteActivity::class.java)
        startActivity(intent)
    }
}