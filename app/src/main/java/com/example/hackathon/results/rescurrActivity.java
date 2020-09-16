package com.example.hackathon.results;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hackathon.R;
import com.example.hackathon.currency.questioncurr;

import java.util.ArrayList;

public class rescurrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescurr);
        TextView t=(TextView)findViewById(R.id.textViewResultcurr);
        TextView t1=(TextView) findViewById(R.id.tvcurr);
        //get score
        Bundle c = getIntent().getExtras();
        Intent intent=getIntent();
        Bundle b=intent.getBundleExtra("BUNDLEcurr");
        ArrayList<questioncurr> q=(ArrayList<questioncurr>)b.getSerializable("ARRAYLISTcurr");

        //q = (ArrayList<Question>) b.getSerializable("rs");
        int score = c.getInt("scorecurr");
        t.setText("You scored " + String.valueOf(score));
        for(int i=0;i<q.size();i++)
        {
            t1.setText("\n\n"+t1.getText()+"\n\n "+q.get(i).getQUESTION()+"  "+q.get(i).getANSWER());
        }

    }
    }
