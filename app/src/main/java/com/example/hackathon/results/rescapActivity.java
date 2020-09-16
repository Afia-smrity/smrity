package com.example.hackathon.results;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hackathon.R;
import com.example.hackathon.capital.questioncap;

import java.util.ArrayList;

public class rescapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rescap);
        TextView t=(TextView)findViewById(R.id.textViewResultcap);
        TextView t1=(TextView) findViewById(R.id.tvcap);
        //get score
        Bundle c = getIntent().getExtras();
        Intent intent=getIntent();
        Bundle b=intent.getBundleExtra("BUNDLEcap");
        ArrayList<questioncap> q=(ArrayList<questioncap>)b.getSerializable("ARRAYLISTcap");

        //q = (ArrayList<Question>) b.getSerializable("rs");
        int score = c.getInt("scorecap");
        t.setText("You scored " + String.valueOf(score));
        for(int i=0;i<q.size();i++)
        {
            t1.setText("\n\n"+t1.getText()+"\n\n "+q.get(i).getQUESTION()+"  "+q.get(i).getANSWER());
        }

    }
}