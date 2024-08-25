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

const val NombreDeUsuarioCorrecto = "Juan Torres"
const val ContraseñaCorrecta = "1234utn"

class MainActivity : AppCompatActivity() {

    private lateinit var etNombreDeUsuario: EditText
    private lateinit var etContraseña: EditText
    private lateinit var btnIniciarSesion: Button
    private lateinit var nombreDeUsuarioActual: String
    private lateinit var contraseñaActual: String
    private lateinit var tvErrorIniciarSesion: TextView
    private lateinit var tvAccionRegistrarse: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initListeners()
    }

    private fun initComponents() {
        etNombreDeUsuario = findViewById(R.id.etNombreDeUsuario)
        etContraseña = findViewById(R.id.etContraseña)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)
        tvErrorIniciarSesion = findViewById(R.id.tvErrorIniciarSesion)
        tvAccionRegistrarse = findViewById(R.id.tvAccionRegistrarse)
    }

    private fun initListeners() {
        btnIniciarSesion.setOnClickListener {
            nombreDeUsuarioActual = etNombreDeUsuario.text.toString()
            contraseñaActual = etContraseña.text.toString()
            if (nombreDeUsuarioActual == NombreDeUsuarioCorrecto && contraseñaActual == ContraseñaCorrecta) {
                tvErrorIniciarSesion.visibility = View.GONE
                val intent = Intent(this, Welcome::class.java)
                intent.putExtra("user", nombreDeUsuarioActual)
                startActivity(intent)
            } else {
                tvErrorIniciarSesion.visibility = View.VISIBLE
            }
        }
        tvAccionRegistrarse.setOnClickListener {
            val intent = Intent(this, Registrarse::class.java)
            startActivity(intent)
        }
    }
}
