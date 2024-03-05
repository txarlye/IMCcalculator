package com.example.imc_calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.imc_calculator.R.id
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {


    private var currentWeig: Int = 50
    private var currentAge: Int = 45
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubstractionWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var textPeso: TextView
    private lateinit var btnSubstractionAge: FloatingActionButton
    private lateinit var btnSAddAge: FloatingActionButton
    private lateinit var textAge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)

        iniciaComponentes()
        iniciaListeners()
        initUI()
    }

    private fun iniciaComponentes() {
        val textNameSaludo = findViewById<TextView>(R.id.tv_NameSaludo)
        val name: String = intent.extras?.getString("Name").orEmpty()
        textNameSaludo.text = "Hola $name"

        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.textViewHeight)
        rsHeight = findViewById(R.id.rs_height)
        btnSubstractionWeight = findViewById(R.id.btnSubstractionWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        textAge = findViewById(R.id.tv_textAge)
        btnSubstractionAge = findViewById(R.id.btnSubstractionAge)
        btnSAddAge = findViewById(R.id.btnSAddAge)
        textPeso = findViewById(R.id.tv_textPeso)
    }

    private fun iniciaListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }
        btnSubstractionWeight.setOnClickListener {
            currentWeig += 1
            setWeig()
        }
        btnPlusWeight.setOnClickListener {
            currentWeig -= 1
            setWeig()
        }
        btnSubstractionAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnSAddAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
    }

    private fun setWeig() {
        textPeso.text = currentWeig.toString()
    }

    private fun setAge() {
        textAge.text = currentAge.toString()
    }

    private fun initUI() {
        setGenderColor()
        setWeig()
        setAge()
    }



    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }


    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }
    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if(isSelectedComponent){
            R.color.Background_comnponent_selected
        }else{
            R.color.Background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }
}