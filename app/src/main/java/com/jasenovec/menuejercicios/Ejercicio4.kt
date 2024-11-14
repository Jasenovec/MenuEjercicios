package com.jasenovec.menuejercicios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class Ejercicio4Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ejercicio4, container, false)

        val inputTargetWorkers = view.findViewById<EditText>(R.id.input_target_workers)
        val calculateButton = view.findViewById<Button>(R.id.calculate_days_button)
        val resultText = view.findViewById<TextView>(R.id.result_days_text)

        calculateButton.setOnClickListener {
            val targetWorkers = inputTargetWorkers.text.toString().toIntOrNull()

            if (targetWorkers != null && targetWorkers > 0) {
                val baseWorkers = 4 // 4 trabajadores pueden construir el muro en 6 días
                val baseDays = 6
                val adjustedDays = (baseWorkers * baseDays) / targetWorkers
                resultText.text = "Los $targetWorkers trabajadores necesitarán aproximadamente $adjustedDays días para construir el muro."
            } else {
                resultText.text = "Por favor, ingrese un número válido de trabajadores."
            }
        }
        return view
    }
}
