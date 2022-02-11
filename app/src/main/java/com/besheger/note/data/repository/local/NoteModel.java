package com.besheger.note.data.repository.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note")
public class NoteModel {
    @PrimaryKey
    int id;

}
