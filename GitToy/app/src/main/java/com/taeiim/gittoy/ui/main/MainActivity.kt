package com.taeiim.gittoy.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.taeiim.gittoy.BR
import com.taeiim.gittoy.R
import com.taeiim.gittoy.api.model.GithubRepo
import com.taeiim.gittoy.base.BaseActivity
import com.taeiim.gittoy.common.EventObserver
import com.taeiim.gittoy.databinding.ActivityMainBinding
import com.taeiim.gittoy.databinding.ItemRepoBinding
import com.taeiim.gittoy.ext.start
import com.taeiim.gittoy.ui.RepoRecyclerAdapter
import com.taeiim.gittoy.ui.search.SearchActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val vm: MainViewModel by viewModel()
    private lateinit var repoAdapter: RepoRecyclerAdapter<GithubRepo, ItemRepoBinding>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()
    }

    private fun setup() {
        binding.vm = vm

        repoAdapter = RepoRecyclerAdapter(this, false, R.layout.item_repo, BR.repo)
        binding.historyRepoRv.adapter = repoAdapter

        vm.setObserves()
    }

    private fun MainViewModel.setObserves() {
        repoHistoryList.observe(this@MainActivity, Observer { updateItems(it) })
        startSearchActivityEvent.observe(this@MainActivity, EventObserver { goSearchActivity() })
        errorQueryBlank.observe(this@MainActivity, Observer { blankSearchQuery() })
    }

    private fun updateHistoryItems() {
        vm.getRepoHistory()
    }

    private fun updateItems(resultList: List<GithubRepo>) {
        repoAdapter.updateItems(resultList)
    }

    private fun blankSearchQuery() {
        Toast.makeText(this, getString(R.string.blank_search), Toast.LENGTH_SHORT).show()
    }

    private fun goSearchActivity() {
        start(SearchActivity::class) {
            putString(KEY_SEARCH_WORD, vm.query.value)
        }
        binding.searchEditTv.text.clear()
    }

    override fun onResume() {
        super.onResume()
        updateHistoryItems()
    }

    companion object {
        const val KEY_SEARCH_WORD = "searchWord"
    }

}
