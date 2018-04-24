package com.example.ivanovnv.roomsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ivanovnv.roomsample.database.Album;
import com.example.ivanovnv.roomsample.database.MusicDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mAddButton;
    private Button mGetButton;

    // добавить базу данных Room ---------
    // вставить данные / извлечь данные -------

    // добавить контент-провайдер над Room


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final MusicDao musicDao = ((AppDelegate) getApplicationContext()).getMusicDatabase().getMusicDao();

        mAddButton =  findViewById(R.id.add);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicDao.insertAlbums(createAlbums());
            }
        });

        mGetButton = findViewById(R.id.get);
        mGetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(musicDao.getAlbums());
            }
        });
    }

    private void showToast(List<Album> albums) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0, size = albums.size(); i < size; i++) {
            builder.append(albums.get(i).toString()).append("\n");
        }

        Toast.makeText(this, builder.toString(), Toast.LENGTH_SHORT).show();
    }

    private List<Album> createAlbums() {
        List<Album> albums = new ArrayList<>(10);

       for(int i = 0; i < 10 ; i++) {
           albums.add(new Album(i, "album " + i, "release " + System.currentTimeMillis()));
       }

       return albums;
    }
}
