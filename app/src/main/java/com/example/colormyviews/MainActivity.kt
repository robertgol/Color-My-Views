package com.example.colormyviews

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val colorSetListener = OnClickListener {
        it.setBackgroundColor(currentColor ?: Color.GRAY)
        currentColor = null
    }

    private var currentColor: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeButtons()
        initializeTextViews()
        initializeLayout()
    }

    private fun initializeButtons() {
        listOf(redButton, greenButton, blueButton).forEach { setCurrentColorChangeListener(it) }
    }

    private fun setCurrentColorChangeListener(button: Button) {
        button.setOnClickListener { currentColor = it.getBackgroundColor() }
    }

    private fun View.getBackgroundColor() = (background as ColorDrawable).color

    private fun initializeTextViews() {
        listOf(
            boxOneTextView,
            boxTwoTextView,
            boxThreeTextView,
            boxFourTextView,
            boxFiveTextView
        ).forEach { it.setOnClickListener(colorSetListener) }
    }

    private fun initializeLayout() {
        layout.setOnClickListener {
            colorSetListener.onClick(it)
            hideHowToPlayGuide()
        }
    }

    private fun hideHowToPlayGuide() {
        howToPlayTextView.visibility = View.GONE
        guideTextView.visibility = View.GONE
    }
}
