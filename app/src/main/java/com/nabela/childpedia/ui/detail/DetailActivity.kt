package com.nabela.childpedia.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nabela.childpedia.R

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_IMG = "extra_img"
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_DESCRIPTION = "extra_description"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}