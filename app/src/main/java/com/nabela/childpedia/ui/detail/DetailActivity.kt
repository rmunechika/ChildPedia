package com.nabela.childpedia.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.nabela.childpedia.R
import com.nabela.childpedia.databinding.ActivityDetailBinding
import com.nabela.childpedia.databinding.FragmentDetailContentBinding
import java.util.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_IMG = "extra_img"
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_CATEGORY = "extra category"
        const val EXTRA_DESCRIPTION = "extra_description"
    }
    private lateinit var detailContentFragmentBinding: FragmentDetailContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentFragmentBinding = activityDetailBinding.detailContent
        setContentView(activityDetailBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]
        val image = intent.getStringExtra(EXTRA_IMG)
        val title = intent.getStringExtra(EXTRA_TITLE)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val category = intent.getStringExtra(EXTRA_CATEGORY)

        detailContentFragmentBinding.apply {
            Glide.with(imgDetail)
                .load(image)
                .centerCrop()
                .into(imgDetail)
            tvTitleDetail.text = title
            tvCategoryDetail.text = category
            jtvDescriptionDetail.text = description
        }
    }
}