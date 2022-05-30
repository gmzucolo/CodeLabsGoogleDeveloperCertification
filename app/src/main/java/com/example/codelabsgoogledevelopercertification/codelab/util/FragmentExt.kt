package com.example.codelabsgoogledevelopercertification.codelab.util

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Fragment.navTo(@IdRes dest: Int) = findNavController().navigate(dest)
fun Fragment.navTo(directions: NavDirections) = findNavController().navigate(directions)
fun Fragment.navTo(@IdRes dest: Int, args: Bundle) = findNavController().navigate(dest, args)
fun Fragment.toast(message: String) = Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()

fun Fragment.startActivity(clazz: Class<*>, name: String ="", args: Bundle = Bundle()) {
    val intent = Intent(requireContext(), clazz).apply {
        if(!name.isNullOrEmpty() && args.isEmpty) {
            putExtra(name, args)
        }
    }
    requireActivity().startActivity(intent)
}
