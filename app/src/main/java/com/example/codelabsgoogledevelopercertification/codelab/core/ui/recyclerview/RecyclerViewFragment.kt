package com.example.codelabsgoogledevelopercertification.codelab.core.ui.recyclerview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.codelabsgoogledevelopercertification.R
import com.example.codelabsgoogledevelopercertification.codelab.util.startAnimation
import com.example.codelabsgoogledevelopercertification.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : Fragment(R.layout.fragment_recycler_view) {

    private lateinit var binding: FragmentRecyclerViewBinding

    // 0 Defina seu modelo
    private var words = mutableListOf("Ricardo", "Julia", "Pedro", "Alfred")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecyclerViewBinding.bind(view)

        // +-----------------------------------------------------------------+
        // | Cool explosion animation                                        |
        // +-----------------------------------------------------------------+
        val anim =
            AnimationUtils.loadAnimation(requireContext(), R.anim.circle_explosion_anim).apply {
                duration = 700
                interpolator = AccelerateDecelerateInterpolator()
            }

        binding = FragmentRecyclerViewBinding.bind(view)
        // 3 atribua o adapter ao seu recyclerView
        binding.wordRecycler.adapter = WordListAdapter(requireActivity(), words)
        binding.addWordButton.setOnClickListener {
            binding.root.setBackgroundColor(0) // make sure this is set to re-trigger the anim again
            words.add("+ New word " + words.size)
            (binding.wordRecycler.adapter as WordListAdapter).notifyItemChanged(words.size)
            binding.wordRecycler.smoothScrollToPosition(words.size)
            // +-----------------------------------------------------------------+
            // | Cool explosion animation                                        |
            // +-----------------------------------------------------------------+
            binding.animCircle.isVisible = true
            binding.animCircle.startAnimation(anim) {
                // onEnd call back - do what ever you want here...
                // example: change the background color
                binding.root.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            }
        }
    }

    // 1 Crie seu viewAdapter
    class WordListAdapter(context: Context, val words: MutableList<String>) :
        RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

        private val inflater: LayoutInflater = LayoutInflater.from(context)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
            val item = inflater.inflate(R.layout.wordlist_item, parent, false)
            return WordViewHolder(item, this)
        }

        // Aqui é onde acontece a "adaptação" do modelo para o layout .xml
        override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
            holder.wordItemView.text = words[position]
        }

        override fun getItemCount(): Int {
            return words.size
        }

        //        // 2 Defina um viewHolder e implemente o onclick de cada item
        inner class WordViewHolder(item: View, private val adapter: WordListAdapter) :
            RecyclerView.ViewHolder(item), View.OnClickListener {

            val wordItemView: TextView = item.findViewById(R.id.word)

            init {
                wordItemView.setOnClickListener(this)
            }

            override fun onClick(view: View?) {
                words[layoutPosition] = "Clicked! " + words[layoutPosition]
                adapter.notifyDataSetChanged()
            }
        }
    }
}