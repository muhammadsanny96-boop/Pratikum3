package com.example.pratikum2

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val biru = findViewById<RadioButton>(R.id.biru)
        val hijau = findViewById<RadioButton>(R.id.hijau)
        val merah = findViewById<RadioButton>(R.id.merah)
        val btProsesLatihanWarna = findViewById<Button>(R.id.btProsesLatihanWarna)

        btProsesLatihanWarna.setOnClickListener {
            if (biru.isChecked) {
                btProsesLatihanWarna.setBackgroundColor(ContextCompat.getColor(this,R.color.biru))
            } else if (hijau.isChecked) {
                btProsesLatihanWarna.setBackgroundColor(ContextCompat.getColor(this,R.color.hijau))
            } else if (merah.isChecked) {
                btProsesLatihanWarna.setBackgroundColor(ContextCompat.getColor( this,R.color.merah))
            }
        }
    }
}