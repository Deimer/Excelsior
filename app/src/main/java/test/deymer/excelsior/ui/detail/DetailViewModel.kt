package test.deymer.excelsior.ui.detail

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
import test.deymer.usecase.album.GetSongsAlbumUseCase
import test.deymer.usecase.song.GetSongByIdUseCase
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getSongUseCase: GetSongByIdUseCase,
    private val getSongsAlbumUseCase: GetSongsAlbumUseCase
): ViewModel() {

    private val songLiveData: MutableLiveData<SongModel> = MutableLiveData()
    fun postGetSong(): LiveData<SongModel> = songLiveData

    private val songsLiveData: MutableLiveData<List<SongModel>> = MutableLiveData()
    fun postGetSongs(): LiveData<List<SongModel>> = songsLiveData

    private val errorLiveData: MutableLiveData<String> = MutableLiveData()
    fun postShowError(): LiveData<String> = errorLiveData

    fun launchFetchSong(songId: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                when(val results = getSongUseCase.invoke(songId)) {
                    is OnResult.Success -> {
                        songLiveData.postValue(results.data)
                    }
                    is OnResult.Error -> {
                        errorLiveData.postValue(results.exception.toString())
                    }
                }
            }
        }
    }

    fun launchGetSongsAlbum(songId: Int, albumId: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                when(val results = getSongsAlbumUseCase.invoke(albumId)) {
                    is OnResult.Success -> {
                        songsLiveData.postValue(results.data.filter { it.trackId != songId })
                    }
                    is OnResult.Error -> {
                        errorLiveData.postValue(results.exception.toString())
                    }
                }
            }
        }
    }
}