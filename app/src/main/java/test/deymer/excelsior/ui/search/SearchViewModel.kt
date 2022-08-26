package test.deymer.excelsior.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import test.deymer.repository.models.SongModel
import test.deymer.repository.utils.OnResult
import test.deymer.usecase.song.SearchSongUseCase
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchSongUseCase: SearchSongUseCase
): ViewModel() {

    private var offset = 1

    private val songListLiveData: MutableLiveData<List<SongModel>> = MutableLiveData()
    fun postSearchResults(): LiveData<List<SongModel>> = songListLiveData

    private val errorLiveData: MutableLiveData<String> = MutableLiveData()
    fun postShowError(): LiveData<String> = errorLiveData

    fun launchSearchSong(term: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                when(val results = searchSongUseCase.invoke(term, offset)) {
                    is OnResult.Success -> {
                        offset = offset.plus(1)
                        songListLiveData.postValue(results.data)
                    }
                    is OnResult.Error -> {
                        errorLiveData.postValue(results.exception.toString())
                    }
                }
            }
        }
    }
}