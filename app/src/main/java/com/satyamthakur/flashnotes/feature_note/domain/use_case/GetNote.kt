package com.satyamthakur.flashnotes.feature_note.domain.use_case

import com.satyamthakur.flashnotes.feature_note.domain.model.Note
import com.satyamthakur.flashnotes.feature_note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {
    suspend fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}