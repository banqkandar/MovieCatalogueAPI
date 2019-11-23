package com.bangkandar.moviecatalogue.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bangkandar.moviecatalogue.R;
import com.bangkandar.moviecatalogue.model.ListMovies;

import java.util.ArrayList;
import java.util.List;

public class AdapterMovies extends RecyclerView.Adapter<AdapterMovies.ViewHolder> {
    List<ListMovies> mItems;

    public AdapterMovies() {
        super();
        mItems = new ArrayList<ListMovies>();
        ListMovies lm = new ListMovies();
        lm.setJudul("Aladdin");
        lm.setPoster(R.drawable.poster_aladdin);
        mItems.add(lm);

        lm = new ListMovies();
        lm.setJudul("Alita");
        lm.setPoster(R.drawable.poster_alita);
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
        lm.setJudul("Avenger: Endgame");
        lm.setPoster(R.drawable.poster_avenger);
        mItems.add(lm);

        lm = new ListMovies();
        lm.setJudul("Creed");
        lm.setPoster(R.drawable.poster_creed);
        mItems.add(lm);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_movies, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
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
        public TextView judul;
        public ImageView poster;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.item_movie_img);
            judul = (TextView) itemView.findViewById(R.id.item_movie_title);

        }
    }
}

