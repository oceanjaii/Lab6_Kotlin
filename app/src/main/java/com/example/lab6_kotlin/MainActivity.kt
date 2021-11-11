package com.example.lab6_kotlin

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnDialog = findViewById<Button>(R.id.btnDialog)

        val item = arrayOf("message 1", "message 2", "message 3", "message 4", "message 5")


        btnToast.setOnClickListener {

            val toast = Toast(this)

            toast.setGravity(Gravity.TOP, 0, 50)

            toast.duration = Toast.LENGTH_SHORT

            toast.view =
                layoutInflater.inflate(R.layout.custom_toast, null)

            toast.show()
        }

        btnDialog.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("列表式 AlertDialog")
                .setItems(item) { dialogInterface, i ->
                    showToast("你選的是${item[i]}")
                }.show()
        }

    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}