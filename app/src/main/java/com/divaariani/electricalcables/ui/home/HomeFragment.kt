package com.divaariani.electricalcables.ui.home

import CableAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.divaariani.electricalcables.data.CableData
import com.divaariani.electricalcables.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CableAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val listCable: RecyclerView = binding.rvCable
        listCable.layoutManager = LinearLayoutManager(context)
        adapter = CableAdapter(CableData.cable) { selectedCable ->
            val intent = Intent(context, DetailCableActivity::class.java)
            intent.putExtra("selected_cable", selectedCable)
            startActivity(intent)
        }
        listCable.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}