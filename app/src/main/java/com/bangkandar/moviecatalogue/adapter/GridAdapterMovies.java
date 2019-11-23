package com.bangkandar.moviecatalogue.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bangkandar.moviecatalogue.R;
import com.bangkandar.moviecatalogue.model.Movie;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GridAdapterMovies extends RecyclerView.Adapter<GridAdapterMovies.GridViewHolder> {
    private final ArrayList<Movie> listMovie;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public GridAdapterMovies(ArrayList<Movie> list) {
        this.listMovie = list;
    }

    public GridAdapterMovies(ArrayList<Movie> listMovie, OnItemClickCallback onItemClickCallback) {
        this.listMovie = listMovie;
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public GridAdapterMovies.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_movies, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridAdapterMovies.GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listMovie.get(position).getGambar())
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listMovie.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgPhoto;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Movie data);
    }
}
