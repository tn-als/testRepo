package com.example.boardex.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.boardex.R
import com.example.boardex.databinding.ActivityMainBinding
import com.example.boardex.presentation.getuser.GetUserFragment
import com.example.boardex.presentation.getuser.ResultFragment
import com.example.boardex.presentation.getuser.ResultViewModel
import com.example.boardex.presentation.makeboard.MakeBoardFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), FragmentChangeListener {
    private lateinit var binding: ActivityMainBinding
    private val resultViewModel:ResultViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinds()
        clickButton()
        //setFragment()
    }

    private fun initBinds() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun clickButton() {
        makingBoard()
        getUser()
    }

    private fun makingBoard() {
        binding.btnMakeBoard.setOnClickListener {
            setFragment(MakeBoardFragment())
        }
    }

    private fun getUser() {
        binding.btnGetUser.setOnClickListener {
            setFragment(GetUserFragment())
        }
    }

    private fun setFragment(fragment: Fragment) {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_main)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fcv_main, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun changeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_main, ResultFragment())
            .addToBackStack(null)
            .commit()
    }
}