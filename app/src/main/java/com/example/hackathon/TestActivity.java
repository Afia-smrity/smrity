package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView AgCardView,AnimCardView,currCardView,humCardView,gksCardView,capCardView,wonCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        AgCardView=findViewById(R.id.cardViewAg);
        gksCardView=findViewById(R.id.gks);
        AnimCardView=findViewById(R.id.animal);
        currCardView=findViewById(R.id.currency);
        humCardView=findViewById(R.id.humanbody);
        capCardView=findViewById(R.id.cap);
        wonCardView=findViewById(R.id.wonder);
       AgCardView.setOnClickListener(this);
        gksCardView.setOnClickListener(this);
        AnimCardView.setOnClickListener(this);
        currCardView.setOnClickListener(this);
        humCardView.setOnClickListener(this);
        capCardView.setOnClickListener(this);
        wonCardView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.cardViewAg)
        {
            Intent i=new Intent(TestActivity.this,AgriActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.animal)
        {
            Intent i=new Intent(TestActivity.this,AnimalActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.wonder)
        {
            Intent i=new Intent(TestActivity.this,wonderActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.currency)
        {
            Intent i=new Intent(TestActivity.this,CurrActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.cap)
        {
            Intent i=new Intent(TestActivity.this, CapActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.gks)
        {
            Intent i=new Intent(TestActivity.this,gksActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.humanbody)
        {
            Intent i=new Intent(TestActivity.this,humActivity.class);
            startActivity(i);
        }

    }
}