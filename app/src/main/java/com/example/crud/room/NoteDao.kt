package com.example.crud.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note WHERE id = :noteId")
    suspend fun getNote(noteId: Int): List<Note>

    @Query("SELECT * FROM note")
    suspend fun getNotes(): List<Note>
}
