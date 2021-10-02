package com.example.ecoknowledge.Adapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecoknowledge.MediaItem;
import com.example.ecoknowledge.Activitys.NewsInfo;
import com.example.ecoknowledge.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.ViewHolder> {

    //데이터 배열 선언
    private ArrayList<MediaItem> mList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_news;
        private TextView title_news, content_news;
        String link_news;
        private String media_src;

        public ViewHolder(View itemView) {
            super(itemView);

            image_news = itemView.findViewById(R.id.image_media);
            title_news = itemView.findViewById(R.id.title_media);
            content_news = itemView.findViewById(R.id.content_media);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (link_news.length() != 0) {
                        Intent intent = new Intent(itemView.getContext(), NewsInfo.class);
                        intent.putExtra("news_link", link_news);
                        itemView.getContext().startActivity(intent);

                    }
                }
            });


        }
    }

    //생성자
    public MediaAdapter(ArrayList<MediaItem> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public MediaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_list, parent, false);


        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MediaAdapter.ViewHolder holder, int position) {

        holder.title_news.setText(String.valueOf(mList.get(position).getTitle_news()));
        holder.content_news.setText(String.valueOf(mList.get(position).getContent_news()));

        Glide.with(holder.itemView).load(mList.get(position).getImg_news())
                .override(300, 400)
                .into(holder.image_news);

        holder.link_news = mList.get(position).getLink_news();


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    /*
     * String형을 BitMap으로 변환시켜주는 함수
     * */
    public static Bitmap StringToBitmap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /*
     * Bitmap을 String형으로 변환
     * */
    public static String BitmapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 70, baos);
        byte[] bytes = baos.toByteArray();
        String temp = Base64.encodeToString(bytes, Base64.DEFAULT);
        return temp;
    }

    private Bitmap getResizedBitmap(Bitmap bitmap, int maxHeight) {
        double ratio = bitmap.getHeight() / (double) maxHeight;
        int width = (int) (bitmap.getWidth() / ratio);
        return Bitmap.createScaledBitmap(bitmap, width, maxHeight, false);
    }
}
