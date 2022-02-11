package com.besheger.note.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NoteResponse {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("affectedRows")
    @Expose
    private Integer affectedRows;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getAffectedRows() {
        return affectedRows;
    }

    public void setAffectedRows(Integer affectedRows) {
        this.affectedRows = affectedRows;
    }
}
