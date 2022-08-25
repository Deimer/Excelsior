package test.deymer.excelsior.ui.detail

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import dagger.hilt.android.AndroidEntryPoint
import test.deymer.excelsior.R
import test.deymer.excelsior.databinding.FragmentDetailBinding
import test.deymer.excelsior.ui.adapter.AlbumAdapter
import test.deymer.excelsior.utils.*
import test.deymer.repository.models.SongModel
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class DetailFragment: Fragment() {

    companion object {
        private const val DURATION_ANIMATION = 250L
    }

    private val args by navArgs<DetailFragmentArgs>()
    private val viewModel by activityViewModels<DetailViewModel>()
    private var mediaPlayer: MediaPlayer? = null
    private val binding: FragmentDetailBinding by lazy {
        FragmentDetailBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setupAnimation()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
    }

    private fun setupView() {
        initClickListener()
        initSubscriptionSongDetail()
        initSubscriptionSongsAlbum()
    }

    private fun setupAnimation() {
        val animation = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
        postponeEnterTransition(DURATION_ANIMATION, TimeUnit.MILLISECONDS)
        binding.imageViewBackdrop.transitionName = args.songId.toString()
    }

    private fun initClickListener() {
        with(binding) {
            imageViewBack.setOnSingleClickListener {
                findNavController().popBackStack()
            }
            cardViewSong.setOnSingleClickListener {
                playPreview()
            }
        }
    }

    private fun initSubscriptionSongDetail() {
        val songId = args.songId
        viewModel.launchFetchSong(songId)
        viewModel.postGetSong().observe(viewLifecycleOwner) { songDetail ->
            setInformation(songDetail)
        }
    }

    private fun initSubscriptionSongsAlbum() {
        viewModel.postGetSongs().observe(viewLifecycleOwner) { songList ->
            setupRecyclerSongsAlbum(songList)
        }
    }

    private fun setInformation(songDetail: SongModel) {
        with(binding) {
            setupMediaPlayer(songDetail.preview)
            imageViewBackdrop.loadImage(songDetail.albumBackdrop, false)
            imageViewAvatar.loadImage(songDetail.albumAvatar)
            setSongDetails(songDetail)
            viewModel.launchGetSongsAlbum(songDetail.trackId, songDetail.albumId)
        }
    }

    private fun setSongDetails(songDetail: SongModel) {
        with(binding) {
            textViewNameSong.text = songDetail.trackName
            textViewGenre.text = songDetail.genreName
            textViewCountry.text = songDetail.country
            textViewCurrency.text = songDetail.trackPrice
            textViewAlbumName.text = getString(R.string.album_name, songDetail.albumName)
            textViewArtistName.text = getString(R.string.album_artist, songDetail.artistName)
            textViewReleaseDate.text = getString(R.string.album_release, songDetail.releaseDate)
            textViewAlbumPrice.text = getString(R.string.album_price, songDetail.albumPrice)
        }
    }

    private fun setupMediaPlayer(urlPreview: String) {
        try {
            mediaPlayer = MediaPlayer().apply {
                setAudioAttributes(
                    AudioAttributes.Builder().setContentType(
                        AudioAttributes.CONTENT_TYPE_MUSIC
                    ).build()
                )
                setDataSource(urlPreview)
                prepare()
            }
            mediaPlayer?.setOnCompletionListener {
                binding.lottiePlaying.hide()
                binding.lottiePlay.show()
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }

    private fun playPreview() {
        with(binding) {
            if(mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
                lottiePlaying.hide()
                lottiePlay.show()
            } else {
                mediaPlayer?.start()
                lottiePlaying.show()
                lottiePlay.disappear()
            }
        }
    }

    private fun setupRecyclerSongsAlbum(songs: List<SongModel>) {
        binding.recyclerviewAlbum.apply {
            layoutManager = LinearLayoutManager(context, HORIZONTAL, false)
            adapter = AlbumAdapter(songs)
        }
    }
}