package com.example.submission_bangkit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvKarakter: RecyclerView
    private val list = ArrayList<Karakter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKarakter = findViewById(R.id.spongebob_id)
        rvKarakter.setHasFixedSize(true)
        list.addAll(getListKarakter())
        showRecyclerList()
    }

    private fun getListKarakter(): ArrayList<Karakter> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listKarakter = ArrayList<Karakter>()
        for (i in dataName.indices) {
            val karakter = Karakter(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listKarakter.add(karakter)
        }
        return listKarakter
    }

    private fun showRecyclerList() {
        rvKarakter.layoutManager = LinearLayoutManager(this)
        val ListKarakterAdapter = ListKarakterAdapter(list)
        rvKarakter.adapter = ListKarakterAdapter

        ListKarakterAdapter.setOnItemClickCallback(object : ListKarakterAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Karakter) {
                showSelectedKarakter(data)
                val intent = Intent(this@MainActivity, DetailKarakter::class.java)
                intent.putExtra("karakter_name", data.name)
                intent.putExtra("karakter_description", data.description)
                intent.putExtra("karakter_image", data.photo)
                startActivity(intent)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutMe::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun showSelectedKarakter(karakter: Karakter) {
        Toast.makeText(this, "Kamu memilih " + karakter.name, Toast.LENGTH_SHORT).show()
    }
}