package com.example.redscate

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class CodigoRescatista : AppCompatActivity() {
    private lateinit var etCodigo: EditText
    private lateinit var btnIngresar: MaterialButton
    private lateinit var btnAyuda :LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_codigo_rescatista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnAyuda = findViewById(R.id.btn_sos)
        btnAyuda.setOnClickListener{
            val intent = Intent(this, RadarRescatista::class.java)
            startActivity(intent)
        }

    }
}