package com.example.architectureexample.viewmodel

import androidx.lifecycle.ViewModel

class MainActivityViewmodel : ViewModel() {

    private var notes: MutableList<String> = mutableListOf<String>()

    fun getAllNotes(): List<String?>? {
        return notes
    }

    fun addNote(note: String?) {
        notes.add(note!!)
    }

    fun deleteAllNotes() {
        notes.clear()
    }


}