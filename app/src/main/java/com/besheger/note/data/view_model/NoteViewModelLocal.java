package com.besheger.note.data.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.besheger.note.data.repository.local.Note;
import com.besheger.note.data.repository.local.NoteCatModel;
import com.besheger.note.data.repository.local.DataBaseRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NoteViewModelLocal extends AndroidViewModel {

    private DataBaseRepository localRepo;
    private LiveData<List<Note>> allNote;
    private LiveData<List<NoteCatModel>> noteCat;

    public void registerNote(Note note){
        localRepo.registerMainNote(note);

    }
    public NoteViewModelLocal(@NonNull @NotNull Application application) {
        super(application);
        this.localRepo=new DataBaseRepository(application);
        this.allNote= localRepo.getUserNote();
        this.noteCat=localRepo.getNoteCategory();
    }

    public DataBaseRepository getLocalRepo() {
        return localRepo;
    }

    public void setLocalRepo(DataBaseRepository localRepo) {
        this.localRepo = localRepo;
    }

    public LiveData<List<Note>> getAllNote() {
        return allNote;
    }

    public void setAllNote(LiveData<List<Note>> allNote) {
        this.allNote = allNote;
    }

    public LiveData<List<NoteCatModel>> getNoteCat() {
        return noteCat;
    }

    public void setNoteCat(LiveData<List<NoteCatModel>> noteCat) {
        this.noteCat = noteCat;
    }
}
