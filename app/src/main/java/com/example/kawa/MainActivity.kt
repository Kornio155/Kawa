package com.example.kawa

import android.os.Bundle
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

class MainActivity : AppCompatActivity() {

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
        var isEspresso = findViewById<RadioButton>(R.id.es).isChecked
        var capuccino = findViewById<RadioButton>(R.id.ca).isChecked
        var latte = findViewById<RadioButton>(R.id.la).isChecked

        val buttonSubmit: Button = findViewById(R.id.submit)

        var cuk = findViewById<CheckBox>(R.id.cu).isChecked
        var mle = findViewById<CheckBox>(R.id.ml).isChecked

        var grupa = findViewById<RadioGroup>(R.id.kawa_Radio)
        grupa.setOnCheckedChangeListener { _, checkedId ->




            when{
                isEspresso -> fota.setImageResource(R.drawable.espresso)
                capuccino -> fota.setImageResource(R.drawable.capuccino)
                latte -> fota.setImageResource(R.drawable.latte)
            }


        }
        buttonSubmit.setOnClickListener {
            var opcja = ""

            if (cuk == true && mle == true){
                opcja = "z cukrem i mlekiem."
            }
            else if (cuk == true && mle == false){
                opcja = "z cukrem bez mleka."
            }
            else if (cuk == false && mle == true){
                opcja = "z mlekiem bez cukru."
            }
            else{
                opcja = "bez cukru i mleka."
            }

            var ile = findViewById<SeekBar>(R.id.sb)


            when{
                isEspresso -> Toast.makeText(this, "Wybrana kawa to Espresso ${opcja} w ilości ${ile}", Toast.LENGTH_SHORT).show()
                capuccino -> Toast.makeText(this, "Wybrana kawa to Capuccino ${opcja} w ilości ${ile}", Toast.LENGTH_SHORT).show()
                latte -> Toast.makeText(this, "Wybrana kawa to Latte ${opcja} w ilości ${ile}", Toast.LENGTH_SHORT).show()
            }



        }



    }
}