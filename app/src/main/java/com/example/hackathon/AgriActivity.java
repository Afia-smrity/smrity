package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AgriActivity extends AppCompatActivity {
    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion;

    RadioButton rda, rdb, rdc, rdd;
    Button butNext;

    ArrayList<Question>ques=new ArrayList<Question>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agri);
        /*adsLib= ChargingInstance.getAdsLib();
        adsLib.checkSubStatus(getSubCode());*/

        DbHelper db=new DbHelper(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        rdd=(RadioButton)findViewById(R.id.radio3);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                grp.clearCheck();
                Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
                if (currentQ.getANSWER().equals(answer.getText())) {
                    score++;
                    Log.d("score", "Your score" + score);

                } else {
                    ques.add(new Question(currentQ.getQUESTION(), currentQ.getOPTA(), currentQ.getOPTB(), currentQ.getOPTC(), currentQ.getOPTD(), currentQ.getANSWER()));
                    // Log.d("lm","question"+currentQ.getQUESTION()+" "+currentQ.getANSWER());
                }
                if (qid < 18) {
                    currentQ = quesList.get(qid);
                    setQuestionView();
                }
                else {
                    /*if (SP.getSubscriptionStatus()) {
                        showDialog((Activity) AgriActivity.this);
                    }
                    else

                    {*/

                        Intent intent = new Intent(AgriActivity.this, ResultActivity.class);
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
        /*public void showDialog(final Activity activity) {
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setContentView(R.layout.sub);




            final TextView textView_sub = dialog.findViewById(R.id.textView_sub);
            final TextView textView_sub1 = dialog.findViewById(R.id.textView_sub1);

            Button button_s_daily = dialog.findViewById(R.id.button_s_daily);
            Button button_s_daily_api = dialog.findViewById(R.id.button_s_daily_api);
            final Button bt_send_sms = dialog.findViewById(R.id.bt_send_sms);
            final Button submit_code = dialog.findViewById(R.id.submit_code);

            final LinearLayout ll_sub = dialog.findViewById(R.id.ll_sub);
            final LinearLayout ll_sub_1 = dialog.findViewById(R.id.ll_sub_1);
            final EditText otp_code = dialog.findViewById(R.id.otp_code);


            button_s_daily.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    textView_sub.setText("সাবস্ক্রাইব করতে আপনার মোবাইল নাম্বার দিন");
                    textView_sub1.setText("শুধুমাত্র রবি এবং এয়ারটেল গ্রাহকদের জন্য");
                    // ll_sub.setVisibility(View.VISIBLE);
                    ll_sub_1.setVisibility(View.GONE);
                    bt_send_sms.setVisibility(View.VISIBLE);
                    adsLib.subscribe();

                }
            });

            button_s_daily_api.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //call sub api
                }
            });

            bt_send_sms.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri uri = Uri.parse("smsto:21213");
                    Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                    intent.putExtra("sms_body", "start "+ ChargingInstance.MSG_TEXT);
                    activity.startActivity(intent);
                    dialog.dismiss();
                }
            });


            submit_code.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Clicked Laugh Vote", Toast.LENGTH_SHORT).show();
                    setSubCode(otp_code.getText().toString().isEmpty() ? "111111" : otp_code.getText().toString());
                    adsLib.checkSubStatus(otp_code.getText().toString().isEmpty() ? "111111" : otp_code.getText().toString());
                    dialog.dismiss();
                }
            });

            Button dialogButton = (Button) dialog.findViewById(R.id.video_ad);

            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });


            dialog.show();

        }*/
    }
