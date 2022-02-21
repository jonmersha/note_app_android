package com.besheger.note.data.repository.local;
import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;

public class DataBaseRepository {
    private NoteDAO noteDAO;
    private LiveData<List<Note>> userNote;
    private LiveData<List<NoteCatModel>> noteCategory;

    public DataBaseRepository(Application application) {
        NoteDataBase noteDataBase=NoteDataBase.getDataBase(application);
        this.noteDAO=noteDataBase.noteDAO();
        this.userNote=this.noteDAO.geAllNote();
    }

    public void registerMainNote(Note note){
        NoteDataBase.databaseWriteExecutor.execute(()->noteDAO.insertNote(note));

    }

    public NoteDAO getNoteDAO() {
        return noteDAO;
    }

    public void setNoteDAO(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    public LiveData<List<Note>> getUserNote() {
        return userNote;
    }

    public void setUserNote(LiveData<List<Note>> userNote) {
        this.userNote = userNote;
    }


    public LiveData<List<NoteCatModel>> getNoteCategory() {
        return noteCategory;
    }

    public void setNoteCategory(LiveData<List<NoteCatModel>> noteCategory) {
        this.noteCategory = noteCategory;
    }
}
