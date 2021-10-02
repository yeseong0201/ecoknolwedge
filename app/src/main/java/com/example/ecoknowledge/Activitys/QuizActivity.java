package com.example.ecoknowledge.Activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ecoknowledge.DBHelper.DBHelpers;
import com.example.ecoknowledge.QuestionOS;
import com.example.ecoknowledge.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class QuizActivity extends AppCompatActivity {

    List<QuestionOS> quesList1;
    public int score = 0;
    int ctr1 = 1;
    QuestionOS currentQ1;
    TextView txtQuestion1;
    RadioGroup grp;
    RadioButton rda1, rdb1, rdc1, rdd1;
    Button butNext1;
    Random random1 = new Random();
    ArrayList<Integer> list = new ArrayList<Integer>();
    TextView textViewTime1;
    public ArrayList<String> wrongQuestListOS = new ArrayList<String>();
    public ArrayList<String> selectedAnsOS = new ArrayList<String>();
    public ArrayList<String> actualAnswerOS = new ArrayList<String>();
    int number;
    ProgressBar progressBar;
    int progress = 1;
    String tableName = "", catName = "";
    TextView qstnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        qstnNo = findViewById(R.id.qstnNo);


        number = 0;
        DBHelpers db = new DBHelpers(this);
        textViewTime1 = findViewById(R.id.textViewTime);
        final CounterClass timer = new CounterClass(600000, 1000);
        timer.start();
        quesList1 = db.getAllQuestions("questOS");

        for (int i = 1; i <= 61; i++) {
            while (true) {
                int next = random1.nextInt(61);
                if (!list.contains(next)) {
                    list.add(next);
                    break;
                }
            }
        }
        Log.d("ListSize check", "" + quesList1.size());
        // currentQ1 = quesList1.get(list.get(1));
        currentQ1 = quesList1.get(list.get(0));

        txtQuestion1 = findViewById(R.id.textView1);
        rda1 = findViewById(R.id.radio0);
        rdb1 = findViewById(R.id.radio1);
        rdc1 = findViewById(R.id.radio2);
        rdd1 = findViewById(R.id.radio3);
        butNext1 = findViewById(R.id.button1);
        setQuestionView();
        grp = findViewById(R.id.radioGroup1);
        butNext1.setEnabled(false);
        grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio0 || i == R.id.radio1 || i == R.id.radio2 || i == R.id.radio3)
                    butNext1.setEnabled(true);
            }
        });
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(10);
        progressBar.setProgress(score);
        butNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress = progress + 1;
                progressBar.setProgress(progress);
                RadioButton answer = findViewById(grp.getCheckedRadioButtonId());

                if (currentQ1.getANSWER().equals(answer.getText())) {
                    score++;

                } else {
                    wrongQuestListOS.add(number, currentQ1.getQUESTION());
                    selectedAnsOS.add(number, answer.getText().toString());
                    actualAnswerOS.add(number, currentQ1.getANSWER());
                    number++;
                }
                grp.clearCheck();
                butNext1.setEnabled(false);
                if (ctr1 < 11) {
                    if (ctr1 == 10) {
                        butNext1.setText("퀴즈 제출");
                    }
                    currentQ1 = quesList1.get(list.get(ctr1));
                    setQuestionView();
                } else {
                    timer.onFinish();
                    timer.cancel();
                }
            }
        });
    }

    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            textViewTime1.setText(hms);
        }

        @Override
        public void onFinish() {
            showResult();
        }
    }

    public void showResult() {
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        Bundle b = new Bundle();
        b.putInt("scoreOS", score);//Your score
        b.putString("section", tableName);//Your table name
        b.putString("category", catName);//Your category name
        intent.putStringArrayListExtra("wrongQuestions", wrongQuestListOS);
        intent.putStringArrayListExtra("selectedAnswer", selectedAnsOS);
        intent.putStringArrayListExtra("actualAnswer", actualAnswerOS);
        intent.putExtras(b); //Put your score to your next Intent
        startActivity(intent);
        finish();
    }

    private void setQuestionView() {
        txtQuestion1.setText(currentQ1.getQUESTION());
        rda1.setText(currentQ1.getOPTA());
        rdb1.setText(currentQ1.getOPTB());
        rdc1.setText(currentQ1.getOPTC());
        rdd1.setText(currentQ1.getOPTD());
        if (ctr1 < 10)
            qstnNo.setText("0" + ctr1 + "/10");
        else
            qstnNo.setText("" + ctr1 + "/10");
        ctr1++;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("아직 퀴즈를 다 풀지 못했어요. \n그만하시겠습니까?")
                .setCancelable(false)
                .setPositiveButton("그만하기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("계속하기", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });


        AlertDialog alert = builder.create();
        alert.show();
    }

}
