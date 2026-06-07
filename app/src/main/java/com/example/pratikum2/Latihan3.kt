package com.example.pratikum2

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner =findViewById<Spinner>(R.id.spinner)
        val button2 = findViewById<Button>(R.id.button2)

        button2.setOnClickListener {
            val pilihan = spinner.selectedItem.toString()
            when (pilihan) {
                "Merah" ->
                    button2.setBackgroundColor(ContextCompat.getColor( this, R.color.merah))
                "Hijau" ->
                    button2.setBackgroundColor(ContextCompat.getColor(this, R.color.hijau))
                "Biru" ->
                    button2.setBackgroundColor(ContextCompat.getColor( this, R.color.biru))

                else -> {
                    val builder = AlertDialog.Builder(this)
                    builder
                        .setTitle("Peringatan")
                        .setMessage("warna akan direset ke awal, apakah anda yakin?")
                        .setPositiveButton("Ok") {
                            dialog, which ->
                            dialog.dismiss()
                            button2.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
                        }
                        .setNegativeButton("Batal") {
                            dialog, which -> dialog.dismiss()
                        }
                        .show()
                }
            }
        }
    }
}