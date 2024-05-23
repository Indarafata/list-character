package com.example.submission_bangkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class DetailKarakter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_detail_karakter)

        // Ambil data dari Intent
        val karakterName = intent.getStringExtra("karakter_name")
        val karakterDescription = intent.getStringExtra("karakter_description")
        val karakterImage = intent.getIntExtra("karakter_image", 0)

        // Set data ke tampilan sesuai dengan ID yang ada di layout XML Anda
        val nameTextView = findViewById<TextView>(R.id.name)
        val descriptionTextView = findViewById<TextView>(R.id.detail_description)
        val imageView = findViewById<ImageView>(R.id.detail_image)

        nameTextView.text = karakterName
        descriptionTextView.text = karakterDescription
        imageView.setImageResource(karakterImage)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Tindakan ketika tombol kembali ditekan
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}