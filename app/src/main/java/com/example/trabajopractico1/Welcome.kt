package com.example.trabajopractico1

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Welcome : AppCompatActivity() {
    private lateinit var btnradioAndroid: RadioButton
    private lateinit var btnradioiOS: RadioButton
    private lateinit var imgAndroid: ImageView
    private lateinit var imgiOS: ImageView
    private lateinit var cbOtra: CheckBox
    private lateinit var etOtra: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initListeners()
    }

    private fun initComponents() {
        btnradioAndroid = findViewById(R.id.radioAndroid)
        btnradioiOS = findViewById(R.id.radioiOS)
        imgAndroid = findViewById(R.id.imageAndroid)
        imgiOS = findViewById(R.id.imageiOS)
        cbOtra = findViewById(R.id.cbOtra)
        etOtra = findViewById(R.id.etOtra)
    }

    private fun initListeners() {
        btnradioAndroid.setOnClickListener {
            imgAndroid.visibility = View.VISIBLE
        }

        btnradioiOS.setOnClickListener {
            imgiOS.visibility = View.VISIBLE
        }

        cbOtra.setOnClickListener {
            etOtra.visibility = View.VISIBLE
        }
    }
}