package com.example.week1_0706012110042

import Interface.cardLIstener
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week1_0706012110042.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), cardLIstener {
    private lateinit var viubain: ActivityHomeBinding
    private val adapter = Adaptor.adapter(Databes.GlobalVar.listhewan, this)
//    private var position: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viubain = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viubain.root)
        setapRV()
        addhewan()
    }

    private fun addhewan(){
        viubain.floatingActionButton2.setOnClickListener{
            val myIntent = Intent(this, addeditActivity::class.java)
            startActivity(myIntent)
        }
    }

    private fun setapRV(){
        val layoutManager = GridLayoutManager(this, 1)
        viubain.listnye.layoutManager = layoutManager
        viubain.listnye.adapter = adapter
    }

    override fun onCardClick(position: Int) {

    }


    override fun onDeleteClick(position: Int) {
        val myIntent = Intent(this, deletepopupActivity::class.java).apply {
            putExtra("position", position)
        }
        startActivity(myIntent)
    }

    override fun onEditClick(position: Int) {
        val myIntent = Intent(this, addeditActivity::class.java).apply {
            putExtra("position", position)
        }
        startActivity(myIntent)
    }


}