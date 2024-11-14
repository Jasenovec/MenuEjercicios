package com.jasenovec.menuejercicios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class Ejercicio2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ejercicio2, container, false)

        val inputAgeAna = view.findViewById<EditText>(R.id.input_age_ana)
        val calculateButton = view.findViewById<Button>(R.id.calculate_ages_button)
        val resultText = view.findViewById<TextView>(R.id.result_ages_text)

        calculateButton.setOnClickListener {
            val ageAna = inputAgeAna.text.toString().toIntOrNull()
            if (ageAna != null) {
                val ageJuan = ageAna - 5
                resultText.text = "Ana tiene $ageAna años. Juan tiene $ageJuan años."
            } else {
                resultText.text = "Por favor, ingrese una edad válida."
            }
        }
        return view
    }
}
