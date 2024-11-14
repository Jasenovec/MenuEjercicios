package com.jasenovec.menuejercicios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class Ejercicio3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ejercicio3, container, false)

        val inputBase = view.findViewById<EditText>(R.id.input_base)
        val inputHeight = view.findViewById<EditText>(R.id.input_height)
        val calculateButton = view.findViewById<Button>(R.id.calculate_area_button)
        val resultText = view.findViewById<TextView>(R.id.result_area_text)

        calculateButton.setOnClickListener {
            val base = inputBase.text.toString().toDoubleOrNull()
            val height = inputHeight.text.toString().toDoubleOrNull()
            if (base != null && height != null) {
                val area = 0.5 * base * height
                resultText.text = "El área del triángulo es $area"
            } else {
                resultText.text = "Por favor, ingrese valores válidos."
            }
        }
        return view
    }
}
