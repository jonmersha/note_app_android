package com.besheger.note_and.data.repository.local;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.besheger.note_and.model.UserNote;

import java.util.List;

public class DataBaseRepository {
    private NoteDAO noteDAO;
    private LiveData<List<UserNote>> allUserNote;

    public DataBaseRepository(Application application) {

    }
}
