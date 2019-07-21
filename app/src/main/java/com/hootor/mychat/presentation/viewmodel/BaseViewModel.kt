package com.hootor.mychat.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hootor.mychat.domain.type.HandleOnce
import com.hootor.mychat.domain.type.exception.Failure

abstract class BaseViewModel: ViewModel() {
    var failureData: MutableLiveData<HandleOnce<Failure>> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failureData.value = HandleOnce(failure)
    }
}