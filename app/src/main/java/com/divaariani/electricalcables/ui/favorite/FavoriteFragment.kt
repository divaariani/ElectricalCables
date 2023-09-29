package com.divaariani.electricalcables.ui.favorite

import java.util.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.divaariani.electricalcables.data.Cable
import com.divaariani.electricalcables.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: FavoriteAdapter
    private lateinit var cableFavoriteList: List<FavoriteCable>
    private val onItemClick: (Cable) -> Unit = { cable ->
        // Implementasi aksi saat item di-klik di sini
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val root = binding.root

        cableFavoriteList = generateFakeCableData()
        adapter = FavoriteAdapter(cableFavoriteList, onItemClick)

        val recyclerView = binding.rvFavorite
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        return root
    }

    private fun generateFakeCableData(): List<FavoriteCable> {
        val fakeCableList = mutableListOf<FavoriteCable>()
        fakeCableList.add(FavoriteCable(1, "Square Copper Busbar", "https://sutrakabel.com/wp-content/uploads/2019/12/product-square-copper-busbar.png"))
        fakeCableList.add(FavoriteCable(2, "Bare Copper Wire", "https://sutrakabel.com/wp-content/uploads/2021/11/product-bare-copper-conductor-bc-0.5h.png"))

        return fakeCableList
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}