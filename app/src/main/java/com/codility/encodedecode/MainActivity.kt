package com.codility.encodedecode

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Base64
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.UnsupportedEncodingException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btEncode -> encodeData()
            R.id.btDecode -> decodeData()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btEncode.setOnClickListener(this)
        btDecode.setOnClickListener(this)
    }

    private fun encodeData() {
        val encode = editEncode.text.toString().trim { it <= ' ' }
        if (!encode.isEmpty()) {
            try {
                val encodeByte = encode.toByteArray(charset("UTF-8"))
                val strEncode = Base64.encodeToString(encodeByte, Base64.DEFAULT)
                txtEncoded.setText(strEncode)
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
            }

        } else {
            Toast.makeText(this, "Enter your text to encode", Toast.LENGTH_SHORT).show()
        }
    }

    private fun decodeData() {
        val decode = editDecode.text.toString().trim { it <= ' ' }
        if (!decode.isEmpty()) {
            try {

                val decodeByte = Base64.decode(decode, Base64.DEFAULT)
                val strDecode = String(decodeByte, charset("UTF-8"))
                txtDecoded.text = strDecode
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
            }

        } else {
            Toast.makeText(this, "Enter your text to decode", Toast.LENGTH_SHORT).show()
        }
    }
}