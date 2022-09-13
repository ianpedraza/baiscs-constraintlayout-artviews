package com.ianpedraza.artviews.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ianpedraza.artviews.R
import com.ianpedraza.artviews.databinding.ActivityMainBinding
import com.ianpedraza.artviews.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    private val views: List<View> by lazy {
        binding.run {
            listOf(
                tvBoxOne,
                tvBoxTwo,
                tvBoxThree,
                tvBoxFour,
                tvBoxFive,
                clMain,
                btnRed,
                btnYellow,
                btnGreen,
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        views.forEach { item ->
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            // Boxes using Color class colors for background
            R.id.tv_box_one -> view.setBackgroundColor(Color.DKGRAY)
            R.id.tv_box_two -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.tv_box_three -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.tv_box_four -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.tv_box_five -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.btn_red -> binding.tvBoxThree.setBackgroundResource(R.color.app_red)
            R.id.btn_yellow -> binding.tvBoxFour.setBackgroundResource(R.color.app_yellow)
            R.id.btn_green -> binding.tvBoxFive.setBackgroundResource(R.color.app_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

}