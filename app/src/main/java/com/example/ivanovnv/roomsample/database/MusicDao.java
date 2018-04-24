package com.example.ivanovnv.roomsample.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by IvanovNV on 24.04.2018.
 */

@Dao
public interface MusicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAlbums(List<Album> albums);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSongs(List<Song> songs);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setLinksAlbumSongs(List<AlbumSong> linksAlbumSongs);

    @Query("select * from album")
    List<Album> getAlboms();

    @Query("select * from song")
    List<Song> getSongs();

    @Delete
    void deleteAlbum (Album album);

    @Query("select * from song innet join albumsong on song.id = albumsong.song_id where album_id = :albumid")
    List<Song> getSongsFromAlbum(int albumId);
}