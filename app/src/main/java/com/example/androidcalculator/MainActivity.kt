package com.example.androidcalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var a: Int? = null
    private var b: Int? = null
    private var flag = false
    private var flagReset = false
    private var op = 0
    private var listInput = mutableListOf<String>()

    private lateinit var input: EditText
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        input = findViewById(R.id.inputET)
        result = findViewById(R.id.resultTV)

    }


    fun click_1(view: View) {
        if (flagReset) reset(view)
        if (!flag) numAAdd(1)
        else numBAdd(1)
        addText("1")
        loggin()
    }

    fun click_2(view: View) {
        if (flagReset) reset(view)
        if (!flag) numAAdd(2)
        else numBAdd(2)
        addText("2")
        loggin()
    }

    fun click_3(view: View) {
        if (flagReset) reset(view)
        if (!flag) numAAdd(3)
        else numBAdd(3)
        addText("3")
        loggin()
    }

    fun click_4(view: View) {
        if (flagReset) reset(view)
        if (!flag) numAAdd(4)
        else numBAdd(4)
        addText("4")
        loggin()
    }

    fun click_5(view: View) {
        if (flagReset) reset(view)
        if (!flag) numAAdd(5)
        else numBAdd(5)
        addText("5")
        loggin()
    }

    fun click_6(view: View) {
        if (flagReset) reset(view)
        if (!flag) numAAdd(6)
        else numBAdd(6)
        addText("6")
        loggin()
    }

    fun click_7(view: View) {
        if (flagReset) reset(view)
        if (!flag) numAAdd(7)
        else numBAdd(7)
        addText("7")
        loggin()
    }

    fun click_8(view: View) {
        if (flagReset) reset(view)
        if (!flag) numAAdd(8)
        else numBAdd(8)
        addText("8")
        loggin()
    }

    fun click_9(view: View) {
        if (flagReset) reset(view)
        if (!flag) numAAdd(9)
        else numBAdd(9)
        addText("9")
        loggin()
    }

    fun click_0(view: View) {
        if (flagReset) reset(view)
        if (!flag) numAAdd(0)
        else numBAdd(0)
        addText("0")
        loggin()
    }

    fun click_sum(view: View) {
        if (!(a == null || b != null)) {
            if (!flag) flag = !flag
            else correctOp()
            op = 1
            addText("+")
            loggin()
        }
    }

    fun click_dif(view: View) {
        if (!(a == null || b != null)) {
            if (!flag) flag = !flag
            else correctOp()
            op = 2
            addText("-")
            loggin()
        }
    }

    fun click_mul(view: View) {
        if (!(a == null || b != null)) {
            if (!flag) flag = !flag
            else correctOp()
            op = 3
            addText("*")
            loggin()
        }
    }

    fun click_div(view: View) {
        if (!(a == null || b != null)) {
            if (!flag) flag = !flag
            else correctOp()
            op = 4
            addText("/")
            loggin()
        }
    }

    @SuppressLint("SetTextI18n")
    fun click_res(view: View) {
        if (!(a == null || b == null || op == 0)) {
            flagReset = !flagReset
            loggin()
            addText("=")
            if (a != null && b != null) {
                !flag
                when (op) {
                    1 -> result.text = (a!! + b!!).toString()
                    2 -> result.text = (a!! - b!!).toString()
                    3 -> result.text = (a!! * b!!).toString()
                    4 -> result.text = (a!!.toDouble() / b!!.toDouble()).toString()
                }
            }
        }
    }

    fun reset(view: View) {
        input.text.clear()
        result.text = ContextCompat.getString(this, R.string.result)
        flagReset = false
        a = null
        b = null
        op = 0
        flag = false
        listInput.clear()
    }

    private fun numAAdd(num: Int) {
        if (a == null) {
            a = num
        } else {
            a = a!! * 10
            a = a!! + num
        }
    }

    private fun numBAdd(num: Int) {
        if (b == null) {
            b = num
        } else {
            b = b!! * 10
            b = b!! + num
        }
    }

    @SuppressLint("SetTextI18n")
    private fun addText(element: String) {
        //input.setText("${input.text}$element")
        input.setText("")
        listInput.add(element)
        for (elem in listInput) {
            input.setText("${input.text}$elem")
        }
    }

    private fun loggin() {
        Toast.makeText(
            this,
            "a=$a;b=$b;op=$op",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun correctOp() {
        listInput.removeLast()
    }
}