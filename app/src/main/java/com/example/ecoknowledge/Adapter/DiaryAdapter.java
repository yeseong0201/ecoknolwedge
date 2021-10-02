package com.example.ecoknowledge.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ecoknowledge.Activitys.DiaryInfo;
import com.example.ecoknowledge.Activitys.MainActivity;
import com.example.ecoknowledge.R;
import com.example.ecoknowledge.Room.User;
import com.example.ecoknowledge.Room.AppDatabase;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.MyViewHolder> {

    private Context context;


    private ArrayList<User> userData = new ArrayList<>();


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diary_list, parent, false);
        context = parent.getContext();
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(userData.get(position), position);
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public void addItem(User user) {
        userData.add(user);
        notifyDataSetChanged();
    }

    public void addItems(ArrayList<User> users) {
        userData = users;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView key;
        private TextView title;
        private TextView date;
        private ImageView image;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            key = itemView.findViewById(R.id.key);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.image);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void onBind(User user, int position) {
            String s = "" + (position + 1);

            String image_b;
            Bitmap b_image;
            String content;
            Uri image_uri;

            content = user.getContent();

            key.setText(s);
            title.setText(user.getTitle());
            date.setText(user.getDate());

            image_b = user.getImage();

            b_image = StringToBitmap(image_b);

            image.setImageBitmap(b_image);


            image_uri = getImageUri(context, b_image);

            itemView.setOnLongClickListener(v -> {

                //super.onBackPressed();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                //Setting message manually and performing action on button click
                builder.setMessage("일기를 지우시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("네", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Toast.makeText(v.getContext(), "일기가 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                                userData.remove(user);
                                AppDatabase.getInstance(itemView.getContext()).userDao().delete(user);

                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();

                alert.show();

                return false;
            });

            itemView.setOnClickListener(v -> {


                Intent intent = new Intent(itemView.getContext(), DiaryInfo.class);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                b_image.compress(Bitmap.CompressFormat.JPEG, 20, stream);
                byte[] byteArray = stream.toByteArray();

                // intent.putExtra("image", byteArray);

                intent.putExtra("image_uri", image_uri);


                //  intent.putExtra("image_uri",)
                //   intent.putExtra("image_bitmap", image_uri);


                intent.putExtra("title", title.getText().toString());
                intent.putExtra("content", content);
                itemView.getContext().startActivity(intent);

            });
        }
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

    private Uri getImageUri(Context context, Bitmap inImage) {

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 60, bytes);

        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);

    }

    public static String BitmapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        byte[] bytes = baos.toByteArray();
        String temp = Base64.encodeToString(bytes, Base64.DEFAULT);
        return temp;
    }

    // 비트맵 크기 줄여줌
    private Bitmap getResizedBitmap(Bitmap bitmap, int maxHeight) {

        double ratio = bitmap.getHeight() / (double) maxHeight;
        int width = (int) (bitmap.getWidth() / ratio);
        return Bitmap.createScaledBitmap(bitmap, width, maxHeight, false);

    }

}
