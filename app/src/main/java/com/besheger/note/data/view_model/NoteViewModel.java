package com.besheger.note.data.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.besheger.note.data.repository.local.NoteDAO;
import com.besheger.note.data.repository.remot.NoteEndPoint;
import com.besheger.note.NoteApp;
import com.besheger.note.model.NoteResponse;
import com.besheger.note.model.UserNote;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NoteViewModel extends AndroidViewModel {
    private NoteDAO noteDAO;

    private Retrofit retrofit;
    private MutableLiveData<List<UserNote>> userNote;
    private MutableLiveData<NoteResponse> noteResponse;

    public NoteViewModel(Application application) {
        super(application);

        retrofit=((NoteApp)application).getRetrofit();
        userNote=new MutableLiveData<>();
        noteResponse=new MutableLiveData<>();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

  //  public getNotelist(){}


    public void setUserNote(MutableLiveData<List<UserNote>> userNote) {
        this.userNote = userNote;
    }

    public MutableLiveData<NoteResponse> getNoteResponse() {
        return noteResponse;
    }

    public void setNoteResponse(MutableLiveData<NoteResponse> noteResponse) {
        this.noteResponse = noteResponse;
    }

    public MutableLiveData<List<UserNote>> getUserNote() {
        NoteEndPoint noteEndPoint=retrofit.create(NoteEndPoint.class);
        noteEndPoint.getUser().enqueue(new Callback<List<UserNote>>() {
            @Override
            public void onResponse(Call<List<UserNote>> call, Response<List<UserNote>> response) {
                System.out.println(response.body());
                userNote.setValue(response.body());
            }
            @Override
            public void onFailure(Call<List<UserNote>> call, Throwable t) {

            }
        });

        return userNote;
    }

    public void updateNote(UserNote userNote) {
        JsonObject note = new JsonObject();
        note.addProperty("note_id",userNote.getNoteId());
        note.addProperty("note_cat",userNote.getNoteCat());
        note.addProperty("note_type",userNote.getNoteType());
        note.addProperty("user_id",userNote.getNoteId());
        note.addProperty("note_subject",userNote.getNoteSubject());
        note.addProperty("note_section",userNote.getNoteSection());
        note.addProperty("note_title",userNote.getNoteTitle());
        note.addProperty("note_body",userNote.getNoteBody());
        note.addProperty("date_created",userNote.getDateCreated());
        //note.addProperty("edit_date",  userNote.getEditDate());
       // note.addProperty("edit_count",userNote.getEditCount()+1);

        NoteEndPoint noteEndPoint=retrofit.create(NoteEndPoint.class);
        noteEndPoint.updateNote(note).enqueue(new Callback<NoteResponse>() {
            @Override
            public void onResponse(Call<NoteResponse> call, Response<NoteResponse> response) {
                noteResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<NoteResponse> call, Throwable t) {

            }
        });



    }
    public void newNote(UserNote userNote) {
        JsonObject note = new JsonObject();
        note.addProperty("note_id",userNote.getNoteId());
        note.addProperty("note_cat",userNote.getNoteCat());
        note.addProperty("note_type",userNote.getNoteType());
        note.addProperty("user_id",userNote.getNoteId());

        note.addProperty("note_subject",userNote.getNoteSubject());
        note.addProperty("note_section",userNote.getNoteSection());
        note.addProperty("note_title",userNote.getNoteTitle());
        note.addProperty("note_body",userNote.getNoteBody());
        note.addProperty("date_created",userNote.getDateCreated());
        //note.addProperty("edit_date",  userNote.getEditDate());
       // note.addProperty("edit_count",userNote.getEditCount()+1);

        NoteEndPoint noteEndPoint=retrofit.create(NoteEndPoint.class);
        noteEndPoint.newNote(note).enqueue(new Callback<NoteResponse>() {
            @Override
            public void onResponse(Call<NoteResponse> call, Response<NoteResponse> response) {
                noteResponse.setValue(response.body());
            }
            @Override
            public void onFailure(Call<NoteResponse> call, Throwable t) {

            }
        });



    }
}
