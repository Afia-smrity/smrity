package com.example.hackathon.results;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.hackathon.R;
import com.example.hackathon.animal.question;

import java.util.ArrayList;

public class resanimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resanim);
        TextView t=(TextView)findViewById(R.id.textViewResultanim);
        TextView t1=(TextView) findViewById(R.id.tvanim);
        //get score
        Bundle d= getIntent().getExtras();
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("BUNDLE");
        ArrayList<question> q=(ArrayList<question>)bundle.getSerializable("ARRAYLIST");

        //q = (ArrayList<Question>) b.getSerializable("rs");
        int score = d.getInt("score");
        t.setText("You scored " + String.valueOf(score));
        for(int i=0;i<q.size();i++)
        {
            t1.setText("\n\n"+t1.getText()+"\n\n "+q.get(i).getQUESTION()+"  "+q.get(i).getANSWER());
        }

    }
}