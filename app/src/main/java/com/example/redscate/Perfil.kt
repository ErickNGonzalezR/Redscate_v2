package com.example.redscate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Muestra los datos guardados
        val nombreApellido = findViewById<TextView>(R.id.nombre_apellido)
        val edad = findViewById<TextView>(R.id.edad)
        val rh = findViewById<TextView>(R.id.rh)
        val nombreApellidocontacto = findViewById<TextView>(R.id.nombre_apellido_emergencia)
        val telefono = findViewById<TextView>(R.id.telefono)

        val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        nombreApellido.text = sharedPreferences.getString("nombre", "Valor por defecto")
        edad.text = sharedPreferences.getString("edad", "")
        rh.text = sharedPreferences.getString("rh", "")
        nombreApellidocontacto.text = sharedPreferences.getString("nombreContacto", "")
        telefono.text = sharedPreferences.getString("telefono", "")


        //Configuracion de boton de editar perfil
        val editarPerfil = findViewById<TextView>(R.id.btn_editar_perfil)
        editarPerfil.setOnClickListener {
            val intent = Intent(this, EditarPerfil::class.java)
            startActivity(intent)
        }
        val botonAtras = findViewById<ImageView>(R.id.atras)
        botonAtras.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}