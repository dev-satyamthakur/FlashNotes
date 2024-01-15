package com.satyamthakur.flashnotes.feature_note.presentation.edit_note

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import com.satyamthakur.flashnotes.feature_note.domain.model.Note
import com.satyamthakur.flashnotes.feature_note.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
): ViewModel() {

    private val _noteTitle = MutableStateFlow(NoteTextFieldState())
    val noteTitle: StateFlow<NoteTextFieldState> = _noteTitle

    private val _noteContent = MutableStateFlow(NoteTextFieldState())
    val noteContent: StateFlow<NoteTextFieldState> = _noteContent

    private val _noteColor = MutableStateFlow<Int>(Note.noteColors.random().toArgb())
    val noteColor: StateFlow<Int> = _noteColor


}