package com.example.untuksub3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.untuksub3.Activity.DetailActivity;
import com.example.untuksub3.Object.Movie;
import com.example.untuksub3.Object.TV;
import com.example.untuksub3.R;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ArrayList<Movie> mData = new ArrayList<>();


    public void setData(ArrayList<Movie> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)  {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int i) {

        holder.bind(mData.get(i));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(v.getContext(), DetailActivity.class);
                //mengirimkan data yang dipilih dengan identitas Extra_Movie
                x.putExtra(DetailActivity.Extra_Movie, mData.get(i));
                v.getContext().startActivity(x);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder   {
        private TextView tv_title, tv_desc;
        private ImageView iv_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title_movie);
            tv_desc = itemView.findViewById(R.id.tv_desc_movie);
            iv_img = itemView.findViewById(R.id.img_movie);

        }

        void bind(Movie movie) {
            tv_title.setText(movie.getTitle());
            tv_desc.setText(movie.getDesc());
            Picasso.get().load(movie.getImg()).into(iv_img);

        }
    }




}
