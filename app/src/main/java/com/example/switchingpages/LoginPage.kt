package com.example.switchingpages

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.switchingpages.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtToSignUp.setOnClickListener {
            val intentToTugasIntent = Intent(this, TugasIntent::class.java)
            startActivity(intentToTugasIntent)
        }

        binding.logIn.setOnClickListener {
            val namaLogIn = binding.namaLogIn.text.toString()
            val passwordLogIn = binding.passwordLogIn.text.toString()

            if (namaLogIn.isEmpty() && passwordLogIn.isEmpty()) {
                Toast.makeText(this, "Please fill form above", Toast.LENGTH_SHORT).show()
            }else {
                if (namaLogIn == intent.getStringExtra("Name") && passwordLogIn == intent.getStringExtra("Password")){
                    val intentToProfilePage = Intent(this, ProfilePage::class.java)
                    intentToProfilePage.putExtra("Namefromlogin", intent.getStringExtra("Name"))
                    intentToProfilePage.putExtra("Emailfromlogin", intent.getStringExtra("Email"))
                    intentToProfilePage.putExtra("Nomorfromlogin", intent.getStringExtra("Nomor"))
                    intentToProfilePage.putExtra("Passwordfromlogin", intent.getStringExtra("Password"))
                    intentToProfilePage.putExtra("Kelaminfromlogin", intent.getStringExtra("Kelamin"))
                    startActivity(intentToProfilePage)
                }else {
                    Toast.makeText(this, "Password or Name is invalid", Toast.LENGTH_SHORT).show()
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}