package com.besheger.note.data.repository.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_cat")
public class NoteCatModel {
    @PrimaryKey

    int id;
}
