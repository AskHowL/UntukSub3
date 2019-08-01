package com.example.untuksub3.Fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.untuksub3.Object.Movie;
import com.example.untuksub3.R;
import com.example.untuksub3.Adapter.RecyclerViewAdapter;
import com.example.untuksub3.ViewModel.MovieViewModel;

import java.util.ArrayList;

public class FragmentMovie extends Fragment  {

    View v;
    private RecyclerView rvMovie;
    private MovieViewModel movieViewModel;
    private RecyclerViewAdapter adapter;
    private ProgressBar progressBar;

    public FragmentMovie() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getListMovie().observe(this, getMovie);
        movieViewModel.setListMovie();

        adapter = new RecyclerViewAdapter();
        adapter.notifyDataSetChanged();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_movie,container,false);
        rvMovie = v.findViewById(R.id.recyclermovie_id);
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMovie.setAdapter(adapter);

        progressBar = v.findViewById(R.id.progressBarMovie);
        showLoading(true);
        return v;
    }

    private Observer<ArrayList<Movie>> getMovie = new Observer<ArrayList<Movie>>() {
        @Override
        public void onChanged(ArrayList<Movie> movieItems) {
            if (movieItems != null) {
                adapter.setData(movieItems);
                showLoading(false);
            }
        }
    };

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }



}
