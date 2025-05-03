package com.example.redscate

import android.app.Activity
import android.content.Intent
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity.LAYOUT_INFLATER_SERVICE
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity

class Autoproteccion(private val activity: Activity) {

    private val inflater = activity.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val popupView = inflater.inflate(R.layout.activity_template_autoproteccion, null)
    private val blurBackground = activity.findViewById<View>(R.id.blur_background_autoproteccion)

    private val buttonSi = popupView.findViewById<TextView>(R.id.button_si)
    private val buttonNo = popupView.findViewById<TextView>(R.id.button_no)


    private var botonSecundario = 1

    fun showPopupWindowAutoproteccion(view: View) {
        botonSecundario = 1
        blurBackground.visibility = View.VISIBLE  // activa el backgraund
        val popupWindow = PopupWindow(
            popupView,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        ).apply {
            isOutsideTouchable = true
            isFocusable = true
            setOnDismissListener { blurBackground.visibility = View.GONE } // si le da click por fuera se cierra
        }
            buttonNo.setOnClickListener {
                popupWindow.dismiss()

            }
        buttonSi.setOnClickListener {
            val intent = Intent(activity, Template_cards_autoproteccion::class.java)
            activity.startActivity(intent)
                popupWindow.dismiss()
        }


        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
    }


}