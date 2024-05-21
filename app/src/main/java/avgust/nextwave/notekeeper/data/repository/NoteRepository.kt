package avgust.nextwave.notekeeper.data.repository

import avgust.nextwave.notekeeper.model.Note
import avgust.nextwave.notekeeper.utils.Resource

interface NoteRepository {
    suspend fun getNotes(result: (Resource<List<Note>>) -> Unit)
    suspend fun addNote(note: Note, result: (Resource<List<Note>>) -> Unit)
    suspend fun archiveNote(note: Note, result: (Resource<List<Note>>) -> Unit)
    suspend fun deleteNote(note: Note, result: (Resource<List<Note>>) -> Unit)
    suspend fun getArchivedNotes(result: (Resource<List<Note>>) -> Unit)
    //suspend fun unArchiveNotes(result: (Resource<List<Note>>) -> Unit)
}