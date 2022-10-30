package com.example.tablelayout

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
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

    private fun addTableRow(vName: String, cName: String) {
        val tableRow = TableRow(this)

        val columnVersion = TextView(this)
        columnVersion.text = vName

        val columnCodeName = TextView(this)
        columnCodeName.text = cName

        tableRow.addView(columnVersion, 0)
        tableRow.addView(columnCodeName, 1)

        val VersionParam = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(0, 2, 5, 0)
        }
        VersionParam.weight = 1f
        columnVersion.setBackgroundResource(R.color.teal_200)
        columnVersion.layoutParams = VersionParam

        val CodeNameParam = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT).apply {
            setMargins(0, 2, 0, 0)
        }
        CodeNameParam.weight = 1f
        columnCodeName.setBackgroundResource(R.color.teal_200)
        columnCodeName.layoutParams = CodeNameParam

        androidTable.addView(tableRow)
    }
}