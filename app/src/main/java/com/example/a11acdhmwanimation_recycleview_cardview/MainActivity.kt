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
        setupListeners()
        setupRecycleView()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private val adapter: RecycleViewAdapter = RecycleViewAdapter()
    private fun setupRecycleView() {
        adapter.callback = { viewFlag, viewTitle, viewCapital, country ->
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
            intent.putExtra(COUNTRY_FLAG, country)
            startActivity(intent, activityOptions.toBundle())
        }
        binding.recycleView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        adapter.list = Country.listOfCountry
        binding.recycleView.adapter = adapter
    }

    private fun setupListeners() {

    }

    /*TODO CLEAN UP
    private fun startSecondaryActivity() {
        val intent = Intent(this, SharedSecondaryActivity::class.java)
        val pairImage = Pair<View, String>(
            binding.ivFlag,
            resources.getString(R.string.transition_image)
        ).toAndroidPair()
        val pairTitle = Pair<View, String>(
            binding.tvTitle,
            resources.getString(R.string.transition_title)
        ).toAndroidPair()
        val pairDesc = Pair<View, String>(
            binding.tvCapital,
            resources.getString(R.string.transition_capital)
        ).toAndroidPair()
        val pairBack = Pair<View, String>(
            binding.cardView,
            resources.getString(R.string.transition_container)
        ).toAndroidPair()
        val activityOptions = ActivityOptions.makeSceneTransitionAnimation(
            this,
            pairImage,
            pairTitle,
            pairDesc,
            pairBack
        )
        startActivity (intent, activityOptions.toBundle())
    }*/

}