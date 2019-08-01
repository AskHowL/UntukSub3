package com.example.untuksub3.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.untuksub3.Object.Movie;
import com.example.untuksub3.Object.TV;
import com.example.untuksub3.R;
import com.squareup.picasso.Picasso;


public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String Extra_Movie = "extra_movie";
    public static final String Extra_TV = "extra_tv";

    TextView tvTitle;
    TextView tvDesc;
    ImageView imgPhoto;
    Button btnDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Movie selectedMovie = getIntent().getParcelableExtra(Extra_Movie);
        TV selectedTV = getIntent().getParcelableExtra(Extra_TV);

        if(selectedMovie!=null){

            tvTitle = findViewById(R.id.tv_detail_title);
            tvDesc = findViewById(R.id.tv_detail_desc);
            imgPhoto = findViewById(R.id.iv_detail_photo);


            tvTitle.setText(selectedMovie.getTitle());
            tvDesc.setText(selectedMovie.getDesc());
            Picasso.get().load(selectedMovie.getImg()).into(imgPhoto);

            setActionBarTitle("Movie Detail");
        }
        else if (selectedTV!=null){
            tvTitle = findViewById(R.id.tv_detail_title);
            tvDesc = findViewById(R.id.tv_detail_desc);
            imgPhoto = findViewById(R.id.iv_detail_photo);


            tvTitle.setText(selectedTV.getTitle());
            tvDesc.setText(selectedTV.getDesc());
            Picasso.get().load(selectedTV.getImg()).into(imgPhoto);

            setActionBarTitle("TV Detail");
        }


        btnDownload = findViewById(R.id.bt_download);
        btnDownload.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Movie selectedMovie = getIntent().getParcelableExtra(Extra_Movie);
        TV selectedTV = getIntent().getParcelableExtra(Extra_TV);
        if(selectedMovie!=null){
            Toast.makeText(DetailActivity.this, getString(R.string.download) + " " + selectedMovie.getTitle(), Toast.LENGTH_SHORT).show();

        }
        else if (selectedTV!=null) {
            Toast.makeText(DetailActivity.this, getString(R.string.download) + " " + selectedTV.getTitle(), Toast.LENGTH_SHORT).show();
        }
    }



    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
