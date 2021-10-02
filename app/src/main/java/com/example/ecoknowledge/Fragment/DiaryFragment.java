package com.example.ecoknowledge.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecoknowledge.Adapter.DiaryAdapter;
import com.example.ecoknowledge.Activitys.DiaryWrite;
import com.example.ecoknowledge.Activitys.MainActivity;
import com.example.ecoknowledge.R;
import com.example.ecoknowledge.Room.AppDatabase;
import com.example.ecoknowledge.Room.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DiaryFragment extends Fragment {

    private ArrayList<User> userData = new ArrayList<>();


    FloatingActionButton fab;
    RecyclerView recyclerView;

    DiaryAdapter diaryAdapter;

    private List<User> users;

    RecyclerView.LayoutManager layoutManager;

    MainActivity mainActivity = (MainActivity) getActivity();


    public DiaryFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_diary, container, false);

        fab = v.findViewById(R.id.fab);

        fab.show();


        recyclerView = v.findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(mainActivity);

        recyclerView.setLayoutManager(layoutManager);

        diaryAdapter = new DiaryAdapter();

        recyclerView.setAdapter(diaryAdapter);

        diaryAdapter.notifyDataSetChanged();

        users = AppDatabase.getInstance(getContext()).userDao().getAll();


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                fab.show();
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                fab.hide();
            }
        });

        int size = users.size();
        for (int i = 0; i < size; i++) {
            diaryAdapter.addItem(users.get(i));
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move();
            }
        });

        // cardList.size();


        return v;
    }


    private void move() {
        Intent intent = new Intent(getContext(), DiaryWrite.class);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        users = AppDatabase.getInstance(getContext()).userDao().getAll();
        diaryAdapter.addItems((ArrayList) users);
        super.onStart();
    }


}