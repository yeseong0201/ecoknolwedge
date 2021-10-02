package com.example.ecoknowledge.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.ecoknowledge.R;
import com.example.ecoknowledge.Room.AppDatabase;
import com.example.ecoknowledge.Room.User;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.text.DecimalFormat;

public class DiaryInfo extends AppCompatActivity {

    TextView title_info, content_info, date_info;
    String title, content, date, image_s;
    Bitmap b_image;
    User user;
    Uri uri_image;
    String image_uri_string;

    ImageView image_info;

    private AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_info);

        title_info = findViewById(R.id.title_info);
        content_info = findViewById(R.id.content_info);
        image_info = findViewById(R.id.imageview);


        db = AppDatabase.getInstance(this);


        title = getIntent().getStringExtra("title");


        content = getIntent().getStringExtra("content");


        uri_image = getIntent().getParcelableExtra("image_uri");
        // uri_image = Uri.parse(image_uri_string);

        image_info.setImageURI(uri_image);


        title_info.setText(title);
        content_info.setText(content);
//        date_info.setText(date);

    }
}