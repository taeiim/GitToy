package com.taeiim.gittoy.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.api.model.GithubUser
import com.taeiim.gittoy.base.BaseViewModel
import com.taeiim.gittoy.data.GithubRepository
import io.reactivex.android.schedulers.AndroidSchedulers

class DetailViewModel(private val githubRepository: GithubRepository) : BaseViewModel() {

    private val _user = MutableLiveData<GithubUser>()
    val user: LiveData<GithubUser>
        get() = _user

    private val _repo = MutableLiveData<GithubRepo>()
    val repo: LiveData<GithubRepo>
        get() = _repo


    fun loadRepoData(userName: String, repoName: String) {
        githubRepository.getRepoInfo(userName, repoName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _repo.value = it
            }, {}).addDisposable()
    }

    fun loadUserData(userName: String) {
        githubRepository.getUserInfo(userName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _user.value = it
            }, {}).addDisposable()
    }

    fun saveRepoHistory() {
        repo.value?.let {
            githubRepository.saveClickRepo(it)
                .subscribe()
                .addDisposable()
        }
    }

}