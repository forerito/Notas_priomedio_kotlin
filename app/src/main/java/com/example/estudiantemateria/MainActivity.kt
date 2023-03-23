package com.example.estudiantemateria

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonCalcular:Button= findViewById(R.id.btncalcular)
        botonCalcular.setOnClickListener { realizarCalculo() }

    }

    private fun realizarCalculo() {

        val campoNombre:EditText = findViewById(R.id.idNombreText)
        val campoMateria:EditText = findViewById(R.id.idNombreMateriaText)
        val campoNota1:EditText = findViewById(R.id.idMateria1Text)
        val campoNota2:EditText = findViewById(R.id.idMateria2Text)
        val campoNota3:EditText = findViewById(R.id.idMateria3Text)
        val campoResultado:TextView = findViewById(R.id.txtMensaje1)

        val nombre:String = campoNombre.text.toString()
        val materia:String = campoMateria.text.toString()
        val nota1:Double = campoNota1.text.toString().toDouble()
        val nota2:Double = campoNota2.text.toString().toDouble()
        val nota3:Double = campoNota3.text.toString().toDouble()

        var prom:Double=(nota1+nota2+nota3)/3

        var result=""

        if (prom>=3.5){
            result=" Estudiante: $nombre \n Materia: $materia \n Nota 1: $nota1 \n Nota 2: $nota2 \n Nota 3: $nota3 \n " +
                    "Ganó con una nota de: $prom"
            campoResultado.setTextColor(Color.GREEN)

        }else{
            result=" Estudiante: $nombre \n Materia: $materia \n Nota 1: $nota1 \n Nota 2: $nota2 \n Nota 3: $nota3 \n " +
                    "Perdió con una nota de: $prom"
            campoResultado.setTextColor(Color.RED)
        }

        campoResultado.text=result

        //Mostrar en otra pantalla
        val intent = Intent(this,estudiantesmateriaresponse::class.java)

        val miBundle:Bundle = Bundle()
        miBundle.putString("Promedio",campoResultado!!.text.toString())

        intent.putExtras(miBundle)
        startActivity(intent)
        }
    }