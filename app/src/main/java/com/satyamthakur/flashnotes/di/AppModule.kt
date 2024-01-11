package com.satyamthakur.flashnotes.di

import android.app.Application
import androidx.room.Room
import com.satyamthakur.flashnotes.feature_note.data.data_source.NoteDatabase
import com.satyamthakur.flashnotes.feature_note.data.repository.NoteRepositoryImplementation
import com.satyamthakur.flashnotes.feature_note.domain.repository.NoteRepository
import com.satyamthakur.flashnotes.feature_note.domain.use_case.AddNote
import com.satyamthakur.flashnotes.feature_note.domain.use_case.DeleteNote
import com.satyamthakur.flashnotes.feature_note.domain.use_case.GetNotes
import com.satyamthakur.flashnotes.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImplementation(db.noteDao)
    }

    @Provides
    @Singleton
    fun providesNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }

}