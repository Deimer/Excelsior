package test.deymer.excelsior.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import test.deymer.excelsior.databinding.ItemAlbumBinding
import test.deymer.repository.models.SongModel

class AlbumAdapter(
    private val albumList: List<SongModel>
): RecyclerView.Adapter<AlbumAdapter.ViewHolderAlbum>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumAdapter.ViewHolderAlbum {
        val layout = LayoutInflater.from(parent.context)
        val itemBinding = ItemAlbumBinding.inflate(layout, parent, false)
        return ViewHolderAlbum(itemBinding)
    }

    override fun onBindViewHolder(holder: AlbumAdapter.ViewHolderAlbum, position: Int) {
        holder.binding(albumList[position])
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    inner class ViewHolderAlbum(
        private val albumBinding: ItemAlbumBinding
    ) : RecyclerView.ViewHolder(albumBinding.root) {

        fun binding(song: SongModel) {
            with(albumBinding) {
                textViewNameSong.text = song.trackName
                textViewPriceSong.text = song.trackPrice
            }
        }
    }
}