package com.bangkandar.moviecatalogueapi.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bangkandar.moviecatalogueapi.R;
import com.bangkandar.moviecatalogueapi.adapter.AdapterHome;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView rvMovieList = view.findViewById(R.id.list_movies);
        LinearLayoutManager lmMovieList = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvMovieList.setLayoutManager(lmMovieList);
        AdapterHome aMovieList = new AdapterHome();
        rvMovieList.setAdapter(aMovieList);

        TextView textView = view.findViewById(R.id.movies);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager() != null) {
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new MoviesFragment()).commit();
                }
            }
        });
        return view;

    }

}
