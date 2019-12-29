package com.bangkandar.moviecatalogueapi.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bangkandar.moviecatalogueapi.R;
import com.bangkandar.moviecatalogueapi.model.Movie;
import com.bumptech.glide.Glide;


public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "information";

    private TextView tv_judul, tv_deskripsi, tv_rating, tv_bahasa, tv_rilis;
    private ImageView img_movie;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        img_movie = findViewById(R.id.img_poster);
        tv_judul = findViewById(R.id.txt_title);
        tv_rating = findViewById(R.id.txt_user_score);
        tv_bahasa = findViewById(R.id.txt_runtime);
        tv_rilis = findViewById(R.id.txt_rilis);
        tv_deskripsi = findViewById(R.id.txt_overview);

        progressBar = findViewById(R.id.progressDetailMovie);

//        progressBar.setVisibility(View.VISIBLE);
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {

                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
                        String rating = Double.toString(movie.getRating());
                        String url_image = "https://image.tmdb.org/t/p/w185" + movie.getGambar();

                        tv_judul.setText(movie.getJudul());
                        tv_deskripsi.setText(movie.getDeskripsi());
                        tv_bahasa.setText(movie.getBahasa());
                        tv_rating.setText(rating);
                        tv_rilis.setText(movie.getRilis());
                        Glide.with(MovieDetailActivity.this)
                                .load(url_image)
                                .placeholder(R.color.abu_terang)
                                .dontAnimate()
                                .into(img_movie);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }).start();
    }
}
