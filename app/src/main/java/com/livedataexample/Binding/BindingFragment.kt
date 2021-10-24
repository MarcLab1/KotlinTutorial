package com.livedataexample.Binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.livedataexample.Animal
import com.livedataexample.AnimalRepo
import com.livedataexample.Composite.CustomAdapter
import com.livedataexample.databinding.FragmentBindingBinding

class BindingFragment : Fragment(){

    private var _binding: FragmentBindingBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: CustomAdapter
    private lateinit var recyclerview: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBindingBinding.inflate(inflater, container, false)
        val view = binding.root

        var repo = AnimalRepo()
        var animals = repo.animals

        recyclerview = binding.recyclerview
        recyclerview.layoutManager = LinearLayoutManager(context)
        adapter = CustomAdapter(animals as ArrayList<Animal>)
        recyclerview.adapter = adapter
        adapter.notifyDataSetChanged()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}