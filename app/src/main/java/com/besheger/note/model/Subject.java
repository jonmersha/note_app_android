package com.besheger.note.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "subject")
public class Subject {
    @PrimaryKey
    int id;
}
