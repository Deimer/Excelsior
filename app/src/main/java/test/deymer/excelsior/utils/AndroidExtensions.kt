package test.deymer.excelsior.utils

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import coil.load
import com.google.android.material.snackbar.Snackbar
import test.deymer.excelsior.R
import java.util.concurrent.atomic.AtomicBoolean

fun AppCompatImageView.loadImage(url: String, crossFade: Boolean = true) {
    this.load(url) {
        crossfade(crossFade)
        placeholder(R.mipmap.ic_launcher)
        error(R.mipmap.ic_launcher)
    }
}

fun View.buildSnackBar(message: String) {
    val snack = Snackbar.make(this, message, 5000)
    val snackView = snack.view
    snackView.setBackgroundColor(Color.BLACK)
    snackView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).maxLines = 5
    snack.show()
}

fun View.setOnSingleClickListener(clickListener: ((View) -> Unit)?) {
    clickListener?.also {
        setOnClickListener(
            OnSingleClickListener(
                it
            )
        )
    } ?: setOnClickListener(null)
}

class OnSingleClickListener(
    private val clickListener: (View) -> Unit,
    private val intervalMs: Long = 1000
) : View.OnClickListener {

    private var canClick = AtomicBoolean(true)

    override fun onClick(v: View?) {
        if (canClick.getAndSet(false)) {
            v?.run {
                postDelayed({
                    canClick.set(true)
                }, intervalMs)
                clickListener.invoke(v)
            }
        }
    }
}