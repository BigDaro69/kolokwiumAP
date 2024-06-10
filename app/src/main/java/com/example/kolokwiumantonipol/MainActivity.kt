package com.example.kolokwiumantonipol

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kolokwiumantonipol.databinding.ActivityMainBinding
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val history = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        binding.obliczbtn.setOnClickListener(){
            bmi()
        }
        binding.histbtn.setOnClickListener()
        {
            history()
        }
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun bmi()
    {
        var masa = binding.wagaText.text.toString().toDouble()
        var wzrost = binding.wzrostText.text.toString().toDouble()
        var bmi = masa/(wzrost/100).pow(2)
        var bmiText = "--------Twoje BMI wynosi: %.2f-------".format(bmi)
        Toast.makeText(this, bmiText, Toast.LENGTH_SHORT).show()
        history.add("%.2f".format(bmi))
        var info : String = ""
        if (binding.plecK.isChecked)
        {
            if (bmi < 19)
            {
                info = "Niedowaga"
            }
            else if(bmi >= 19 && bmi < 24)
            {
                info = "Waga prawidłowa"
            }
            else if(bmi >= 24 && bmi < 29)
            {
                info = "Nadwaga"
            }
            else if (bmi >= 29 && bmi < 39)
            {
                info = "Otyłość"
            }
        }
        else if (binding.plecM.isChecked)
        {
            if (bmi < 20)
            {
                info = "Niedowaga"
            }
            else if(bmi >= 20 && bmi < 25)
            {
                info = "Waga prawidłowa"
            }
            else if(bmi >= 25 && bmi < 30)
            {
                info = "Nadwaga"
            }
            else if (bmi >= 30 && bmi < 40)
            {
                info = "Otyłość"
            }
        }
        Toast.makeText(this,info, Toast.LENGTH_SHORT).show()
    }
    private fun history()
    {
        Toast.makeText(this, history.toString(), Toast.LENGTH_SHORT).show()
    }
}