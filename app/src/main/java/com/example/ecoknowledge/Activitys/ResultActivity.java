package com.example.ecoknowledge.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.ecoknowledge.DBHelper.DBHelpers;
import com.example.ecoknowledge.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    int score = 0, scoreOS = 0, scoreCOMPFUNDA = 0, scoreHARDWARE = 0, scoreRandom = 0;
    DBHelpers dbHelper = new DBHelpers(ResultActivity.this);
    Button btnWrongQstns;

    private ProgressBar progressBar;

    public ArrayList<String> wrongQuests = new ArrayList<String>();
    public ArrayList<String> selectedAnswers = new ArrayList<String>();
    public ArrayList<String> actualAnswers = new ArrayList<String>();

    private ImageView img;
    private TextView tvPerc;
    String tableName = "", catName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        progressBar = findViewById(R.id.cpb);
        btnWrongQstns = findViewById(R.id.btnWrongQstns);
        TextView txtCorrectAns = findViewById(R.id.txtCorrectAns);
        //get score
        final Bundle b = getIntent().getExtras();

        if (b.containsKey("scoreOS")) {
            scoreOS = b.getInt("scoreOS");
            tableName = b.getString("section");
            catName = b.getString("category");
            // dbHelper.insertScoreOS(scoreOS,tableName,catName);
            score = scoreOS;
        }

        progressBar.setMax(100);

        progressBar.setProgress(score * 10);

        txtCorrectAns.setText("총 문제 : 10" + "\n" + "맞은 문제 : " + score + "\n틀린 문제 : " + (10 - score));

        wrongQuests = getIntent().getStringArrayListExtra("wrongQuestions");
        selectedAnswers = getIntent().getStringArrayListExtra("selectedAnswer");
        actualAnswers = getIntent().getStringArrayListExtra("actualAnswer");

        double perc = score * 10.0;
        DecimalFormat df = new DecimalFormat("##.###");
        tvPerc =  findViewById(R.id.tvPerc);
        tvPerc.setText("" + df.format(perc) + " %");

        btnWrongQstns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, WrongQuestion.class);
                //Bundle b = new Bundle();
                intent.putStringArrayListExtra("wrongQuestions", wrongQuests);
                intent.putStringArrayListExtra("selectedAnswer", selectedAnswers);
                intent.putStringArrayListExtra("actualAnswer", actualAnswers);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
