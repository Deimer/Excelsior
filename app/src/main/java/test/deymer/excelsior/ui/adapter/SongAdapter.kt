package test.deymer.excelsior.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import test.deymer.excelsior.databinding.ItemSongResultBinding
import test.deymer.excelsior.utils.loadImage
import test.deymer.repository.models.SongModel

class SongAdapter(
    private val songList: List<SongModel>,
    private val clickCallback: (songId: Int) -> Unit
): RecyclerView.Adapter<SongAdapter.ViewHolderSong>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSong {
        val layout = LayoutInflater.from(parent.context)
        val itemBinding = ItemSongResultBinding.inflate(layout, parent, false)
        return ViewHolderSong(itemBinding, clickCallback)
    }

    override fun onBindViewHolder(holder: ViewHolderSong, position: Int) {
        holder.binding(songList[position])
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    inner class ViewHolderSong(
        private val songBinding: ItemSongResultBinding,
        private val clickCallback: (songId: Int) -> Unit
    ) : RecyclerView.ViewHolder(songBinding.root) {

        fun binding(song: SongModel) {
            with(songBinding) {
                textViewNameSong.text = song.trackName
                textViewNameAlbum.text = song.albumName
                textViewNameArtist.text = song.artistName
                imageViewAvatar.loadImage(song.albumBackdrop)
                root.setOnClickListener {
                    clickCallback.invoke(song.trackId)
                }
            }
        }
    }
}