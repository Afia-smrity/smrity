package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.hackathon.animal.dbhelp;
import com.example.hackathon.animal.question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AnimalActivity extends AppCompatActivity {
    List<question> quesList;
    int score = 0;
    int qid = 0;
    question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;
    ArrayList<question> ques = new ArrayList<question>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        // db = new DbHelper(this);
        dbhelp dbanim=new dbhelp(this);
        quesList = dbanim.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.textViewanim);
        rda = (RadioButton) findViewById(R.id.radioanim0);
        rdb = (RadioButton) findViewById(R.id.radioanim1);
        rdc = (RadioButton) findViewById(R.id.radioanim2);
        rdd = (RadioButton) findViewById(R.id.radioanim3);
        butNext = (Button) findViewById(R.id.buttonanim);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroupanim);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                grp.clearCheck();
                Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
                if (currentQ.getANSWER().equals(answer.getText())) {
                    score++;
                    Log.d("score", "Your score" + score);

                } else {
                    ques.add(new question(currentQ.getQUESTION(), currentQ.getOPTA(), currentQ.getOPTB(), currentQ.getOPTC(), currentQ.getOPTD(), currentQ.getANSWER()));
                    // Log.d("lm","question"+currentQ.getQUESTION()+" "+currentQ.getANSWER());
                }
                if (qid < 10) {
                    currentQ = quesList.get(qid);
                    setQuestionView();
                } else {
                    Intent intent = new Intent(AnimalActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score);
                    intent.putExtras(b);
                    b.putSerializable("ARRAYLIST", (Serializable) ques);//Your score
                    //Put your score to your next Intent
                    intent.putExtra("BUNDLE", b);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        rdd.setText(currentQ.getOPTD());
        qid++;
    }
    }
