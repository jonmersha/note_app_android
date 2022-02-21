package com.besheger.note.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "notes")
public class UserNote {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("note_id")
    @ColumnInfo(name="note_id")
    @Expose
    private Integer noteId;
    @SerializedName("note_cat")
    @ColumnInfo(name="note_cat")
    @Expose
    private Integer noteCat;
    @SerializedName("note_type")
    @ColumnInfo(name="note_type")
    @Expose
    private Integer noteType;
    @SerializedName("user_id")
    @ColumnInfo(name="user_id")
    @Expose
    private Integer userId;
    @SerializedName("note_subject")
    @ColumnInfo(name="note_subject")
    @Expose
    private String noteSubject;
    @SerializedName("note_section")
    @ColumnInfo(name="note_section")
    @Expose
    private String noteSection;
    @SerializedName("note_title")
    @ColumnInfo(name="note_title")
    @Expose
    private String noteTitle;
    @SerializedName("note_body")
    @ColumnInfo(name="note_body")
    @Expose
    private String noteBody;
    @SerializedName("date_created")
    @ColumnInfo(name="date_created")
    @Expose
    private String dateCreated;
    @SerializedName("edit_date")
    @ColumnInfo(name="edit_date")
    @Expose
    private String editDate;
    @SerializedName("edit_count")
    @ColumnInfo(name="edit_count")
    @Expose
    private Integer editCount;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getNoteCat() {
        return noteCat;
    }

    public void setNoteCat(Integer noteCat) {
        this.noteCat = noteCat;
    }

    public Integer getNoteType() {
        return noteType;
    }

    public void setNoteType(Integer noteType) {
        this.noteType = noteType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNoteSubject() {
        return noteSubject;
    }

    public void setNoteSubject(String noteSubject) {
        this.noteSubject = noteSubject;
    }

    public String getNoteSection() {
        return noteSection;
    }

    public void setNoteSection(String noteSection) {
        this.noteSection = noteSection;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
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

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    public Integer getEditCount() {
        return editCount;
    }

    public void setEditCount(Integer editCount) {
        this.editCount = editCount;
    }
}
