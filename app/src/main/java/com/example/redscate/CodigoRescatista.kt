package com.example.redscate

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class CodigoRescatista : AppCompatActivity() {
    private lateinit var etCodigo: EditText
    private lateinit var btnIngresar: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_codigo_rescatista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnIngresar = findViewById(R.id.ingresar)
        etCodigo = findViewById(R.id.codigo_rescatista)

        val btnAtras = findViewById<ImageView>(R.id.atras)

        btnAtras.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        etCodigo.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                etCodigo.setBackgroundResource(R.drawable.rounded_edit_text_azul) // Cambia el fondo al enfocar
            } else {
                etCodigo.setBackgroundResource(R.drawable.rounded_edit_text) // Vuelve al fondo normal
            }
        }
        btnIngresar.setOnClickListener {
            ClickBtnIngrsar()
        }
    }

    fun ClickBtnIngrsar() {
        val codigo = etCodigo.text.toString()
        if (codigo != "") {
            Rescatista()
        } else {
            etCodigo.setBackgroundResource(R.drawable.rounded_edit_text_rojo) // Cambia el fondo al enfocar
            etCodigo.hint = "Por favor completa la casilla"
            etCodigo.setHintTextColor(ContextCompat.getColor(this, R.color.rojo))
        }
    }

    fun Rescatista() {
        val intent = Intent(this, MapaRescatista::class.java)
        startActivity(intent)
    }
}