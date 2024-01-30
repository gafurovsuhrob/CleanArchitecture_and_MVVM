package com.seros.testapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.seros.testapp.domain.models.SaveUserNameParams
import com.seros.testapp.domain.models.UserName
import com.seros.testapp.domain.usecase.GetUserNameUseCase
import com.seros.testapp.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private var resultMutableLive = MutableLiveData<String>()
    var resultLive: LiveData<String> = resultMutableLive

    init {
        Log.d("TAG", "VM created")
    }

    override fun onCleared() {
        Log.d("TAG", "VM cleared")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParams(text)
        val resultData: Boolean = saveUserNameUseCase.execute(params)
        resultMutableLive.value = "Save result = $resultData"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        resultMutableLive.value = "${userName.firstName} ${userName.lastName}"
    }
}