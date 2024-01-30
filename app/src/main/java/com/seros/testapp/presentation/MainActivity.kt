package com.seros.testapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.seros.testapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("TAG", "activity created")

        vm.resultLive.observe(this) {
            binding.dataTextView.text = it
        }

        binding.sendBtn.setOnClickListener {
            val text = binding.dataEditText.text.toString()
            vm.save(text)
        }

        binding.receiveBtn.setOnClickListener {
            vm.load()
        }
    }
}