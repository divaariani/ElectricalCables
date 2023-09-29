package com.divaariani.electricalcables.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.divaariani.electricalcables.R
import com.divaariani.electricalcables.data.Cable
import com.divaariani.electricalcables.ui.favorite.FavoriteViewModel

class DetailCableActivity : AppCompatActivity() {
    private var isFavorite = false
    private lateinit var vmFavorite: FavoriteViewModel
    private var selectedCable: Cable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_cable)

        selectedCable = intent.getParcelableExtra("selected_cable")

        if (selectedCable != null) {
            val titleTextView = findViewById<TextView>(R.id.title_cable)
            val imageImageView = findViewById<ImageView>(R.id.image_cable)
            val benefitTextView = findViewById<TextView>(R.id.benefit_description)
            val specificationTextView = findViewById<TextView>(R.id.specification_description)
            val constructionTextView = findViewById<TextView>(R.id.construction_description)

            titleTextView.text = selectedCable?.name
            Glide.with(this)
                .load(selectedCable?.photoUrl)
                .into(imageImageView)
            benefitTextView.text = selectedCable?.application
            specificationTextView.text = selectedCable?.specification
            constructionTextView.text = selectedCable?.construction
        }

        vmFavorite = ViewModelProvider(this).get(FavoriteViewModel::class.java)
        val iconFavorite = findViewById<ImageView>(R.id.icon_favorite)
        updateFavoriteIcon()
        iconFavorite.setOnClickListener {
            isFavorite = !isFavorite
            updateFavoriteIcon()

            if (selectedCable != null) {
                if (isFavorite) {
                    vmFavorite.addFavoriteCable(selectedCable!!)
                } else {
                    vmFavorite.removeFavoriteCable(selectedCable!!)
                }
            }
        }
    }

    private fun updateFavoriteIcon() {
        val iconFavorite = findViewById<ImageView>(R.id.icon_favorite)
        if (isFavorite) {
            iconFavorite.setImageResource(R.drawable.icon_favorite)
        } else {
            iconFavorite.setImageResource(R.drawable.icon_unfavorite)
        }
    }
}