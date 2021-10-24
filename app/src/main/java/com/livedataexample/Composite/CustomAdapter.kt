package com.livedataexample.Composite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.livedataexample.Animal
import com.livedataexample.databinding.ListAnimalBinding

class CustomAdapter(var animals: ArrayList<Animal>) : RecyclerView.Adapter<CustomAdapter.AnimalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : AnimalViewHolder
    {
        return AnimalViewHolder(
            ListAnimalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal: Animal = animals[position]
        holder.bind(animal)
    }

    override fun getItemCount() = animals.size

    class AnimalViewHolder(binding: ListAnimalBinding) : RecyclerView.ViewHolder(binding.root) {

        private val name = binding.textViewName
        private val type = binding.textViewType
        private val age = binding.textViewAge


        fun bind(animal: Animal) {
            name.text =  animal.name
            type.text =  animal.type
            age.text =  animal.age.toString()

        }
    }
}