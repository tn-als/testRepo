package com.example.boardex.presentation.getuser

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.boardex.databinding.FragmentResultBinding
import com.example.boardex.presentation.MainActivity

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding: FragmentResultBinding
        get() = requireNotNull(_binding) { "바인딩 객체 생성 안됨" }
    private val resultViewModel: ResultViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getName()
        clickHomeButton()

    }

    private fun getName() {
        resultViewModel.name.observe(viewLifecycleOwner) { name ->
            binding.tvName.text = name
        }
    }

    private fun clickHomeButton() {
        binding.btnHome.setOnClickListener {
            Toast.makeText(context, "Home", Toast.LENGTH_SHORT).show()
            requireActivity().supportFragmentManager.popBackStack(
                null,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}