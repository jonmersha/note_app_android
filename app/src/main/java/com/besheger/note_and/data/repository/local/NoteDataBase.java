package com.besheger.note_and.data.repository.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {NoteModel.class,NoteCatModel.class},version = 1,exportSchema = false)
public abstract class NoteDataBase extends RoomDatabase {
    public abstract NoteDAO noteDAO();
    public static volatile NoteDataBase INSTANCE;


    private static final int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseWriteExecutor=
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static NoteDataBase getDataBase(final Context context){
        if(INSTANCE==null){
            synchronized (NoteDataBase.class){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(
                            context.getApplicationContext(),
                            NoteDataBase.class,
                            "note_database")
                            .addCallback(remoteCallBack)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    public static  RoomDatabase.Callback remoteCallBack=new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }

        @Override
        public void onOpen(@NonNull @NotNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
}
