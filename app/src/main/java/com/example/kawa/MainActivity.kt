package com.example.kawa

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {

    private var selectedCoffee: String = "Espresso"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var fota = findViewById<ImageView>(R.id.fotka)

        val buttonSubmit: Button = findViewById(R.id.submit)

        var grupa = findViewById<RadioGroup>(R.id.kawa_Radio)
        grupa.setOnCheckedChangeListener { _, checkedId ->

            selectedCoffee = findViewById<RadioButton>(checkedId).text.toString()
            when(selectedCoffee){
               "Espresso" -> fota.setImageResource(R.drawable.espresso)
               "Capuccino"-> fota.setImageResource(R.drawable.capuccino)
               "Latte"-> fota.setImageResource(R.drawable.latte)
            }
        }
        val ileSeekBar = findViewById<SeekBar>(R.id.sb)
        var ile = 0
        ileSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                ile = progress
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }
            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        buttonSubmit.setOnClickListener {
            var opcja = ""
            var cuk = findViewById<CheckBox>(R.id.cu).isChecked
            var mle = findViewById<CheckBox>(R.id.ml).isChecked
            when{
                (cuk == true && mle == true) ->   opcja = "z cukrem i mlekiem."
                (cuk == true && mle == false) -> opcja = "z cukrem bez mleka."
                (cuk == false && mle == true) -> opcja = "z mlekiem bez cukru."
                else -> opcja = "bez cukru i mleka."
            }
                when (selectedCoffee) {
                    "Espresso" -> Toast.makeText(this, "Wybrana kawa to Espresso ${opcja} w ilości ${ile}", Toast.LENGTH_SHORT).show()
                    "Capuccino" -> Toast.makeText(this, "Wybrana kawa to Capuccino ${opcja} w ilości ${ile}", Toast.LENGTH_SHORT).show()
                    "Latte" -> Toast.makeText(this, "Wybrana kawa to Latte ${opcja} w ilości ${ile}", Toast.LENGTH_SHORT).show()
                }
            }


        }



    }
