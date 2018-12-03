package com.roviera.vitalsigngenerallayoutkotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import android.widget.EditText

class FirstFragment : Fragment() {

    lateinit var hrInput: EditText;
    lateinit var rrInput: EditText;
    lateinit var sbpInput: EditText;
    lateinit var dbpInput: EditText;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)
        //val textView = view.findViewById<TextView>(R.id.txtMain)
        //textView.setText(R.string.first_fragment)

        //val imageView = view.findViewById<ImageView>(R.id.imgMain)
        //imageView.setImageResource(R.mipmap.ic_launcher)


        // GET HR RR SBP DBP INPUTS INSTANCES
        hrInput = view.findViewById(R.id.hrInput) as EditText
        rrInput = view.findViewById(R.id.rrInput) as EditText
        sbpInput = view.findViewById(R.id.sbpInput) as EditText
        dbpInput = view.findViewById(R.id.dbpInput) as EditText

        hrInput.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val strValue = hrInput.text.toString()
                if (strValue != "") {
                }
                return@OnKeyListener true
            }
            false
        })

        rrInput.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val strValue = rrInput.text.toString()
                if (strValue != "") {
                }
                return@OnKeyListener true
            }
            false
        })

        sbpInput.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val strValue = sbpInput.text.toString()
                if (strValue != "") {
                }
                return@OnKeyListener true
            }
            false
        })

        dbpInput.setOnKeyListener(View.OnKeyListener { view, keyCode, keyevent ->
            if (keyevent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val strValue = dbpInput.text.toString()
                if (strValue != "") {
                }
                return@OnKeyListener true
            }
            false
        })










        return view
    }
}
