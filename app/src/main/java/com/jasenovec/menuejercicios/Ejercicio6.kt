package com.jasenovec.menuejercicios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class Ejercicio6Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ejercicio6, container, false)

        val inputNumber = view.findViewById<EditText>(R.id.input_number_compound)
        val checkButton = view.findViewById<Button>(R.id.check_compound_button)
        val resultText = view.findViewById<TextView>(R.id.result_compound_text)

        checkButton.setOnClickListener {
            val number = inputNumber.text.toString().toIntOrNull()
            if (number != null && number > 1) {
                val factors = (1..number).filter { number % it == 0 }
                val isComposite = factors.size > 2
                val compositeText = if (isComposite) "es un número compuesto" else "no es un número compuesto"
                resultText.text = "Factores de $number: ${factors.joinToString(", ")}.\nEl número $number $compositeText."
            } else {
                resultText.text = "Por favor, ingrese un número válido mayor que 1."
            }
        }
        return view
    }
}
