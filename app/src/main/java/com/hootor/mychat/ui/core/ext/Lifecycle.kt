package com.hootor.mychat.ui.core.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.hootor.mychat.domain.type.HandleOnce
import com.hootor.mychat.domain.type.Failure

fun <T : Any, L : LiveData<T>> LifecycleOwner.onSuccess(liveData: L, body: (T?) -> Unit) =
    liveData.observe(this, Observer(body))

fun <L : LiveData<HandleOnce<Failure>>> LifecycleOwner.onFailure(liveData: L, body: (Failure?) -> Unit) =
    liveData.observe(this, Observer {
        it.getContentIfNotHandled()?.let(body)
    })