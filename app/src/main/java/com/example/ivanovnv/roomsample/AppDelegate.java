package com.example.ivanovnv.roomsample;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.ivanovnv.roomsample.database.MusicDatabase;

/**
 * Created by IvanovNV on 24.04.2018.
 */

public class AppDelegate extends Application {

    private MusicDatabase mMusicDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mMusicDatabase = Room.databaseBuilder(this, MusicDatabase.class, "musicdatabse")
                .allowMainThreadQueries()
                .build();
    }

    public MusicDatabase getMusicDatabase() {
        return mMusicDatabase;
    }
}
