package com.example.trabajopractico1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registrarse : AppCompatActivity() {

    private lateinit var btnRegistrarse: Button
    private lateinit var etNombreDeUsuarioRegistro: EditText
    private lateinit var etEmail: EditText
    private lateinit var etContraseñaRegistro: EditText
    private lateinit var etConfirmarContraseñaRegistro: EditText
    private lateinit var tvErrorRegistrarse: TextView
    private lateinit var nombreDeUsuarioActualRegistro: String
    private lateinit var emailActualRegistro: String
    private lateinit var contraseñaActualRegistro: String
    private lateinit var confirmarContraseñaActualRegistro: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrarse)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initListeners()
    }

    private fun initComponents() {
        btnRegistrarse = findViewById(R.id.btnRegistrarse)
        etNombreDeUsuarioRegistro = findViewById(R.id.etNombreDeUsuarioRegistro)
        etEmail = findViewById(R.id.etEmail)
        etContraseñaRegistro = findViewById(R.id.etContraseñaRegistro)
        etConfirmarContraseñaRegistro = findViewById(R.id.etConfirmarContraseñaRegistro)
        tvErrorRegistrarse = findViewById(R.id.tvErrorRegistrarse)
    }

    private fun initListeners() {
        btnRegistrarse.setOnClickListener {
            nombreDeUsuarioActualRegistro = etNombreDeUsuarioRegistro.text.toString()
            emailActualRegistro = etEmail.text.toString()
            contraseñaActualRegistro = etContraseñaRegistro.text.toString()
            confirmarContraseñaActualRegistro = etConfirmarContraseñaRegistro.text.toString()
            if (nombreDeUsuarioActualRegistro.isEmpty() ||
                contraseñaActualRegistro != confirmarContraseñaActualRegistro ||
                contraseñaActualRegistro.length <= 5 ||
                emailActualRegistro.isEmpty() ||
                !emailActualRegistro.contains("@")
            ) {
                tvErrorRegistrarse.visibility = View.VISIBLE
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

}