package com.example.constraintlayouttest

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.widget.Switch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.main_toolbar))
        findViewById<Switch>(R.id.main_footer).setOnCheckedChangeListener { _, isChecked ->
            updateConstraints(isChecked)
        }
    }

    private fun updateConstraints(setVerticalBias: Boolean) {
        val constraintSet = ConstraintSet()
        val constraintLayout = findViewById<ConstraintLayout>(R.id.main_root)

        constraintSet.clone(constraintLayout)

        if (setVerticalBias) {
            constraintSet.setVerticalBias(R.id.main_item_1, 0f)
        } else {
            constraintSet.setVerticalBias(R.id.main_item_1, 0.5f)
        }

        constraintSet.applyTo(constraintLayout)
    }
}
