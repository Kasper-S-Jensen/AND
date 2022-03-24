package com.example.architectureexample.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.architectureexample.viewmodel.MainActivityViewmodel
import com.example.architectureexample.R

class MainActivity : AppCompatActivity() {

    private var viewModel: MainActivityViewmodel? = null
    lateinit var textView: TextView
    lateinit var addButton: Button
    lateinit var deleteButton: Button
    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewmodel::class.java]
        textView = findViewById<TextView>(R.id.textView)
        addButton = findViewById<Button>(R.id.addButton)
        deleteButton = findViewById<Button>(R.id.deleteButton)
        editText = findViewById<EditText>(R.id.editText)
        viewModel!!.getAllNotes().observe(this) {
            textView.setText("")
            val notes = viewModel!!.getAllNotes().value
            for (note in notes!!) {
                textView.append(
                    """
                $note
                
                
                
                """.trimIndent()
                )
            }

        }


        addButton.setOnClickListener(){
            addNote()
        }
        deleteButton.setOnClickListener(){
            deleteAll()
        }
        displayNotes()

    }



    fun addNote() {
        viewModel!!.addNote(editText.text.toString())
        displayNotes()
    }

    fun deleteAll() {
        viewModel!!.deleteAllNotes()
        displayNotes()
    }


    private fun displayNotes() {

    }

}