package com.example.switchingpages

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.switchingpages.databinding.ActivityProfilePageBinding
import com.example.switchingpages.databinding.ActivityTugasIntentBinding

class ProfilePage : AppCompatActivity() {
    private lateinit var binding: ActivityProfilePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilePageBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.namaTampil.text = binding.namaTampil.text.toString() + intent.getStringExtra("Namefromlogin")
        binding.emailTampil.text = binding.emailTampil.text.toString() + intent.getStringExtra("Emailfromlogin")
        binding.nomorTampil.text = binding.nomorTampil.text.toString() + intent.getStringExtra("Nomorfromlogin")
        binding.passwordTampil.text = binding.passwordTampil.text.toString() + intent.getStringExtra("Passwordfromlogin")
        binding.kelaminTampil.text = binding.kelaminTampil.text.toString() + intent.getStringExtra("Kelaminfromlogin")

        binding.logout.setOnClickListener {
            val intentBackToLogin = Intent(this, LoginPage::class.java)
            startActivity(intentBackToLogin)
            super.onDestroy()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}