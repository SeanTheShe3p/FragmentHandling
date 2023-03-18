package com.example.fragmenthandling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.fragmenthandling.fragments.Fragment_Receive
import com.example.fragmenthandling.fragments.Fragment_Send

class MainActivity : AppCompatActivity(), comm1{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btnFrag1)
        val btn2 = findViewById<Button>(R.id.btnFrag2)

        val frag1 = Fragment_Send()
        val frag2 = Fragment_Receive()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, frag1)
            commit()
        }
        btn1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, frag1)
                addToBackStack(null)
                commit()
            }
        }
        btn2.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                val getTextFrag1 = findViewById<EditText>(R.id.edit1)
                frag2.arguments = passTheData(getTextFrag1.text.toString())

                replace(R.id.frameLayout, frag2)
                addToBackStack(null)
                commit()
            }
        }
    }

    override fun passTheData(passedText: String): Bundle {
        val bundle = Bundle()
        bundle.putString("AtoB", passedText)
        return bundle
    }

}