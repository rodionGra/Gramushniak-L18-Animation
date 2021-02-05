package com.example.a11acdhmwanimation_recycleview_cardview

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.util.toAndroidPair
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a11acdhmwanimation_recycleview_cardview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupRecycleView()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private val adapterCountry: CountryRecycleViewAdapter = CountryRecycleViewAdapter(Country.listOfCountry)
    private fun setupRecycleView() {
        adapterCountry.callback = { viewFlag, viewTitle, viewCapital, country ->
            val pairImage = Pair(
                viewFlag,
                resources.getString(R.string.transition_image)
            ).toAndroidPair()
            val pairTitle = Pair(
                viewTitle,
                resources.getString(R.string.transition_title)
            ).toAndroidPair()
            val pairDesc = Pair(
                viewCapital,
                resources.getString(R.string.transition_capital)
            ).toAndroidPair()
            val activityOptions = ActivityOptions.makeSceneTransitionAnimation(
                this,
                pairImage,
                pairTitle,
                pairDesc
            )
            val intent = Intent(this, SharedSecondaryActivity::class.java)
            intent.putExtra(COUNTRY_INTENT, country)
            startActivity(intent, activityOptions.toBundle())
        }
        binding.apply {
            recycleView.layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            recycleView.adapter = adapterCountry
        }
    }

}