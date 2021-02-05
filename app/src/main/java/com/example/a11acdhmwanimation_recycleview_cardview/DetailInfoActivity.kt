package com.example.a11acdhmwanimation_recycleview_cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.a11acdhmwanimation_recycleview_cardview.databinding.ActivityDetailInfoCountryBinding

const val COUNTRY_INTENT = "COUNTRY_FLAG"

class SharedSecondaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailInfoCountryBinding
    private lateinit var country: Country

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startAnimation()
        setupBinding()
        setupData()
    }

    private fun startAnimation(){
        with(window) {
            requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            exitTransition = Slide()
            enterTransition = Slide()
        }
    }

    private fun setupBinding() {
        binding = ActivityDetailInfoCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupData() {
        country = intent.getParcelableExtra(COUNTRY_INTENT) ?: Country("Empty", "Empty", 0)
        binding.tvCapital.text = country.capital
        binding.tvTitle.text = country.name
        binding.ivFlag.setImageDrawable(ContextCompat.getDrawable(this, country.flag))
    }
}