package com.taeiim.gittoy.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.base.BaseViewModel
import com.taeiim.gittoy.data.GithubRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class SearchViewModel @Inject
constructor(private val githubRepository: GithubRepository) : BaseViewModel() {

    private val _searchResultList = MutableLiveData<List<GithubRepo>>()
    val searchResultList: LiveData<List<GithubRepo>>
        get() = _searchResultList

    private val _errorFailSearch = MutableLiveData<Throwable>()
    val errorFailSearch: LiveData<Throwable>
        get() = _errorFailSearch

    fun searchRepo(query: String) {
        githubRepository.searchRepository(query)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _searchResultList.value = it
            }, {
                _errorFailSearch.value = Throwable()
            }).addDisposable()
    }

}