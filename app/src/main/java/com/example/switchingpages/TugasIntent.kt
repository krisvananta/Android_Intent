package com.example.switchingpages

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.switchingpages.databinding.ActivityTugasIntentBinding

class TugasIntent : AppCompatActivity() {
    private lateinit var binding: ActivityTugasIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugasIntentBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val signUp = binding.signUp
        var selectedValue: String? = null


        signUp.setOnClickListener {
            val nama = binding.nama.text.toString()
            val email = binding.email.text.toString()
            val nomor = binding.nomor.text.toString()
            val password = binding.password.text.toString()

            val laki = binding.Laki
            val perempuan = binding.Perempuan
            var kelamin = false

            if (laki.isChecked) {
                selectedValue = laki.text.toString()
                kelamin = true
            } else if (perempuan.isChecked) {
                selectedValue = perempuan.text.toString()
                kelamin = true
            } else if (!laki.isActivated && !perempuan.isActivated) {
                Toast.makeText(this, "Please fill gender type", Toast.LENGTH_SHORT).show()
            }

            if (kelamin == true && nama.isNotEmpty() && email.isNotEmpty() && nomor.isNotEmpty() && password.isNotEmpty()) {
                val intentToLoginPage = Intent(this, LoginPage::class.java)
                intentToLoginPage.putExtra("Name", nama)
                intentToLoginPage.putExtra("Email", email)
                intentToLoginPage.putExtra("Nomor", nomor)
                intentToLoginPage.putExtra("Password", password)
                intentToLoginPage.putExtra("Kelamin", selectedValue)
                startActivity(intentToLoginPage)
            } else {
                Toast.makeText(this, "Please fill form above", Toast.LENGTH_SHORT).show()
            }
        }

        binding.txtToLogIn.setOnClickListener {
            val intentToLogIn = Intent(this, LoginPage::class.java)
            startActivity(intentToLogIn)
        }


    }
}