package com.example.praktikum2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pratikum2.R

class Tugas : AppCompatActivity() {

    private var isLampOn = false
    private var isUserAction = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas)

        val lampImage = findViewById<ImageView>(R.id.lamputugas1)
        val btnProcess = findViewById<Button>(R.id.btprosestugas1)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup) // ✅ FIX

        btnProcess.setOnClickListener {
            if (!isLampOn) {
                isLampOn = true
                btnProcess.text = "TURN OFF"

                if (radioGroup.checkedRadioButtonId == -1) {
                    radioGroup.check(R.id.radioButtonPutih)
                } else {
                    updateLampColor(radioGroup.checkedRadioButtonId, lampImage)
                }

            } else {
                isLampOn = false
                btnProcess.text = "TURN ON"
                lampImage.setImageResource(R.drawable.ic_lamp_light_off)

                isUserAction = false
                radioGroup.clearCheck()
                isUserAction = true
            }
        }

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            if (!isUserAction) return@setOnCheckedChangeListener

            if (isLampOn) {
                updateLampColor(checkedId, lampImage)
            } else {
                isUserAction = false
                radioGroup.clearCheck()
                isUserAction = true

                Toast.makeText(this, "Nyalakan lampu terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateLampColor(checkedId: Int, lampImage: ImageView) {
        when (checkedId) {
            R.id.radioButtonPutih ->
                lampImage.setImageResource(R.drawable.ic_lamp_light_on_white)
            R.id.radioButtonKuning ->
                lampImage.setImageResource(R.drawable.ic_lamp_light_on_yellow)
            R.id.radioButtonBiru ->
                lampImage.setImageResource(R.drawable.ic_lamp_light_on_blue)
        }
    }
}