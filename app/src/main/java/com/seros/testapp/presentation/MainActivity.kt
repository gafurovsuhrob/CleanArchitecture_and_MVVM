package com.seros.testapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.seros.testapp.app.AppDagger
import com.seros.testapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var vmFactory: MainViewModelFactory
//    private lateinit var vm: MainViewModel
    private lateinit var binding: ActivityMainBinding

        private val vm: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        (applicationContext as AppDagger).appComponent.inject(this)

        Log.d("TAG", "activity created")

//        vm = ViewModelProvider(this, vmFactory)[MainViewModel::class.java]

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