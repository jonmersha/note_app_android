package com.besheger.note.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_cat")
public class NoteCat {
    @PrimaryKey
    int id;
    @ColumnInfo(name="cat_name")
    private String catName;

}
