package com.example.dinotis20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class OTPActivity : AppCompatActivity() {
    private lateinit var otpDigit1 : EditText
    private lateinit var otpDigit2 : EditText
    private lateinit var otpDigit3 : EditText
    private lateinit var otpDigit4 : EditText
    private lateinit var otpDigit5 : EditText
    private lateinit var otpDigit6 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        otpDigit1 = findViewById<EditText>(R.id.otp_digit1)
        otpDigit2 = findViewById<EditText>(R.id.otp_digit2)
        otpDigit3 = findViewById<EditText>(R.id.otp_digit3)
        otpDigit4 = findViewById<EditText>(R.id.otp_digit4)
        otpDigit5 = findViewById<EditText>(R.id.otp_digit5)
        otpDigit6 = findViewById<EditText>(R.id.otp_digit6)

        otpDigit1.addTextChangedListener(GenericTextWatcher(otpDigit1, otpDigit2))
        otpDigit2.addTextChangedListener(GenericTextWatcher(otpDigit2, otpDigit3))
        otpDigit3.addTextChangedListener(GenericTextWatcher(otpDigit3, otpDigit4))
        otpDigit4.addTextChangedListener(GenericTextWatcher(otpDigit4, otpDigit5))
        otpDigit5.addTextChangedListener(GenericTextWatcher(otpDigit5, otpDigit6))
        otpDigit6.addTextChangedListener(GenericTextWatcher(otpDigit6, null))

        otpDigit1.setOnKeyListener(GenericKeyEvent(otpDigit1, null))
        otpDigit2.setOnKeyListener(GenericKeyEvent(otpDigit2, otpDigit1))
        otpDigit3.setOnKeyListener(GenericKeyEvent(otpDigit3, otpDigit2))
        otpDigit4.setOnKeyListener(GenericKeyEvent(otpDigit4, otpDigit3))
        otpDigit5.setOnKeyListener(GenericKeyEvent(otpDigit5, otpDigit4))
        otpDigit6.setOnKeyListener(GenericKeyEvent(otpDigit6, otpDigit5))
    }

    class GenericKeyEvent internal constructor(private val currentView: EditText, private val previousView: EditText?) : View.OnKeyListener {
        override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
            if (event!!.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && currentView.id != R.id.otp_digit1 && currentView.text.isEmpty()) {
                previousView!!.text = null
                previousView.requestFocus()
                return true
            }
            return false
        }
    }

    class GenericTextWatcher internal constructor(private val currentView: View, private val nextView: View?) :
        TextWatcher {
        override fun afterTextChanged(editable: Editable) { // TODO Auto-generated method stub
            val text = editable.toString()
            when (currentView.id) {
                R.id.otp_digit1 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.otp_digit2 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.otp_digit3 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.otp_digit4 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.otp_digit5 -> if (text.length == 1) nextView!!.requestFocus()
                //You can use EditText4 same as above to hide the keyboard
            }
        }
        override fun beforeTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) { // TODO Auto-generated method stub
        }

        override fun onTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) { // TODO Auto-generated method stub
        }
    }
}