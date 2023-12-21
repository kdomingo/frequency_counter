package com.kdomingo.charcounter

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputField = findViewById<AppCompatEditText>(R.id.txt_input)
        val outputField = findViewById<TextView>(R.id.txt_output)

        findViewById<AppCompatButton>(R.id.btn_count)
            .setOnClickListener {
                outputField.text = processString(inputField.text?.toString())
            }
    }

    private fun processString(haystack: String? = "glaass"): String {
        if (TextUtils.isEmpty(haystack)) return "Invalid input"

        /**
         * Given a string, find the character that occurs the most frequently.
         * If two or more characters in the string have the same number of occurrences,
         * return the character that had the most first.
         * Input and output can be all lowercase
         */

        /**
         * - If the entered string is "glaass", the output should be "a"
         * - if the entered string is "grass" the output should be "s"
         * - if the entered string has no repeating characters we can say
         *    "no repeating characters"
         */

        val chars = haystack!!.toCharArray()
        val countMap = LinkedHashMap<Char, Int>()

        chars.forEach {
            countMap[it] = chars.count { needle -> needle == it }
        }

        // Remove the singles
        val result = countMap.filterValues { it != 1 }

        if (result.isEmpty())
            return "no repeating characters"

        return "Most frequent: ${result.keys.first()}"
    }
}