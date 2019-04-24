package edu.washington.aiones.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button_tip)
        val amountInput : EditText = findViewById(R.id.amount_input)

        button.isEnabled = false

        amountInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                button.isEnabled = true
            }
        })

        button.setOnClickListener {
            val amount = amountInput.text.toString()
            val tip = calculate(amount)
            Toast.makeText(this, "15% tip is $$tip", Toast.LENGTH_LONG).show()
        }
    }

    private fun calculate(textString : String) : String {
        return BigDecimal(textString.toDouble() * .15).setScale(2,RoundingMode.HALF_EVEN ).toString()
    }
}
