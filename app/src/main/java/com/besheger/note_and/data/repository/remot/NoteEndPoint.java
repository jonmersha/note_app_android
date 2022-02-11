package com.besheger.note_and.data.repository.remot;


import com.besheger.note_and.model.NoteResponse;
import com.besheger.note_and.model.UserNote;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NoteEndPoint {
    @GET("/note/list")
    Call<List<UserNote>> getUser();
    @POST("/note/edit")
    Call<NoteResponse> updateNote(@Body JsonObject body);
    @POST("/note/add")
    Call<NoteResponse> newNote(@Body JsonObject body);
}
