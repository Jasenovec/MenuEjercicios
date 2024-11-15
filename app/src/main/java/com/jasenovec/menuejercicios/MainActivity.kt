package com.jasenovec.menuejercicios

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar el Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)  // Usar el Toolbar como ActionBar

        // Configurar el DrawerLayout y NavigationView
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)

        // Configurar el toggle para el Drawer Menu
        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Cargar el fragmento de bienvenida por defecto si no hay estado guardado
        if (savedInstanceState == null) {
            replaceFragment(WelcomeFragment())
            navigationView.setCheckedItem(R.id.menu_item_bienvenida)
        }

        // Configurar el listener para el Drawer Menu
        navigationView.setNavigationItemSelectedListener { menuItem ->
            val fragment: Fragment? = when (menuItem.itemId) {
                R.id.menu_item_bienvenida -> WelcomeFragment()
                R.id.menu_item_ejercicio_1 -> Ejercicio1Fragment()
                R.id.menu_item_ejercicio_2 -> Ejercicio2Fragment()
                R.id.menu_item_ejercicio_3 -> Ejercicio3Fragment()
                R.id.menu_item_ejercicio_4 -> Ejercicio4Fragment()
                R.id.menu_item_ejercicio_5 -> Ejercicio5Fragment()
                R.id.menu_item_ejercicio_6 -> Ejercicio6Fragment()
                else -> null
            }
            if (fragment != null) {
                replaceFragment(fragment)
                menuItem.isChecked = true
            }
            drawerLayout.closeDrawers()
            true
        }
    }

    // Función para cargar el fragmento
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
