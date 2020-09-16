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

import com.example.hackathon.currency.dbcurr;
import com.example.hackathon.currency.questioncurr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CurrActivity extends AppCompatActivity {
    List<questioncurr> quesList;
    int score = 0;
    int qid = 0;
    questioncurr currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;
    ArrayList<questioncurr> ques = new ArrayList<questioncurr>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curr);
        dbcurr db=new dbcurr(this);
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.textViewcurr);
        rda = (RadioButton) findViewById(R.id.radiocurr0);
        rdb = (RadioButton) findViewById(R.id.radiocurrcurr1);
        rdc = (RadioButton) findViewById(R.id.radiocurr2);
        rdd = (RadioButton) findViewById(R.id.radiocurr3);
        butNext = (Button) findViewById(R.id.buttoncurr);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroupcurr);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                grp.clearCheck();
                Log.d("youranscurr", currentQ.getANSWER() + " " + answer.getText());
                if (currentQ.getANSWER().equals(answer.getText())) {
                    score++;
                    Log.d("scorecurr", "Your score" + score);

                } else {
                    ques.add(new questioncurr(currentQ.getQUESTION(), currentQ.getOPTA(), currentQ.getOPTB(), currentQ.getOPTC(), currentQ.getOPTD(), currentQ.getANSWER()));
                    // Log.d("lm","question"+currentQ.getQUESTION()+" "+currentQ.getANSWER());
                }
                if (qid < 11) {
                    currentQ = quesList.get(qid);
                    setQuestionView();
                } else {
                    Intent intent = new Intent(CurrActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("scorecurr", score);
                    intent.putExtras(b);
                    b.putSerializable("ARRAYLISTcurr", (Serializable) ques);//Your score
                    //Put your score to your next Intent
                    intent.putExtra("BUNDLEcurr", b);
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
