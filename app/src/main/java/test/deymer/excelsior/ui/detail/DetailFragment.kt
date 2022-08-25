package test.deymer.excelsior.ui.detail

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import test.deymer.excelsior.R
import test.deymer.excelsior.databinding.FragmentDetailBinding
import test.deymer.excelsior.utils.loadImage
import test.deymer.excelsior.utils.setOnSingleClickListener
import test.deymer.repository.models.SongModel
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class DetailFragment: Fragment() {

    companion object {
        const val DURATION_ANIMATION = 250L
    }

    private val args by navArgs<DetailFragmentArgs>()
    private val viewModel by activityViewModels<DetailViewModel>()
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

    private fun setupView() {
        initClickListener()
        initSubscriptionSongDetail()
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
        binding.imageViewBack.setOnSingleClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initSubscriptionSongDetail() {
        val songId = args.songId
        viewModel.launchFetchSong(songId)
        viewModel.postGetSong().observe(viewLifecycleOwner) { songDetail ->
            setInformation(songDetail)
        }
    }

    private fun setInformation(songDetail: SongModel) {
        with(binding) {
            imageViewBackdrop.loadImage(songDetail.albumBackdrop, false)
            imageViewAvatar.loadImage(songDetail.albumAvatar)
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
}