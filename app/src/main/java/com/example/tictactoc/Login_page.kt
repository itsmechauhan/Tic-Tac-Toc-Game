package com.example.tictactoc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val player1=findViewById<EditText>(R.id.edit_txt1)
        val player2=findViewById<EditText>(R.id.edit_txt2)
        val inext= Intent(this@Login_page,MainActivity::class.java)
        val startbtn=findViewById<Button>(R.id.startbtn)


        startbtn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                val edittext1=player1.text.toString()
                val edittext2=player2.text.toString()

                inext.putExtra("player1",edittext1)
                inext.putExtra("player2",edittext2)


                startActivity(inext)

            }
})
    }
}