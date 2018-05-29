package com.priyankam.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener, OnLoopjCompleted {

    lateinit var buttonSearch: Button
    lateinit var etSearchTerm: EditText
    lateinit var tvSearchResult: TextView
    lateinit var myLoopjTask: MyLoopjTask
    lateinit var buttonGetJsonData: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGetJsonData = findViewById(R.id.btnGetJsonData) as Button
        buttonSearch = findViewById(R.id.btnSearch) as Button
        etSearchTerm = findViewById(R.id.etSearchTerms) as EditText
        tvSearchResult = findViewById(R.id.tvSearchResults) as TextView

        buttonSearch.setOnClickListener(this)
        buttonGetJsonData.setOnClickListener(this)

        myLoopjTask = MyLoopjTask(this, this)
    }

    override fun onClick(v: View?) {
        try {
            var searchTerm = etSearchTerm.text.toString()
            etSearchTerm.setText("")

            if (v == buttonSearch) {
                //make loopj Http call
                myLoopjTask.executeLoopjCall(searchTerm)
            } else if (v == buttonGetJsonData) {
                myLoopjTask.executeLoopjCall()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun taskCompleted(results: String?) {

        tvSearchResult.setText(results)
    }

}



