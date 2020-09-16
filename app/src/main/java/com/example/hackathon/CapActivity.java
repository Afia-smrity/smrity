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
import com.example.hackathon.capital.dbcap;
import com.example.hackathon.capital.questioncap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CapActivity extends AppCompatActivity {
    List<questioncap> quesList;
    int score = 0;
    int qid = 0;
    questioncap currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;
    ArrayList<questioncap> ques = new ArrayList<questioncap>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap);
        dbcap db=new dbcap(this);
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.textViewcap);
        rda = (RadioButton) findViewById(R.id.radiocap0);
        rdb = (RadioButton) findViewById(R.id.radiocap1);
        rdc = (RadioButton) findViewById(R.id.radiocap2);
        rdd = (RadioButton) findViewById(R.id.radiocap3);
        butNext = (Button) findViewById(R.id.buttoncap);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroupcap);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                grp.clearCheck();
                Log.d("youranscap", currentQ.getANSWER() + " " + answer.getText());
                if (currentQ.getANSWER().equals(answer.getText())) {
                    score++;
                    Log.d("scorecap", "Your score" + score);

                } else {
                    ques.add(new questioncap(currentQ.getQUESTION(), currentQ.getOPTA(), currentQ.getOPTB(), currentQ.getOPTC(), currentQ.getOPTD(), currentQ.getANSWER()));
                    // Log.d("lm","question"+currentQ.getQUESTION()+" "+currentQ.getANSWER());
                }
                if (qid < 10) {
                    currentQ = quesList.get(qid);
                    setQuestionView();
                } else {
                    Intent intent = new Intent(CapActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("scorecap", score);
                    intent.putExtras(b);
                    b.putSerializable("ARRAYLISTcap", (Serializable) ques);//Your score
                    //Put your score to your next Intent
                    intent.putExtra("BUNDLEcap", b);
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
