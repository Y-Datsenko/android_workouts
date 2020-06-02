package com.datsenko.workouts.presentation.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.datsenko.workouts.databinding.FragmentResultBinding
import com.datsenko.workouts.presentation.results.epoxy.emptyList
import com.datsenko.workouts.presentation.results.epoxy.exerciseItem
import com.datsenko.workouts.presentation.results.model.ExerciseModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ResultFragment : DaggerFragment() {

    @Inject lateinit var factory: ViewModelProvider.Factory

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myViewModel = ViewModelProvider(this.viewModelStore, factory)[ResultViewModel::class.java]

        myViewModel.workouts.observe(viewLifecycleOwner, Observer(this::show))
        binding.resultsFab.setOnClickListener {
            it.findNavController().navigate(ResultFragmentDirections.actionResultFragmentToAddExerciseFragment())
        }
    }

    private fun show(entities: List<ExerciseModel>) {
        binding.resultsRv.withModels {
            if (entities.isEmpty()) {
                emptyList {
                    id("empty-list")
                }
            } else {
                entities.forEach { item ->
                    exerciseItem {
                        id(item.hashCode())
                        model(item)
                    }
                }
            }
        }
    }

}