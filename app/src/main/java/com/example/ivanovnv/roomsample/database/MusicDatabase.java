package com.example.ivanovnv.roomsample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by IvanovNV on 24.04.2018.
 */
@Database(entities = {Album.class, Song.class, AlbumSong.class}, version = 1)
public abstract class MusicDatabase extends RoomDatabase{

   public abstract MusicDao getMusicDao();
}
