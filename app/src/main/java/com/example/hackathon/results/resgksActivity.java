package com.example.hackathon.results;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hackathon.R;
import com.example.hackathon.gks.questiongks;

import java.util.ArrayList;

public class resgksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgks);
        TextView t=(TextView)findViewById(R.id.textViewResultgks);
        TextView t1=(TextView) findViewById(R.id.tvgks);
        //get score
        Bundle c = getIntent().getExtras();
        Intent intent=getIntent();
        Bundle b=intent.getBundleExtra("BUNDLEgks");
        ArrayList<questiongks> q=(ArrayList<questiongks>)b.getSerializable("ARRAYLISTgks");

        //q = (ArrayList<Question>) b.getSerializable("rs");
        int score = c.getInt("scoregks");
        t.setText("You scored " + String.valueOf(score));
        for(int i=0;i<q.size();i++)
        {
            t1.setText("\n\n"+t1.getText()+"\n\n "+q.get(i).getQUESTION()+"  "+q.get(i).getANSWER());
        }

    }
    }
