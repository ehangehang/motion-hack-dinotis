package com.example.dinotis20

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import java.util.*

class PortfolioActivity : AppCompatActivity() {

    private lateinit var btBack: ImageView
    private lateinit var btDate: ImageView
    private lateinit var edtDate: EditText

    private fun init() {
        btBack = findViewById(R.id.porto_bt_back)
        btDate = findViewById(R.id.porto_bt_date)
        edtDate = findViewById(R.id.porto_edt_date)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portfolio)

        init()

        btBack.setOnClickListener {
            finish()
        }

        val c = Calendar.getInstance()
        val y = c.get(Calendar.YEAR)
        val m = c.get(Calendar.MONTH)
        val d = c.get(Calendar.DAY_OF_MONTH)

        btDate.setOnClickListener {
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, y, m, d ->
                val year = y.toString()
                val mInt = m+1
                val month = mInt.toString()
                val day = d.toString()
                edtDate.setText("$day/$month/$year")
            }, y, m, d).show()
        }
    }
}