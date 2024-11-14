package com.jasenovec.menuejercicios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class Ejercicio5Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ejercicio5, container, false)

        val listFactorsButton = view.findViewById<Button>(R.id.list_factors_button)
        val resultText = view.findViewById<TextView>(R.id.result_factors_text)

        listFactorsButton.setOnClickListener {
            val number = 60
            val factors = getFactors(number)
            val isComposite = factors.size > 2 // Un número compuesto tiene más de dos factores

            val compositeMessage = if (isComposite) {
                "El número $number es un número compuesto porque tiene más de dos factores: los factores son ${factors.joinToString(", ")}."
            } else {
                "El número $number no es un número compuesto porque solo tiene dos factores."
            }

            resultText.text = "Factores de $number: ${factors.joinToString(", ")}.\n$compositeMessage"
        }
        return view
    }

    private fun getFactors(number: Int): List<Int> {
        val factors = mutableListOf<Int>()
        for (i in 1..number) {
            if (number % i == 0) {
                factors.add(i)
            }
        }
        return factors
    }
}