package com.example.playlistmaker

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val buttonBack = findViewById<ImageView>(R.id.arrow_back_light)
        buttonBack.setOnClickListener {
            Intent(this, MainActivity::class.java)
            finish()
        }

        val inputEditText = findViewById<EditText>(R.id.search_input_text)
        val clearButton = findViewById<ImageView>(R.id.buttonClearInputText)

        clearButton.setOnClickListener {
            inputEditText.setText("")
            inputEditText.hideKeyboard()
        }

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // empty
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                clearButton.visibility = clearButtonVisibility(s)
                if (savedInstanceState != null) {
                    valueTextInput = savedInstanceState.getString(TEXT_INPUT, DEFAULT_TEXT_INPUT)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // empty
            }
        }
        inputEditText.addTextChangedListener(textWatcher)
    }

    private fun clearButtonVisibility(s: CharSequence?): Int {
        return if (s.isNullOrEmpty()) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    private fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

    private var valueTextInput: String = DEFAULT_TEXT_INPUT

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_INPUT, valueTextInput)
    }
    companion object {
        const val TEXT_INPUT = "TEXT_INPUT"
        const val DEFAULT_TEXT_INPUT = ""
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        valueTextInput = savedInstanceState.getString(TEXT_INPUT, DEFAULT_TEXT_INPUT)
    }


}