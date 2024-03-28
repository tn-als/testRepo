package com.example.boardex.presentation.getuser

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.boardex.databinding.FragmentGetuserBinding
import com.example.boardex.extension.UiState
import com.example.boardex.presentation.FragmentChangeListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

class GetUserFragment : Fragment() {
    private var _binding: FragmentGetuserBinding? = null
    private val binding: FragmentGetuserBinding
        get() = requireNotNull(_binding) { "바인딩 객체 생성 안됨" }

    //private val authViewModel: AuthViewModel by viewModels()
    private val resultViewModel: ResultViewModel by activityViewModels()
    private val getUserViewModel: GetUserViewModel by viewModels()
    private lateinit var fragmentChangeListener: FragmentChangeListener
    //private val viewModel: MainViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentChangeListener) {
            fragmentChangeListener = context
        } else {
            throw RuntimeException("$context must implement FragmentChangeListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGetuserBinding.inflate(inflater, container, false)
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
            val id = binding.etId.text.toString().toInt()
            val activityRef = activity
            getUserViewModel.getUser(id)
            lifecycleScope.launch {
                getUserViewModel.getState.collect { uiState ->
                    when (uiState) {
                        is UiState.Success -> {
                            resultViewModel.setName(uiState.user.name)
                            Toast.makeText(activity, "정보 가져오기 성공", Toast.LENGTH_SHORT).show()
                            fragmentChangeListener.changeFragment()
                        }

                        is UiState.Error -> {
                            Toast.makeText(activity, "정보 가져오기 실패", Toast.LENGTH_SHORT).show()
                            fragmentChangeListener.changeFragment()
                        }

                        is UiState.Loading -> {
                            Toast.makeText(activity, "로딩중", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}