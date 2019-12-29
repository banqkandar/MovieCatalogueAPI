package com.bangkandar.moviecatalogueapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bangkandar.moviecatalogueapi.R;
import com.bangkandar.moviecatalogueapi.model.ListMovies;

import java.util.ArrayList;
import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    private List<ListMovies> mItems;

    public AdapterHome() {
        super();
        mItems = new ArrayList<>();
        ListMovies lm = new ListMovies();
        lm.setJudul("Aladdin");
        lm.setPoster(R.drawable.poster_aladdin);
        mItems.add(lm);

        lm = new ListMovies();
        lm.setJudul("Avenger: Endgame");
        lm.setPoster(R.drawable.poster_avenger);
        mItems.add(lm);

        lm = new ListMovies();
        lm.setJudul("Aquaman");
        lm.setPoster(R.drawable.poster_aquaman);
        mItems.add(lm);

        lm = new ListMovies();
        lm.setJudul("Bohemian");
        lm.setPoster(R.drawable.poster_bohemian);
        mItems.add(lm);

        lm = new ListMovies();
        lm.setJudul("Terminator");
        lm.setPoster(R.drawable.poster_terminator);
        mItems.add(lm);
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_movies, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        ListMovies nature = mItems.get(i);
        viewHolder.judul.setText(nature.getJudul());
        viewHolder.poster.setImageResource(nature.getPoster());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView judul;
        private ImageView poster;

        private ViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.item_movie_img);
            judul = itemView.findViewById(R.id.item_movie_title);

        }
    }
}

