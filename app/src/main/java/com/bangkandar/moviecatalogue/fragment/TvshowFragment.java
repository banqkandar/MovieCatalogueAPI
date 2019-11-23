package com.bangkandar.moviecatalogue.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.bangkandar.moviecatalogue.R;
import com.bangkandar.moviecatalogue.TvShowDetailActivity;
import com.bangkandar.moviecatalogue.adapter.AdapterTvShow;
import com.bangkandar.moviecatalogue.model.TvShow;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvshowFragment extends Fragment {
    private String[] dataJudul, dataDeskripsi, dataGenre, dataRilis, dataDurasi, dataRating, dataEpisode;
    private TypedArray dataGambar;
    private AdapterTvShow adapter;

    public TvshowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tvshow, container, false);
        adapter = new AdapterTvShow(getContext());
        ListView listView = view.findViewById(R.id.lv_movie);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveWithObject = new Intent(getContext(), TvShowDetailActivity.class);

                moveWithObject.putExtra(TvShowDetailActivity.EXTRA_MOVIE, (TvShow) adapterView.getItemAtPosition(i));
                startActivity(moveWithObject);
            }
        });
        return view;
    }

    private void addItem() {

        ArrayList<TvShow> tvShows = new ArrayList<>();

        for (int i = 0; i < dataJudul.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setGambar(dataGambar.getResourceId(i, -1));
            tvShow.setJudul(dataJudul[i]);
            tvShow.setDeskripsi(dataDeskripsi[i]);
            tvShow.setGenre(dataGenre[i]);
            tvShow.setDurasi(dataDurasi[i]);
            tvShow.setRilis(dataRilis[i]);
            tvShow.setRating(dataRating[i]);
            tvShow.setEpisode(dataEpisode[i]);
            tvShows.add(tvShow);
        }
        adapter.setMovies(tvShows);
    }

    private void prepare() {
        dataJudul = getResources().getStringArray(R.array.data_judul_tvshow);
        dataDeskripsi = getResources().getStringArray(R.array.data_desk_tvshow);
        dataDurasi = getResources().getStringArray(R.array.data_duration_tvshow);
        dataGenre = getResources().getStringArray(R.array.data_genre_tvshow);
        dataRating = getResources().getStringArray(R.array.data_rating_tvshow);
        dataRilis = getResources().getStringArray(R.array.data_tahun_tvshow);
        dataEpisode = getResources().getStringArray(R.array.data_episodes_tvshow);
        dataGambar = getResources().obtainTypedArray(R.array.data_gambar_tvshow);
    }
}
