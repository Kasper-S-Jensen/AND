package com.example.architectureexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewmodel : ViewModel() {

    private var newList: MutableList<String> = mutableListOf<String>()
    private var notes: MutableLiveData<MutableList<String>> = MutableLiveData()

    init {
        notes.value = newList
    }

    fun getAllNotes(): LiveData<MutableList<String>> {
        return notes
    }

    fun addNote(note: String) {
        val currentNotes = notes.value
        currentNotes?.add(note)
        notes.value=currentNotes
    }

    fun deleteAllNotes() {
        val currentNotes = notes.value
        currentNotes!!.clear()
        notes.value = currentNotes
    }


}