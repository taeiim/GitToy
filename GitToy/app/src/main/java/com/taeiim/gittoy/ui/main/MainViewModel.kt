package com.taeiim.gittoy.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.base.BaseViewModel
import com.taeiim.gittoy.common.Event
import com.taeiim.gittoy.data.GithubRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MainViewModel @Inject
constructor(private val githubRepository: GithubRepository) : BaseViewModel() {

    private val _repoHistoryList = MutableLiveData<List<GithubRepo>>()
    val repoHistoryList: LiveData<List<GithubRepo>>
        get() = _repoHistoryList

    private val _startSearchActivityEvent = MutableLiveData<Event<Unit>>()
    val startSearchActivityEvent: LiveData<Event<Unit>>
        get() = _startSearchActivityEvent

    private val _errorQueryBlank = MutableLiveData<Throwable>()
    val errorQueryBlank: LiveData<Throwable>
        get() = _errorQueryBlank

    val query = MutableLiveData<String>()

    fun startSearchActivityEvent() {
        if (query.value.isNullOrBlank()) _errorQueryBlank.value = Throwable()
        else _startSearchActivityEvent.value = Event(Unit)
    }

    fun getRepoHistory() {
        githubRepository.getRepoHistoryList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _repoHistoryList.value = it
            }, {}).addDisposable()
    }

}