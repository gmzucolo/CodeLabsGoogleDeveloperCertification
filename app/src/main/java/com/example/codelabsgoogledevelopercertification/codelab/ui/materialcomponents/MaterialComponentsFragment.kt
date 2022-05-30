package com.example.codelabsgoogledevelopercertification.codelab.ui.materialcomponents

import android.os.Bundle

import android.view.View
import androidx.fragment.app.Fragment
import com.example.codelabsgoogledevelopercertification.R
import com.example.codelabsgoogledevelopercertification.codelab.util.navTo
import com.example.codelabsgoogledevelopercertification.databinding.FragmentMaterialComponentsBinding
class MaterialComponentsFragment : Fragment(R.layout.fragment_material_components) {

    private lateinit var binding: FragmentMaterialComponentsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMaterialComponentsBinding.bind(view) // inicializa o binding

        binding.nextButton.setOnClickListener {
            if (!isPasswordValid(binding.passwordEditText.text.toString())) {
                binding.passwordTextInput.error = getString(R.string.shr_error_password)
            } else {
                binding.passwordTextInput.error = null
                navTo(R.id.productGridFragment)
            }
        }

        // Clear the error once more than 8 characters are typed.
        binding.passwordEditText.setOnKeyListener { _, _, _ ->
            if (isPasswordValid(binding.passwordEditText.text.toString())) {
                binding.passwordTextInput.error = null
            }
            false
        }

        binding.cancelButton.setOnClickListener {
            binding.passwordEditText.setText("")
            binding.username.setText("")
        }

    }
    private fun isPasswordValid(text: String): Boolean = text.length >= 8
}