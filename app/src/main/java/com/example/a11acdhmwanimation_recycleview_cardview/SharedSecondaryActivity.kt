package com.example.a11acdhmwanimation_recycleview_cardview


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.a11acdhmwanimation_recycleview_cardview.databinding.ActivitySheredSecondaryBinding

const val COUNTRY_FLAG = "COUNTRY_FLAG"

class SharedSecondaryActivity : AppCompatActivity() {

    lateinit var binding: ActivitySheredSecondaryBinding
    lateinit var country: Country

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupData()
    }

    private fun setupBinding() {
        binding = ActivitySheredSecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupData() {
        country = intent.extras?.get(COUNTRY_FLAG) as Country? ?: Country("Empty", "Empty", 0)
        binding.tvCapital.text = country.capital
        binding.tvTitle.text = country.name
        binding.ivFlag.setImageDrawable(ContextCompat.getDrawable(this, country.flag))
    }
}