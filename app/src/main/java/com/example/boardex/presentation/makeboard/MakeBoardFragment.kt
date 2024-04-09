package com.example.boardex.presentation.makeboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.boardex.databinding.FragmentMakeboardBinding
import com.example.boardex.extension.MainState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MakeBoardFragment : Fragment() {
    private var _binding: FragmentMakeboardBinding? = null
    private val binding: FragmentMakeboardBinding
        get() = requireNotNull(_binding) { "바인딩 객체 생성 안됨" }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMakeboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun submit() {
        binding.btnSubmit.setOnClickListener {
            val writerId=binding.etId.text.toString().toInt()
            val title = binding.etTitle.text.toString()
            val content = binding.etContent.text.toString()
            viewModel.submitData(title, content, writerId)

            lifecycleScope.launch {
                viewModel.mainState.collect { mainState ->
                    when (mainState) {
                        is MainState.Success -> {
                            Toast.makeText(activity, "게시물 올리기 성공", Toast.LENGTH_SHORT).show()
                        }

                        is MainState.Error -> {
                            Toast.makeText(activity, "게시물 올리기 실패", Toast.LENGTH_SHORT).show()
                        }

                        is MainState.Loading -> {
                            Toast.makeText(activity, "로딩중", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}