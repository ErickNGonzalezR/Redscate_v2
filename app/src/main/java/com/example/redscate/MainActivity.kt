package com.example.redscate

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnIngresar: LinearLayout

    private lateinit var btnRescatista: LinearLayout

    private lateinit var etNombre: EditText
    private lateinit var nombres: String
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicialización de las vistas
        btnIngresar = findViewById(R.id.ingresar)
        btnRescatista = findViewById(R.id.rescatista)

        etNombre = findViewById(R.id.et_nombre_inicio)

        // Obtener el texto del EditText
        nombres = etNombre.text.toString()

        // Inicializar SharedPreferences y su editor
        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        //Crea la persistencia de datos
        val nombre = sharedPreferences.getString("nombre", "")
        val perfil = sharedPreferences.getString("perfil", "")


        //validacion de inicio de sesiom
        etNombre.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                etNombre.setBackgroundResource(R.drawable.rounded_edit_text_azul) // Cambia el fondo al enfocar
            } else {
                etNombre.setBackgroundResource(R.drawable.rounded_edit_text) // Vuelve al fondo normal
            }
        }
        when (perfil){
            "" -> clicks()
            "0"-> Sobreviviente()
            "1"-> Rescatista()
        }

    }

    fun clicks(){
        val btnIngresar2 = findViewById<TextView>(R.id.ingresar_2)
        val btnRescatista2 = findViewById<TextView>(R.id.rescatista_2)
        btnIngresar = findViewById(R.id.ingresar)
        btnIngresar.setOnClickListener {
            ClickBtnIngrsar()
        }

        btnRescatista.setOnClickListener {
            ClickBtnRescatista()
        }
        btnIngresar2.setOnClickListener {
            ClickBtnIngrsar()
        }

        btnRescatista2.setOnClickListener {
            ClickBtnRescatista()
        }
    }

    fun ClickBtnIngrsar() {
        nombres = etNombre.text.toString()
        if (nombres != "") {
            //persistencia de datos

            val nombre = etNombre.text.toString()
            editor.putString("nombre", nombre)
            // 0 = perfil Usuario
            // 1 = perfil Rescatista
            editor.putString("perfil", "0")
            editor.putString("edad", "")
            editor.putString("rh", "")
            editor.putString("nombreContacto", "")
            editor.putString("telefono", "")
            editor.apply()
            Sobreviviente()
        } else {
            etNombre.setBackgroundResource(R.drawable.rounded_edit_text_rojo) // Cambia el fondo al enfocar
            etNombre.hint = "Por favor completa la casilla"
            etNombre.setHintTextColor(ContextCompat.getColor(this, R.color.rojo))
        }
    }

    fun ClickBtnRescatista() {
        nombres = etNombre.text.toString()
        if (nombres != "") {
            //persistencia de datos

            val nombre = etNombre.text.toString()
            editor.putString("nombre", nombre)
            // 0 = perfil Usuario
            // 1 = perfil Rescatista
            editor.putString("perfil", "1")
            editor.putString("edad", "")
            editor.putString("rh", "")
            editor.putString("nombreContacto", "")
            editor.putString("telefono", "")
            editor.apply()
            Rescatista()
        } else {
            etNombre.setBackgroundResource(R.drawable.rounded_edit_text_rojo) // Cambia el fondo al enfocar
            etNombre.hint = "Por favor completa la casilla"
            etNombre.setHintTextColor(ContextCompat.getColor(this, R.color.rojo))
        }
    }
    fun Rescatista(){
        val intent = Intent(this, CodigoRescatista::class.java)
        startActivity(intent)
    }
    fun Sobreviviente(){
        val intent = Intent(this, Cards::class.java)
        startActivity(intent)
    }

}
/* if (nombre == "") {

 }
} else
{
/*btnIngrsar.setOnClickListener {
//persistencia de datos

val nombre = etNombre.text.toString()
editor.putString("nombre", nombre)
// 0 = perfil Usuario
// 1 = perfil Rescatista
editor.putString("perfil", "0")
editor.putString("edad", "")
editor.putString("rh", "")
editor.putString("nombreContacto", "")
editor.putString("telefono", "")
editor.apply()
val intent = Intent(this, Radar::class.java)
startActivity(intent)
}*/

}
}
/*editor.putString("edad", "")
editor.putString("rh", "")
// 0 = perfil Usuario
// 1 = perfil Rescatista
editor.putInt("perfil", 0)
editor.putString("nombre", "ramov")
editor.putString("parentesco", "")
editor.putString("telefono", "")
editor.apply()*/
/*
if (perfil == "0") {
val intent = Intent(this, Radar::class.java)
startActivity(intent)
} else if (perfil == "1") {
val intent = Intent(this, MapaRescatista::class.java)
startActivity(intent)
}*/