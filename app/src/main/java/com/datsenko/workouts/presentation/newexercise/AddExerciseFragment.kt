package com.datsenko.workouts.presentation.newexercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.datsenko.workouts.databinding.FragmentAddExerciseBinding
import com.datsenko.workouts.presentation.base.DaggerBottomSheetDialogFragment
import javax.inject.Inject


class AddExerciseFragment : DaggerBottomSheetDialogFragment() {

    @Inject lateinit var factory: ViewModelProvider.Factory

    private var _binding: FragmentAddExerciseBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AddExerciseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAddExerciseBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this.viewModelStore, factory)[AddExerciseViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.optionOne.setOnClickListener { viewModel.onOnePressed() }
        binding.optionTen.setOnClickListener { viewModel.onTenPressed() }
        binding.optionTwenty.setOnClickListener { viewModel.onTwentyPressed() }
        binding.exerciseSave.setOnClickListener { viewModel.onSaveClicked() }
        binding.switch1.setOnCheckedChangeListener { _, isChecked -> viewModel.onSwitchModeChanged(isChecked) }


        viewModel.repeats.observe(viewLifecycleOwner, Observer { binding.repeatsValue.text = it })
        viewModel.isAddingMode.observe(viewLifecycleOwner, Observer { binding.switch1.isChecked = it })
        viewModel.closeEvent.observe(viewLifecycleOwner, Observer { dismiss() })
    }
}