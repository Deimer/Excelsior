package test.deymer.excelsior.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import dagger.hilt.android.AndroidEntryPoint
import test.deymer.excelsior.databinding.FragmentSearchBinding
import test.deymer.excelsior.ui.adapter.SongAdapter
import test.deymer.excelsior.utils.disappear
import test.deymer.excelsior.utils.hideKeyboard
import test.deymer.excelsior.utils.show
import test.deymer.repository.models.SongModel

@AndroidEntryPoint
class SearchFragment: Fragment() {

    private val viewModel by activityViewModels<SearchViewModel>()
    private val binding: FragmentSearchBinding by lazy {
        FragmentSearchBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        initSubscriptionSearch()
        setupSearchView()
    }

    private fun initSubscriptionSearch() {
        viewModel.postSearchResults().observe(viewLifecycleOwner) { results ->
            binding.searchViewSongs.hideKeyboard()
            setupRecycler(results)
        }
    }

    private fun setupSearchView() {
        binding.searchViewSongs.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { launchSearchKeyword(query.trim()) }
                return true
            }
            override fun onQueryTextChange(query: String?): Boolean {
                return false
            }
        })
    }

    private fun setupRecycler(results: List<SongModel>) {
        with(binding) {
            groupResults.show()
            recyclerviewSongs.apply {
                layoutManager = LinearLayoutManager(context, VERTICAL, false)
                adapter = SongAdapter(results, ::openSongDetails)
            }
            postponeEnterTransition()
            recyclerviewSongs.doOnPreDraw {
                startPostponedEnterTransition()
            }
            recyclerviewSongs.scrollState
        }
    }

    private fun openSongDetails(songId: Int, viewOne: View) {
        val extras = FragmentNavigatorExtras(
            viewOne to songId.toString()
        )
        val action = SearchFragmentDirections.actionSearchFragmentToDetailFragment(songId)
        findNavController().navigate(action, extras)
    }

    private fun launchSearchKeyword(query: String) {
        with(binding) {
            groupResults.disappear()
            viewModel.launchSearchSong(query)
        }
    }
}