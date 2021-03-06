package com.example.ecoknowledge.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ecoknowledge.Fragment.DiaryFragment;
import com.example.ecoknowledge.Fragment.EcomentFragment;
import com.example.ecoknowledge.Fragment.MediaFragment;
import com.example.ecoknowledge.Fragment.QuizFragment;
import com.example.ecoknowledge.FragmentUtils;
import com.example.ecoknowledge.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment> fragments = new ArrayList<>();

    BottomNavigationView bottomNavigationView;

    FragmentUtils fragmentUtils;

    DiaryFragment diaryFragment;
    QuizFragment quizFragment;
    MediaFragment mediaFragment;
    EcomentFragment ecomentFragment;

    String[] permission_list = {
            Manifest.permission.INTERNET,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission();


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        diaryFragment = new DiaryFragment();
        quizFragment = new QuizFragment();
        mediaFragment = new MediaFragment();
        ecomentFragment = new EcomentFragment();

        fragments.add(diaryFragment);
        fragments.add(quizFragment);
        fragments.add(mediaFragment);
        fragments.add(ecomentFragment);

        fragmentUtils = new FragmentUtils(R.id.framelayout, fragments);
        fragmentUtils.setCurrentFragmentByPosition(getSupportFragmentManager(), 0, new Bundle());
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.bottom_diary:
                        fragmentUtils.setCurrentFragmentByPosition(getSupportFragmentManager(), 0, new Bundle());
                        return true;
                    case R.id.bottom_quiz:
                        fragmentUtils.setCurrentFragmentByPosition(getSupportFragmentManager(), 1, new Bundle());
                        return true;
                    case R.id.bottom_media:
                        fragmentUtils.setCurrentFragmentByPosition(getSupportFragmentManager(), 2, new Bundle());
                        return true;
                    case R.id.bottom_grade:
                        fragmentUtils.setCurrentFragmentByPosition(getSupportFragmentManager(), 3, new Bundle());
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {

        //super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Setting message manually and performing action on button click
        builder.setMessage("?????????????????? ????????????????")
                .setCancelable(false)
                .setPositiveButton("???", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("?????????", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();

        alert.setTitle("??????????????? \uD83C\uDF31");
        alert.show();
    }


    public void checkPermission() {
        //?????? ??????????????? ????????? 6.0???????????? ???????????? ????????????.
        //???????????????6.0 (????????????) ?????? ???????????? ?????? ???????????? ??????
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return;

        for (String permission : permission_list) {
            //?????? ?????? ????????? ????????????.
            int chk = checkCallingOrSelfPermission(permission);

            if (chk == PackageManager.PERMISSION_DENIED) {
                //?????? ?????????????????? ???????????? ?????? ?????????
                requestPermissions(permission_list, 0);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0) {
            for (int i = 0; i < grantResults.length; i++) {
                //???????????????
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    //????????? ???????????? ???????????? ???????????? ??? ??????
                    Toast.makeText(getApplicationContext(), "??? ?????? ????????? ??????????????????", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        }
    }

}
