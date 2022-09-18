package com.example.week1_0706012110042

import Databes.GlobalVar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week1_0706012110042.databinding.ActivityDeletepopupBinding

class deletepopupActivity : AppCompatActivity() {
    private lateinit var viubain: ActivityDeletepopupBinding
    private var position = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viubain = ActivityDeletepopupBinding.inflate(layoutInflater)
        setContentView(viubain.root)
        hokya()
    }

    private fun hokya(){
        viubain.button.setOnClickListener {
            position = intent.getIntExtra("position", -1)
            if (position != -1){
                GlobalVar.listhewan.removeAt(position)
            }
            finish()
        }

        viubain.button4.setOnClickListener {
            finish()
        }
    }

}