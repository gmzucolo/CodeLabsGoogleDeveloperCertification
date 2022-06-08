package com.example.codelabsgoogledevelopercertification.codelab.ui.activityintents

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.codelabsgoogledevelopercertification.R
import com.example.codelabsgoogledevelopercertification.codelab.util.navTo
import com.example.codelabsgoogledevelopercertification.databinding.FragmentReplyBinding

class ReplyFragment : Fragment(R.layout.fragment_reply) {
    companion object {
        const val SEND = "SEND"
    }

    private lateinit var binding: FragmentReplyBinding
    private var sent: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReplyBinding.bind(view)

        binding.buttonReply.setOnClickListener {
            val args = Bundle()
            args.putString(SendFragment.REPLY, binding.inputReply.text.toString())
            navTo(R.id.action_replyFragment_to_sendFragment, args)

            //startActivity(UserNavigationActivity::class.java)
        }

        // obtem a mensagem enviada pelo fragment
        arguments?.let {
            sent = it.getString(SEND, null)
        }

        // exibe a mensagem obtida
        sent?.let {
            binding.textMessage.text = it
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }
}