package com.besheger.note_and.data.repository.local;

import androidx.room.Dao;
import androidx.room.Insert;

import com.besheger.note_and.model.NoteCat;
import com.besheger.note_and.model.Subject;
import com.besheger.note_and.model.User;
import com.besheger.note_and.model.UserNote;

@Dao
public interface NoteDAO {
    @Insert
    void insertNote(UserNote userNote);

    @Insert
    void insertUser(User user);

    @Insert
    void insertSubject(Subject subject);

    @Insert
    void insertCategory(NoteCat category);




}
