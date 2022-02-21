package com.besheger.note.data.repository.local;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "main_note")
public class Note {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="note_id")
    int noteId;
    @ColumnInfo(name="note_title")
    String noteTitle;
    @ColumnInfo(name="note_category")
    String noteCategory;
    @ColumnInfo(name="note_body")
    String noteBody;
    @ColumnInfo(name="date_created")
    String dateCreated;
    @ColumnInfo(name="creator_id")
    int creatorID;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteCategory() {
        return noteCategory;
    }

    public void setNoteCategory(String noteCategory) {
        this.noteCategory = noteCategory;
    }

    public String getNoteBody() {
        return noteBody;
    }

    public void setNoteBody(String noteBody) {
        this.noteBody = noteBody;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }
}
