package com.example.tablelayout

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addTableRow("Android 9.0", "Pie")
        addTableRow("Android 8.0", "Oreo")

       btn.setOnClickListener {
            addTableRow(
                addversion.text.toString().trim(),
                addcodename.text.toString().trim()
            )
        }

    }

     fun addTableRow(vName: String, cName: String) {
        val tableRow = TableRow(applicationContext)

        val columnVersion = TextView(applicationContext)
        columnVersion.text = vName

        val columnCodeName = TextView(applicationContext)
        columnCodeName.text = cName

        tableRow.addView(columnVersion, 0)
        tableRow.addView(columnCodeName, 1)

        val VersionParam = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(0, 2, 5, 0)
        }

        columnVersion.setBackgroundResource(R.color.teal_200)
        VersionParam.weight = 1f
        columnVersion.layoutParams = VersionParam

        val CodeNameParam = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(0, 2, 0, 0)
        }

        columnCodeName.setBackgroundResource(R.color.teal_200)
        CodeNameParam.weight = 1f
        columnCodeName.layoutParams = CodeNameParam

        addTable.addView(tableRow)
    }
}