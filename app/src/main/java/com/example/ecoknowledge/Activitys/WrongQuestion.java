package com.example.ecoknowledge.Activitys;

import android.os.Bundle;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoknowledge.Activitys.ResultActivity;
import com.example.ecoknowledge.Adapter.ListAdapter;
import com.example.ecoknowledge.ListModel;
import com.example.ecoknowledge.R;

import java.util.ArrayList;

public class WrongQuestion extends AppCompatActivity {

    public ArrayList<String> wrongQuests = new ArrayList<String>();
    public ArrayList<String> selectedAnswers = new ArrayList<String>();
    public ArrayList<String> actualAnswers = new ArrayList<String>();

    private ArrayList<ListModel> m_parts = new ArrayList<>();

    ListView listView;

    ResultActivity resultActivity = new ResultActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_question);

        listView = (ListView) findViewById(R.id.listView1);

        wrongQuests = resultActivity.wrongQuests;
        selectedAnswers = resultActivity.selectedAnswers;
        actualAnswers = resultActivity.actualAnswers;

        /*Object[] objQstn = wrongQuests.toArray();
        Object[] objsAns = selectedAnswers.toArray();
        Object[] objaAns = actualAnswers.toArray();

        String[] strQstn = Arrays.copyOf(objQstn, objQstn.length, String[].class);
        String[] strsAns = Arrays.copyOf(objsAns, objQstn.length, String[].class);
        String[] straAns = Arrays.copyOf(objaAns, objQstn.length, String[].class);*/

        wrongQuests = getIntent().getStringArrayListExtra("wrongQuestions");
        selectedAnswers = getIntent().getStringArrayListExtra("selectedAnswer");
        actualAnswers = getIntent().getStringArrayListExtra("actualAnswer");

        String[] strQstn = new String[wrongQuests.size()];
        String[] strsAns = new String[selectedAnswers.size()];
        String[] straAns = new String[actualAnswers.size()];

        strQstn = wrongQuests.toArray(strQstn);
        strsAns = selectedAnswers.toArray(strsAns);
        straAns = actualAnswers.toArray(straAns);


        for(int i=0; i<strQstn.length;i++) {
            m_parts.add(new ListModel(strQstn[i], strsAns[i],straAns[i]));
        }

        ListAdapter listAdapter = new ListAdapter(this, R.layout.list_row, m_parts);
        listView.setAdapter(listAdapter);
    }

}