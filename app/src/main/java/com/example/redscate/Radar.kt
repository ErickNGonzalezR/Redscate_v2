package com.example.redscate

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Radar : AppCompatActivity() {
    private lateinit var btnRecursos: ImageView
    private lateinit var btnSos: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnRecursos = findViewById(R.id.recursos)
        btnRecursos.setOnClickListener {
            val intent = Intent(this, Cards::class.java)
            startActivity(intent)
        }
        btnSos = findViewById(R.id.btn_sos)
        btnSos.setOnClickListener {
            val intent = Intent(this, Radar_activo::class.java)
            startActivity(intent)
        }
    }
}