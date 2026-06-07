package com.example.pratikum2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val satu=findViewById<TextView>(R.id.satu)
        val dua=findViewById<TextView>(R.id.dua)
        val tiga=findViewById<TextView>(R.id.tiga)
        val button=findViewById<Button>(R.id.button)
        val empat=findViewById<TextView>(R.id.empat)

        button.setOnClickListener {
            val Nim = satu.text.toString()
            val Nama = dua.text.toString()
            val Kelas = tiga.text.toString()

            val Hasilgabungan = "Nim : $Nim Nama : $Nama Kelas : $Kelas"
            empat.text = Hasilgabungan
        }
    }
}