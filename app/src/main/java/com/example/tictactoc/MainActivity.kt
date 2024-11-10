package com.example.tictactoc

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Handler
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var flag = 0
    var count = 0
    private lateinit var btn_1_1: Button
    private lateinit var btn_1_2: Button
    private lateinit var btn_1_3: Button
    private lateinit var btn_2_1: Button
    private lateinit var btn_2_2: Button
    private lateinit var btn_2_3: Button
    private lateinit var btn_3_1: Button
    private lateinit var btn_3_2: Button
    private lateinit var btn_3_3: Button
    private lateinit var playername_display:TextView
    private lateinit var player1Name:String
    private lateinit var player2Name:String
//    val lottieAnimator:FragmentTransactiongment=lottie_animator()






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }





        init()
    }

    fun init() {

        btn_1_1 = findViewById(R.id.btn_1_1)
        btn_1_2 = findViewById(R.id.btn_1_2)
        btn_1_3 = findViewById(R.id.btn_1_3)
        btn_2_1 = findViewById(R.id.btn_2_1)
        btn_2_2 = findViewById(R.id.btn_2_2)
        btn_2_3 = findViewById(R.id.btn_2_3)
        btn_3_1 = findViewById(R.id.btn_3_1)
        btn_3_2 = findViewById(R.id.btn_3_2)
        btn_3_3 = findViewById(R.id.btn_3_3)
        playername_display=findViewById<TextView>(R.id.playernameviewer)

        player1Name=intent.getStringExtra("player1").toString()
        player2Name=intent.getStringExtra("player2").toString()
        playername_display.setText("$player1Name Turn!!")





    }


    @SuppressLint("SetTextI18n")
    fun Check(view: View) {
        val currentbtn: Button = view as Button
        count++



        if (currentbtn.text.equals("")) {
            if (flag == 0) {
                currentbtn.setText("X")



                flag = 1
                playername_display.setText("$player2Name Turn!!")
            } else {



                currentbtn.setText("O")
                flag = 0
                playername_display.setText("$player1Name Turn!!")


            }

            if (count > 4) {
                val s1_1 = btn_1_1.text.toString()
                val s1_2 = btn_1_2.text.toString()
                val s1_3 = btn_1_3.text.toString()
                val s2_1 = btn_2_1.text.toString()
                val s2_2 = btn_2_2.text.toString()
                val s2_3 = btn_2_3.text.toString()
                val s3_1 = btn_3_1.text.toString()
                val s3_2 = btn_3_2.text.toString()
                val s3_3 = btn_3_3.text.toString()


                if (s1_1 == s1_2 && s1_2.equals(s1_3) && !s1_1.equals("")) {
                    //1 ---
                    Toast.makeText(this, "Winner is $s1_1", Toast.LENGTH_SHORT).show()
                    btn_2_1.setText("")
                    btn_2_2.setText("")
                    btn_2_3.setText("")
                    btn_3_1.setText("")
                    btn_3_2.setText("")
                    btn_3_3.setText("")
                    restart()
                } else if (s2_1.equals(s2_2) && s2_2.equals(s2_3) && !s2_1.equals("")) {
                    Toast.makeText(this, "Winner is $s2_1", Toast.LENGTH_SHORT).show()
                    btn_1_1.setText("")
                    btn_1_2.setText("")
                    btn_1_3.setText("")
                    btn_3_1.setText("")
                    btn_3_2.setText("")
                    btn_3_3.setText("")
                    restart()
                } else if (s3_1.equals(s3_2) && s3_2.equals(s3_3) && !s3_1.equals("")) {
                    Toast.makeText(this, "Winner is $s3_1", Toast.LENGTH_SHORT).show()
                    btn_1_1.setText("")
                    btn_1_2.setText("")
                    btn_1_3.setText("")
                    btn_2_1.setText("")
                    btn_2_2.setText("")
                    btn_2_3.setText("")
                    restart()
                } else if (s1_1.equals(s2_1) && s2_1.equals(s3_1) && !s1_1.equals("")) {
                    Toast.makeText(this, "Winner is $s1_1", Toast.LENGTH_SHORT).show()
                    btn_1_2.setText("")
                    btn_1_3.setText("")
                    btn_2_2.setText("")
                    btn_2_3.setText("")
                    btn_3_2.setText("")
                    btn_3_3.setText("")
                    restart()
                } else if (s1_2.equals(s2_2) && s2_2.equals(s3_2) && !s1_2.equals("")) {
                    Toast.makeText(this, "Winner is $s1_2", Toast.LENGTH_SHORT).show()
                    btn_1_1.setText("")
                    btn_1_3.setText("")
                    btn_2_1.setText("")
                    btn_2_3.setText("")
                    btn_3_1.setText("")
                    btn_3_3.setText("")
                    restart()
                } else if (s1_3.equals(s2_3) && s2_3.equals(s3_3) && !s1_3.equals("")) {
                    Toast.makeText(this, "Winner is $s1_3", Toast.LENGTH_SHORT).show()

                    btn_1_1.setText("")
                    btn_1_2.setText("")
                    btn_2_1.setText("")
                    btn_2_2.setText("")
                    btn_3_1.setText("")
                    btn_3_2.setText("")
                    restart()
                } else if (s1_1.equals(s2_2) && s2_2.equals(s3_3) && !s1_1.equals("")) {
                    Toast.makeText(this, "Winner is $s1_1", Toast.LENGTH_SHORT).show()

                    btn_1_2.setText("")
                    btn_1_3.setText("")
                    btn_2_1.setText("")
                    btn_2_3.setText("")
                    btn_3_1.setText("")
                    btn_3_2.setText("")
                    restart()
                } else if (s1_3.equals(s2_2) && s2_2.equals(s3_1) && !s1_3.equals("")) {
                    Toast.makeText(this, "Winner is $s1_3", Toast.LENGTH_SHORT).show()
                    btn_1_1.setText("")
                    btn_1_2.setText("")
                    btn_2_1.setText("")
                    btn_2_3.setText("")
                    btn_3_2.setText("")
                    btn_3_3.setText("")
                    restart()
                }



            }
            if(this.count >=9){
                Toast.makeText(this, "Draw !!!", Toast.LENGTH_SHORT).show()
                restart()
            }

        }
    }

    fun restart() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                btn_1_1.setText("")
                btn_1_2.setText("")
                btn_1_3.setText("")
                btn_2_1.setText("")
                btn_2_2.setText("")
                btn_2_3.setText("")
                btn_3_1.setText("")
                btn_3_2.setText("")
                btn_3_3.setText("")
                flag = 0
                count = 0

            }, 3000
        )

    }

}