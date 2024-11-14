package com.jasenovec.menuejercicios

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar el DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)

        // Configurar el NavigationView
        val navigationView: NavigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawers()

            // Manejar la selección de elementos del menú
            when (menuItem.itemId) {
                R.id.menu_item_bienvenida -> replaceFragment(WelcomeFragment())
                R.id.menu_item_ejercicio_1 -> replaceFragment(Ejercicio1Fragment())
                R.id.menu_item_ejercicio_2 -> replaceFragment(Ejercicio2Fragment())
                R.id.menu_item_ejercicio_3 -> replaceFragment(Ejercicio3Fragment())
                R.id.menu_item_ejercicio_4 -> replaceFragment(Ejercicio4Fragment())
                R.id.menu_item_ejercicio_5 -> replaceFragment(Ejercicio5Fragment())
                R.id.menu_item_ejercicio_6 -> replaceFragment(Ejercicio6Fragment())
            }
            true
        }

        // Cargar el fragmento de bienvenida por defecto
        if (savedInstanceState == null) {
            replaceFragment(WelcomeFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}