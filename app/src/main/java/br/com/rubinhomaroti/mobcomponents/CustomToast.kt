package  br.com.rubinhomaroti.mobcomponents

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

object CustomToast {
    private fun showToast(
        activity: Activity,
        backgroundToast: Drawable?,
        icon: Drawable?,
        message: String,
        duration: Int = Snackbar.LENGTH_SHORT
    ) {
        val inflater = LayoutInflater.from(activity)
        val toastLayout: View = inflater.inflate(R.layout.custom_toast, null)

        val snackBar = Snackbar.make(toastLayout, message, duration)
        snackBar.view.background = backgroundToast

        toastLayout.findViewById<TextView>(R.id.tvMessageToast).text = message
        val ivIconToast = toastLayout.findViewById<ImageView>(R.id.ivIconToast)
        if (icon == null) {
            ivIconToast.visibility = View.GONE
        } else {
            ivIconToast.visibility = View.VISIBLE
            ivIconToast.setImageDrawable(icon)
        }
        snackBar.show()
    }
    fun success(activity: Activity, message: String) {
        showToast(
            activity,
            ContextCompat.getDrawable(activity, R.drawable.toast_bg_success),
            ContextCompat.getDrawable(activity, R.drawable.ic_success),
            message
        )
    }
    fun warning(activity: Activity, message: String) {
        showToast(
            activity,
            ContextCompat.getDrawable(activity, R.drawable.toast_bg_warning),
            ContextCompat.getDrawable(activity, R.drawable.ic_warning),
            message
        )
    }
    fun error(activity: Activity, message: String) {
        showToast(
            activity,
            ContextCompat.getDrawable(activity, R.drawable.toast_bg_error),
            ContextCompat.getDrawable(activity, R.drawable.ic_error),
            message
        )
    }
    fun info(activity: Activity, message: String) {
        showToast(
            activity,
            ContextCompat.getDrawable(activity, R.drawable.toast_bg_info),
            ContextCompat.getDrawable(activity, R.drawable.ic_info),
            message
        )
    }
    fun default(activity: Activity, message: String) {
        showToast(
            activity,
            ContextCompat.getDrawable(activity, R.drawable.toast_bg_default),
            null,
            message
        )
    }
}