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

import com.example.hackathon.gks.dbgks;
import com.example.hackathon.gks.questiongks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class gksActivity extends AppCompatActivity {
    List<questiongks> quesList;
    int score = 0;
    int qid = 0;
    questiongks currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;
    ArrayList<questiongks> ques = new ArrayList<questiongks>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gks);
        dbgks db=new dbgks(this);
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.textViewgks);
        rda = (RadioButton) findViewById(R.id.radiogks0);
        rdb = (RadioButton) findViewById(R.id.radiogks1);
        rdc = (RadioButton) findViewById(R.id.radiogks2);
        rdd = (RadioButton) findViewById(R.id.radiogks3);
        butNext = (Button) findViewById(R.id.buttongks);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroupgks);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                grp.clearCheck();
                Log.d("youransgks", currentQ.getANSWER() + " " + answer.getText());
                if (currentQ.getANSWER().equals(answer.getText())) {
                    score++;
                    Log.d("scoregks", "Your score" + score);

                } else {
                    ques.add(new questiongks(currentQ.getQUESTION(), currentQ.getOPTA(), currentQ.getOPTB(), currentQ.getOPTC(), currentQ.getOPTD(), currentQ.getANSWER()));
                    // Log.d("lm","question"+currentQ.getQUESTION()+" "+currentQ.getANSWER());
                }
                if (qid < 10) {
                    currentQ = quesList.get(qid);
                    setQuestionView();
                } else {
                    Intent intent = new Intent(gksActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("scoregks", score);
                    intent.putExtras(b);
                    b.putSerializable("ARRAYLISTgks", (Serializable) ques);//Your score
                    //Put your score to your next Intent
                    intent.putExtra("BUNDLEgks", b);
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
