package com.besheger.note.data.repository.local;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_section")
public class NoteSection {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="section_id")
    int sectionID;
    @ColumnInfo(name="note_id")
    int noteId;
    @ColumnInfo(name="section_title")
    String sectionTitle;
    @ColumnInfo(name="section_body")
    String sectionBody;
    @ColumnInfo(name="date_created")
    String dateCreated;


    public int getSectionID() {
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public String getSectionBody() {
        return sectionBody;
    }

    public void setSectionBody(String sectionBody) {
        this.sectionBody = sectionBody;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
