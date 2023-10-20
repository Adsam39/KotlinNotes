package com.example.kotlinnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.app.AlertDialog
import android.content.Intent

class MainActivity : ComponentActivity() {

    lateinit var textBienvenue: TextView
    lateinit var name: EditText
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textBienvenue = findViewById(R.id.lblBienvenue)
        name = findViewById(R.id.txtName)
        button = findViewById(R.id.btnValiderAccueil)

        textBienvenue.setText("Bienvenue sur cette application, merci d'inscrire votre prénom ci-dessous")

        button.setOnClickListener(){
            ValiderBouton()
        }
    }

    fun ValiderBouton(){
        if(name.text.toString() == "")
        {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Veuillez renseigner votre prénom")
            builder.show()

        }
        else
        {
            var prenom: String = name.text.toString()

            // Redirection vers une autre page (nouvelle activité)
            val intent = Intent(this, NoteActivity::class.java)
            intent.putExtra("prenom", prenom)
            startActivity(intent)
        }
    }
}