package com.example.codelabsgoogledevelopercertification.util

import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navTo(@IdRes dest: Int) = findNavController().navigate(dest)
fun Fragment.toast(message: String) = Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
