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
import com.example.hackathon.hum.dbhum;
import com.example.hackathon.hum.questionhum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class humActivity extends AppCompatActivity {
    List<questionhum> quesList;
    int score = 0;
    int qid = 0;
    questionhum currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;
    ArrayList<questionhum> ques = new ArrayList<questionhum>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hum);
        dbhum db=new dbhum(this);
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.textViewhum);
        rda = (RadioButton) findViewById(R.id.radiohum0);
        rdb = (RadioButton) findViewById(R.id.radiohum1);
        rdc = (RadioButton) findViewById(R.id.radiohum2);
        rdd = (RadioButton) findViewById(R.id.radiohum3);
        butNext = (Button) findViewById(R.id.buttonhum);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGrouphum);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                grp.clearCheck();
                Log.d("youranshum", currentQ.getANSWER() + " " + answer.getText());
                if (currentQ.getANSWER().equals(answer.getText())) {
                    score++;
                    Log.d("scorehum", "Your score" + score);

                } else {
                    ques.add(new questionhum(currentQ.getQUESTION(), currentQ.getOPTA(), currentQ.getOPTB(), currentQ.getOPTC(), currentQ.getOPTD(), currentQ.getANSWER()));
                    // Log.d("lm","question"+currentQ.getQUESTION()+" "+currentQ.getANSWER());
                }
                if (qid < 10) {
                    currentQ = quesList.get(qid);
                    setQuestionView();
                } else {
                    Intent intent = new Intent(humActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("scorehum", score);
                    intent.putExtras(b);
                    b.putSerializable("ARRAYLISThum", (Serializable) ques);//Your score
                    //Put your score to your next Intent
                    intent.putExtra("BUNDLEhum", b);
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
