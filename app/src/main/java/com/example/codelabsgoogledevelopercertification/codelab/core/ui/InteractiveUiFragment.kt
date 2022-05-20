package com.example.codelabsgoogledevelopercertification.codelab.core.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.codelabsgoogledevelopercertification.R
import com.example.codelabsgoogledevelopercertification.databinding.FragmentInteractiveUiBinding

class InteractiveUiFragment : Fragment(R.layout.fragment_interactive_ui) {

    private lateinit var binding: FragmentInteractiveUiBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInteractiveUiBinding.bind(view)
        binding.showCount.text = count.toString()
        binding.buttonToast.setOnClickListener { showToast() }
        binding.buttonCount.setOnClickListener { countUp(); showCounter() }
    }

    private fun showToast() =
        Toast.makeText(requireContext(), R.string.toast_message, Toast.LENGTH_LONG).show()
    private fun countUp() = count++
    private fun showCounter() {
        binding.showCount.text = count.toString()
    }
}