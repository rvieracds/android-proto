package com.roviera.vitalsigngenerallayoutkotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val textView = view.findViewById<TextView>(R.id.txtMain)
        textView.setText(R.string.first_fragment)

        val imageView = view.findViewById<ImageView>(R.id.imgMain)
        imageView.setImageResource(R.mipmap.ic_launcher)

        return view
    }
}
