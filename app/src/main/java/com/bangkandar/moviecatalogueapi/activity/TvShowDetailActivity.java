package com.bangkandar.moviecatalogueapi.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bangkandar.moviecatalogueapi.R;
import com.bangkandar.moviecatalogueapi.model.TvShow;
import com.bumptech.glide.Glide;


public class TvShowDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TVSHOW = "information";

    private TextView tv_judul, tv_deskripsi, tv_rating, tv_genre, tv_rilis, tv_bahasa;
    private ImageView img_tvshow;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);

        img_tvshow = findViewById(R.id.img_poster);
        tv_judul = findViewById(R.id.txt_title);
        tv_rating = findViewById(R.id.txt_user_score);
        tv_genre = findViewById(R.id.txt_genres);
        tv_rilis = findViewById(R.id.txt_rilis);
        tv_deskripsi = findViewById(R.id.txt_overview);
        tv_bahasa = findViewById(R.id.txt_bahasa);
        progressBar = findViewById(R.id.progressBarShowDetail);

        progressBar.setVisibility(View.VISIBLE);
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (Exception ignored) {

                }
                handler.post(new Runnable() {
                    public void run() {
                        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TVSHOW);

                        String rating = Double.toString(tvShow.getRating());
                        String popular = Double.toString(tvShow.getPopular());
                        String url_image = "https://image.tmdb.org/t/p/original" + tvShow.getGambar();

                        tv_judul.setText(tvShow.getJudul());
                        tv_rilis.setText(tvShow.getRilis());
                        tv_rating.setText(rating);
                        tv_genre.setText(popular);
                        tv_deskripsi.setText(tvShow.getDeskripsi());
                        tv_bahasa.setText(tvShow.getBahasa());

                        Glide.with(TvShowDetailActivity.this)
                                .load(url_image)
                                .placeholder(R.color.abu_terang)
                                .dontAnimate()
                                .into(img_tvshow);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }).start();
    }
}
