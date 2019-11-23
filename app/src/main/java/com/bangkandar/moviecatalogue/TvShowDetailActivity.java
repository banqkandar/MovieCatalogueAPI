package com.bangkandar.moviecatalogue;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bangkandar.moviecatalogue.model.TvShow;

import java.util.Objects;


public class TvShowDetailActivity extends AppCompatActivity {

    String Judul, Rating, Deskripsi, Genre, Durasi, Rilis, Episode;
    int Gambar;

    public static final String EXTRA_MOVIE = "information";

    private TextView tv_judul, tv_deskripsi, tv_rating, tv_genre, tv_durasi, tv_rilis, tv_eps;
    private ImageView MovieImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);

        MovieImg = findViewById(R.id.img_poster);
        tv_judul = findViewById(R.id.txt_title);
        tv_rating = findViewById(R.id.txt_user_score);
        tv_genre = findViewById(R.id.txt_genres);
        tv_durasi = findViewById(R.id.txt_runtime);
        tv_rilis = findViewById(R.id.txt_rilis);
        tv_deskripsi = findViewById(R.id.txt_overview);
        tv_eps = findViewById(R.id.txt_episodes);

//        ArrayList<Movie> movie = this.getIntent().getParcelableArrayListExtra(EXTRA_MOVIE);
        TvShow tvShow = this.getIntent().getParcelableExtra(EXTRA_MOVIE);
        Gambar = tvShow.getGambar();
        MovieImg.setImageResource(Gambar);

        Judul = tvShow.getJudul();
        tv_judul.setText(Judul);

        Rating = tvShow.getRating();
        tv_rating.setText(Rating);

        Genre = tvShow.getGenre();
        tv_genre.setText(Genre);

        Durasi = tvShow.getDurasi();
        tv_durasi.setText(Durasi);

        Rilis = tvShow.getRilis();
        tv_rilis.setText(Rilis);

        Episode = tvShow.getEpisode();
        tv_eps.setText(Episode);

        Deskripsi = tvShow.getDeskripsi();
        tv_deskripsi.setText(Deskripsi);
    }
}
