package com.besheger.note.data.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.besheger.note.data.repository.local.NoteCatModel;
import com.besheger.note.data.repository.local.DataBaseRepository;
import com.besheger.note.model.UserNote;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NoteViewModelLocal extends AndroidViewModel {
    private DataBaseRepository localRepo;
    private LiveData<List<UserNote>> userNote;
    private LiveData<List<NoteCatModel>> noteCat;

    public NoteViewModelLocal(@NonNull @NotNull Application application) {
        super(application);
    }
}
