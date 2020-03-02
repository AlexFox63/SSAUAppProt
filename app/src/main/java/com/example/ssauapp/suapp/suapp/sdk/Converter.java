package com.example.ssauapp.suapp.suapp.sdk;

import com.example.ssauapp.suapp.suapp.server.utility.NoteListWrapper;
import com.google.gson.Gson;

public abstract class Converter {
    public static NoteListWrapper convertNotesList(String notes){
        return new Gson().fromJson(notes, NoteListWrapper.class);
    }
}
