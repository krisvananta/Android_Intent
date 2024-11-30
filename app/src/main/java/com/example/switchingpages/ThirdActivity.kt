package com.example.switchingpages

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.switchingpages.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private val TAG = "ThirdActivity"
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // kirim data address ke page kedua
        with(binding) {
            btnToSecondActivity.setOnClickListener {
                val resultIntent = Intent()

                resultIntent.putExtra("EXTRA_ADDRESS", etAddress.text.toString())

                setResult(Activity.RESULT_OK, resultIntent) // ini perlu ditambahin buat ngasih tau page kedua kalo ada ada kiriman data
                finish()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



    }
}