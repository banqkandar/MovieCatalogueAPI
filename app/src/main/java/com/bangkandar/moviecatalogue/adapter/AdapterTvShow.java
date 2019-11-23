package com.bangkandar.moviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bangkandar.moviecatalogue.R;
import com.bangkandar.moviecatalogue.model.TvShow;

import java.util.ArrayList;

public class AdapterTvShow extends BaseAdapter {
    private Context context;
    private ArrayList<TvShow> tvShows;


    public void setMovies(ArrayList<TvShow> tvShows) {
        this.tvShows = tvShows;
    }

    public AdapterTvShow(Context context) {
        this.context = context;
        tvShows = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return tvShows.size();
    }

    @Override
    public Object getItem(int i) {
        return tvShows.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_tvshow, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        TvShow tvShow = (TvShow) getItem(i);
        viewHolder.bind(tvShow);
        return view;

    }

    private class ViewHolder {
        private TextView TvTitle, TvRating, TvEpisodes;
        private ImageView ImgMovie;

        ViewHolder(View itemView) {
            TvTitle = itemView.findViewById(R.id.txt_title);
            ImgMovie = itemView.findViewById(R.id.img_poster);
            TvRating = itemView.findViewById(R.id.user_score);
            TvEpisodes = itemView.findViewById(R.id.txt_episodes);
        }

        void bind(TvShow tvShow) {
            TvTitle.setText(tvShow.getJudul());
            ImgMovie.setImageResource(tvShow.getGambar());
            TvRating.setText(tvShow.getRating());
            TvEpisodes.setText(tvShow.getEpisode());
        }
    }
}
