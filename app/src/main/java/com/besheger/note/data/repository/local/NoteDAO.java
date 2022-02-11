package com.besheger.note.data.repository.local;

import androidx.room.Dao;
import androidx.room.Insert;

import com.besheger.note.model.NoteCat;
import com.besheger.note.model.Subject;
import com.besheger.note.model.User;
import com.besheger.note.model.UserNote;

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
