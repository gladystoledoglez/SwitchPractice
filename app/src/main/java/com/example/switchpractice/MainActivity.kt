package com.example.switchpractice

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.switchpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            scWifi.setOnCheckedChangeListener { _, isChecked ->
                showToast(isChecked, tvWifi.text.toString())
            }
            scBluetooth.setOnCheckedChangeListener { _, isChecked ->
                showToast(isChecked, tvBluetooth.text.toString())
            }
            scNotDisturb.setOnCheckedChangeListener { _, isChecked ->
                showToast(isChecked, tvNotDisturb.text.toString())
            }
            scAirplaneMode.setOnCheckedChangeListener { _, isChecked ->
                showToast(isChecked, tvAirplaneMode.text.toString())
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miBack -> finish()
            R.id.miSearch ->
                Toast.makeText(this, "You clicked on Search", Toast.LENGTH_SHORT).show()
            R.id.miFeedback ->
                Toast.makeText(this, "You clicked on Feedback", Toast.LENGTH_SHORT).show()
            R.id.miClose -> finish()
        }
        return true
    }

    private fun showToast(isEnabled: Boolean, text: String) {
        val status = if (isEnabled) "enabled" else "disabled"
        Toast.makeText(this, "You $status $text", Toast.LENGTH_SHORT).show()
    }
}