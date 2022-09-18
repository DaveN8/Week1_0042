package com.example.week1_0706012110042

import Databes.GlobalVar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week1_0706012110042.databinding.ActivityAddeditBinding
import model.hewan

class addeditActivity : AppCompatActivity() {
    private lateinit var viubain: ActivityAddeditBinding
    private lateinit var hewan: hewan
    private var position = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viubain = ActivityAddeditBinding.inflate(layoutInflater)
        setContentView(viubain.root)
        gentiedit()
        emboh()
    }

    private fun gentiedit(){
        position = intent.getIntExtra("position", -1)
        if(position != -1){
            val hewan = GlobalVar.listhewan[position]
            viubain.toolbar2.title = "Edit Hewan"
            viubain.textinputname.editText?.setText(hewan.nama)
            viubain.textInputjenis.editText?.setText(hewan.jenis)
            viubain.textinputusia.editText?.setText(hewan.usia.toString().toInt())
        }
    }

    private fun emboh(){
    viubain.nyimpen.setOnClickListener(){
        var jeneng = viubain.textinputname.editText?.text.toString().trim()
        var varian = viubain.textInputjenis.editText?.text.toString().trim()
        var umur = viubain.textinputusia.editText?.text.toString().trim().toInt()

        hewan = hewan(jeneng, varian, umur)
        check()
    }
        viubain.toolbar2.getChildAt(1).setOnClickListener(){
            finish()
        }
    }
    private fun check(){
        var test:Boolean = true

        if (hewan.nama!!.isEmpty()){
            viubain.textinputname.error = "Nama tidak boleh kosong"
            test = false
        }else{
            viubain.textinputname.error = ""
        }

        if (hewan.jenis!!.isEmpty()){
            viubain.textInputjenis.error = "Jenis tidak boleh kosong"
            test = false
        }else{
            viubain.textInputjenis.error = ""
        }

        if (hewan.usia!!.toString().isEmpty() || hewan.usia!! < 0){
            viubain.textinputusia.error = "Usia tidak boleh kosong"
            test = false
        }else{
            viubain.textinputusia.error = ""
        }

        if(test == true){
            if(position == -1){
                GlobalVar.listhewan.add(hewan)
            }else{
                GlobalVar.listhewan[position] = hewan
            }
            finish()
        }

    }

}