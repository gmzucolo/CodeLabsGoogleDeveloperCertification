package com.example.codelabsgoogledevelopercertification.codelab.core.toast

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.codelabsgoogledevelopercertification.R
import com.example.codelabsgoogledevelopercertification.databinding.FragmentToastSnakeBinding
import com.example.codelabsgoogledevelopercertification.codelab.util.toast
import com.google.android.material.snackbar.Snackbar


class ToastSnakeFragment : Fragment(R.layout.fragment_toast_snake) {

    private lateinit var binding: FragmentToastSnakeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        binding = FragmentToastSnakeBinding.bind(view)

        binding.toast.setOnClickListener {
            val message = "My message for you"
            Toast
                .makeText(requireContext(), message, Toast.LENGTH_LONG)
                .show()
        }
        binding.snake.setOnClickListener {
            Snackbar
                .make(view, "Hello SnackBar", Snackbar.LENGTH_LONG)
                .show()
        }
        binding.snakeAction.setOnClickListener {
            Snackbar
                .make(view, "Hello SnackBarAction", Snackbar.LENGTH_LONG)
                .setAction("click") { toast("I am a snake!") }
                .show()
        }

    }
}