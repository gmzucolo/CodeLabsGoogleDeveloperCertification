package com.example.codelabsgoogledevelopercertification.codelab

import android.os.Bundle
import android.view.View
import com.example.codelabsgoogledevelopercertification.R
import com.example.codelabsgoogledevelopercertification.databinding.FragmentMainBinding
import com.example.codelabsgoogledevelopercertification.codelab.util.navTo

class MainFragment : androidx.fragment.app.Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        binding.codelabToastSnake.setOnClickListener { navTo(R.id.toastSnakeFragment) }
        binding.codelabNotification.setOnClickListener { navTo(R.id.notificationFragment) }
        binding.codelabWorkManager.setOnClickListener { navTo(R.id.selectImageFragment) }
        binding.codelabMaterialComponents.setOnClickListener { navTo(R.id.materialComponentsFragment) }
    }
}