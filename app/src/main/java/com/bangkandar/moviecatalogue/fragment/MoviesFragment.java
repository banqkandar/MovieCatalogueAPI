package com.bangkandar.moviecatalogue.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bangkandar.moviecatalogue.MovieDetailActivity;
import com.bangkandar.moviecatalogue.R;
import com.bangkandar.moviecatalogue.adapter.GridAdapterMovies;
import com.bangkandar.moviecatalogue.model.Movie;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    private final ArrayList<Movie> listMovie = new ArrayList<>();

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        RecyclerView rvMovie = view.findViewById(R.id.rv_movies);
        rvMovie.setHasFixedSize(true);
        rvMovie.setLayoutManager(new GridLayoutManager(getContext(), 3));
        GridAdapterMovies adapter = new GridAdapterMovies(listMovie);
        rvMovie.setAdapter(adapter);

        adapter.setOnItemClickCallback(new GridAdapterMovies.OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie movie) {
                showSelectedMovies(movie);
            }
        });

        listMovie.addAll(getListMovies());

        return view;
    }

    private void showSelectedMovies(Movie data) {
        Intent moveWithObject = new Intent(getContext(), MovieDetailActivity.class);
        moveWithObject.putExtra(MovieDetailActivity.EXTRA_MOVIE, data);
        startActivity(moveWithObject);
    }

    private ArrayList<Movie> getListMovies() {
        String[] judul = getResources().getStringArray(R.array.data_judul_movies);
        String[] deskripsi = getResources().getStringArray(R.array.data_deskripsi_movies);
        String[] durasi = getResources().getStringArray(R.array.data_duration_movies);
        String[] genre = getResources().getStringArray(R.array.data_genre_movies);
        String[] rating = getResources().getStringArray(R.array.data_rating_movies);
        String[] rilis = getResources().getStringArray(R.array.data_rilis_movies);
        TypedArray poster = getResources().obtainTypedArray(R.array.data_gambar_movies);

        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < judul.length; i++) {
            Movie movie = new Movie();
            movie.setGambar(poster.getResourceId(i, -1));
            movie.setJudul(judul[i]);
            movie.setDeskripsi(deskripsi[i]);
            movie.setGenre(genre[i]);
            movie.setDurasi(durasi[i]);
            movie.setRating(rating[i]);
            movie.setRilis(rilis[i]);
            movies.add(movie);
        }
        return movies;
    }

}
