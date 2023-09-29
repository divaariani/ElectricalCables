package com.divaariani.electricalcables.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.divaariani.electricalcables.data.Cable
import com.divaariani.electricalcables.databinding.ActivityDetailCableBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailCableActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var binding: ActivityDetailCableBinding
    private lateinit var viewModel: DetailCableViewModel
    private var selectedCable: Cable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra(EXTRA_ID, 0)
        val bundle = Bundle()

        viewModel = ViewModelProvider(this).get(DetailCableViewModel::class.java)
        selectedCable = intent.getParcelableExtra(EXTRA_ID)

        if (selectedCable != null) {
            val titleTextView = binding.titleCable
            val imageImageView = binding.imageCable
            val benefitTextView = binding.benefitDescription
            val specificationTextView = binding.specificationDescription
            val constructionTextView = binding.constructionDescription

            titleTextView.text = selectedCable?.name
            Glide.with(this)
                .load(selectedCable?.photoUrl)
                .into(imageImageView)
            benefitTextView.text = selectedCable?.application
            specificationTextView.text = selectedCable?.specification
            constructionTextView.text = selectedCable?.construction
        }

        var _isChecked = false
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main){
            }
        }

        binding.toggleFavorite.setOnClickListener {
            val currentCable = selectedCable

            _isChecked = !_isChecked
            if (_isChecked && currentCable != null) {
                // LOGIC HERE
            } else {
                // LOGIC HERE
            }
            binding.toggleFavorite.isChecked = _isChecked
        }
    }
}