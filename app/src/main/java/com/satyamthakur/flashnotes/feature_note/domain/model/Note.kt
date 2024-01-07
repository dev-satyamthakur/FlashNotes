package com.satyamthakur.flashnotes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.satyamthakur.flashnotes.ui.theme.Green
import com.satyamthakur.flashnotes.ui.theme.Orange
import com.satyamthakur.flashnotes.ui.theme.Peach
import com.satyamthakur.flashnotes.ui.theme.Yellow

@Entity
data class Note(
    @PrimaryKey
    val id: Int? = null,
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int
) {
    companion object {
        val noteColors = listOf(Yellow, Orange, Peach, Green)
    }
}