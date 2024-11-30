package com.example.switchingpages

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.switchingpages.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val TAG = "SecondActivity"
    private lateinit var binding: ActivitySecondBinding

    // launcher untuk menerima dari page ketiga
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
            // menerima data dari page ketiga
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val address = data?.getStringExtra("EXTRA_ADDRESS")

                with(binding) {
                    txtAddress.text = address
                }
//                 binding.txtAddress.text = address (gini juga bisa)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // receiver
        val name = intent.getStringExtra("EXTRA_NAME")
        with(binding) {
            txtName.text = name

            btnToThirdActivity.setOnClickListener {
                val intent =
                    Intent(this@SecondActivity, ThirdActivity::class.java)
                launcher.launch(intent)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {
            btnToMainActivity.setOnClickListener {
                val intentToMainActivity =
                    Intent(this@SecondActivity, MainActivity::class.java)
                startActivity(intentToMainActivity)
            }
        }
    }

    override fun onStart(){
        super.onStart()
        Log.d(TAG, "onStart dipanggil")
    }

    override fun onResume(){
        super.onResume()
        Log.d(TAG, "onResume dipanggil")
    }

}