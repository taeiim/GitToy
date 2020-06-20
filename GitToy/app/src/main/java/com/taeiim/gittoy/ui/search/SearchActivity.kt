package com.taeiim.gittoy.ui.search

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.taeiim.gittoy.BR
import com.taeiim.gittoy.R
import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.base.BaseActivity
import com.taeiim.gittoy.databinding.ActivitySearchBinding
import com.taeiim.gittoy.databinding.ItemRepoBinding
import com.taeiim.gittoy.di.injectViewModel
import com.taeiim.gittoy.ui.RepoRecyclerAdapter
import com.taeiim.gittoy.ui.main.MainActivity
import javax.inject.Inject

class SearchActivity : BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {

    private lateinit var vm: SearchViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var repoAdapter: RepoRecyclerAdapter<GithubRepo, ItemRepoBinding>

    private val searchWord by lazy { intent?.getStringExtra(MainActivity.KEY_SEARCH_WORD) ?: "" }

    override fun initializeViewModel() {
        vm = injectViewModel(viewModelFactory)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()
    }

    private fun setup() {
        repoAdapter = RepoRecyclerAdapter(this, true, R.layout.item_repo, BR.repo)
        binding.repoRv.adapter = repoAdapter

        vm.setObserves()
        searchRepository()
    }

    private fun SearchViewModel.setObserves() {
        searchResultList.observe(this@SearchActivity, Observer { updateItems(it) })
        errorFailSearch.observe(this@SearchActivity, Observer { failToSearch() })
    }

    private fun searchRepository() {
        vm.searchRepo(searchWord)
    }

    private fun updateItems(resultList: List<GithubRepo>) {
        repoAdapter.updateItems(resultList)
    }

    private fun failToSearch() {
        Toast.makeText(this, getString(R.string.err_search), Toast.LENGTH_SHORT).show()
        finish()
    }

}