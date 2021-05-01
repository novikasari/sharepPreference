package com.github.nvk.sharedpref

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class WelcomeActivity : AppCompatActivity() {

    lateinit var etNama: EditText
    lateinit var btnSubmit: Button

    lateinit var prefUtil: PreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        prefUtil = PreferenceUtil.newInstance(this)

        etNama = findViewById(R.id.et_Nama)
        btnSubmit = findViewById(R.id.btn_Submit)

        etNama.setText(prefUtil.getString("nama"))

        btnSubmit.setOnClickListener {
            saveData()
            val IntentMainActivity = Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(IntentMainActivity)
        }
    }
    private fun saveData(){
        val nama = etNama.text.toString().trim()
        prefUtil.setString("nama", nama)
        prefUtil.setBoolean("is_login", true)

    }
}