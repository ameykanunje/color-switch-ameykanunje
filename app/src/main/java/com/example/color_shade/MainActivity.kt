package com.example.color_shade

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.GradientDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Switch
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.color_shade.R.id.mainText
import org.w3c.dom.Text
import java.io.StringBufferInputStream
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var redTextView: TextView
    lateinit var blueTextView: TextView
    lateinit var greenTextView: TextView
    lateinit var redSeekBar: SeekBar
    lateinit var blueSeekBar: SeekBar
    lateinit var greenSeekBar: SeekBar
    lateinit var redSwitch: Switch
    lateinit var blueSwitch: Switch
    lateinit var greenSwitch: Switch
    lateinit var mainText: TextView
    lateinit var resetButton: Button




    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var red_color: Int = 0
        var blue_color: Int = 0
        var green_color: Int = 0

        var redSwitch = findViewById<Switch>(R.id.redSwitch)
        var blueSwitch = findViewById<Switch>(R.id.blueSwitch)
        var greenSwitch = findViewById<Switch>(R.id.greenSwitch)

        //Seekbar id
        var redSeek = findViewById<SeekBar>(R.id.redSeekbar)
        var blueSeek = findViewById<SeekBar>(R.id.blueSeekbar)
        var greenSeek = findViewById<SeekBar>(R.id.greenSeekbar)


        //TextView id
        var redText = findViewById<TextView>(R.id.redTextNumber)
        var blueText = findViewById<TextView>(R.id.blueTextNumber)
        var greenText = findViewById<TextView>(R.id.greenTextNumber)

        //main text view with color
        mainText = findViewById<Border>(R.id.mainText)
        mainText.setBackgroundColor(R.drawable.border)



        redSeek.isEnabled = false
        redText.isEnabled = false
        blueSeek.isEnabled = false
        blueText.isEnabled = false
        greenSeek.isEnabled = false
        greenText.isEnabled = false

        resetButton = findViewById(R.id.resetButton)

        redSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {

                redSeek.isEnabled = true
                redText.isEnabled = true

                red_color = redSeek.progress
                if (redSeek != null) {
                    updateColor(mainText, red_color, green_color, blue_color)
                }
                redSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        if (redSeek != null) {

                            red_color = redSeek.progress

                            updateColor(mainText, red_color, green_color, blue_color)
                        }
                        // Update UI or do something based on the progress
                        val formattedValue = DecimalFormat("#0.000").format(progress / 255.0)

                        // Set the text in the EditText
                        redText.setText(formattedValue)
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                        // Called when the user first touches the SeekBar
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        // Called when the user stops touching the SeekBar

                    }
                })

                redText.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                        // Do nothing

                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        // Do nothing

                    }

                    override fun afterTextChanged(s: Editable?) {
                        // Update the SeekBar progress if the EditText text is a valid decimal number
                        s?.toString()?.toDoubleOrNull()?.let {
                            val progress = (it * 255).toInt()
                            redSeek.progress = progress
                        }
                    }
                })
            } else {
                // Execute this block if the SwitchCompat is turned off
                redSeek.isEnabled = false
                redText.isEnabled = false
                red_color = 0
                if (redText != null) {
                    updateColor(mainText, red_color, green_color, blue_color)
                }
            }
        }

        blueSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {

                blueSeek.isEnabled = true
                blueText.isEnabled = true

                blue_color = blueSeek.progress
                if (blueSeek != null) {
                    updateColor(mainText, red_color, green_color, blue_color)
                }
                blueSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        if (blueSeek != null) {

                            blue_color = blueSeek.progress

                            updateColor(mainText, red_color, green_color, blue_color)
                        }
                        // Update UI or do something based on the progress
                        val formattedValue = DecimalFormat("#0.000").format(progress / 255.0)

                        // Set the text in the EditText
                        blueText.setText(formattedValue)
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                        // Called when the user first touches the SeekBar
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        // Called when the user stops touching the SeekBar

                    }
                })

                blueText.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                        // Do nothing

                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        // Do nothing

                    }

                    override fun afterTextChanged(s: Editable?) {
                        // Update the SeekBar progress if the EditText text is a valid decimal number
                        s?.toString()?.toDoubleOrNull()?.let {
                            val progress = (it * 255).toInt()
                            blueSeek.progress = progress
                        }
                    }
                })
            } else {
                // Execute this block if the SwitchCompat is turned off
                blueSeek.isEnabled = false
                blueText.isEnabled = false
                blue_color = 0
                if (blueText != null) {
                    updateColor(mainText, red_color, green_color, blue_color)
                }
            }
        }

        greenSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {

                greenSeek.isEnabled = true
                greenText.isEnabled = true

                green_color = greenSeek.progress
                if (greenSeek != null) {
                    updateColor(mainText, red_color, green_color, blue_color)
                }
                greenSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        if (greenSeek != null) {

                            green_color = greenSeek.progress

                            updateColor(mainText, red_color, green_color, blue_color)
                        }
                        // Update UI or do something based on the progress
                        val formattedValue = DecimalFormat("#0.000").format(progress / 255.0)

                        // Set the text in the EditText
                        greenText.setText(formattedValue)
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                        // Called when the user first touches the SeekBar
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        // Called when the user stops touching the SeekBar

                    }
                })

                greenText.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                        // Do nothing

                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        // Do nothing

                    }

                    override fun afterTextChanged(s: Editable?) {
                        // Update the SeekBar progress if the EditText text is a valid decimal number
                        s?.toString()?.toDoubleOrNull()?.let {
                            val progress = (it * 255).toInt()
                            greenSeek.progress = progress
                        }
                    }
                })
            } else {
                // Execute this block if the SwitchCompat is turned off
                greenSeek.isEnabled = false
                greenText.isEnabled = false
                green_color = 0
                if (greenText != null) {
                    updateColor(mainText, red_color, green_color, blue_color)
                }
            }
        }

        resetButton.setOnClickListener{
            redSeek.progress = 0
            blueSeek.progress = 0
            greenSeek.progress = 0

            redSwitch.isChecked = false
            blueSwitch.isChecked = false
            greenSwitch.isChecked = false

        }

    }


    private fun updateColor(mainText: TextView, red: Int, green: Int, blue: Int) {

        var color = Color.rgb(red, green, blue)


        if (red == 0 && blue == 0 && green == 0) {
            mainText.setBackgroundColor(Color.WHITE)
        } else {
            mainText.setBackgroundColor(color)
        }
    }
}





