package com.jasenovec.menuejercicios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class Ejercicio1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ejercicio1, container, false)

        val inputNumber = view.findViewById<EditText>(R.id.input_number)
        val checkButton = view.findViewById<Button>(R.id.check_prime_button)
        val resultText = view.findViewById<TextView>(R.id.result_text)

        checkButton.setOnClickListener {
            val number = inputNumber.text.toString().toIntOrNull()
            if (number != null) {
                resultText.text = if (isPrime(number)) {
                    "$number es un número primo"
                } else {
                    "$number no es un número primo"
                }
            } else {
                resultText.text = "Por favor, ingrese un número válido."
            }
        }
        return view
    }

    private fun isPrime(num: Int): Boolean {
        if (num <= 1) return false
        for (i in 2 until num) {
            if (num % i == 0) return false
        }
        return true
    }
}
