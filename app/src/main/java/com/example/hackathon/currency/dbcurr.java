package com.example.hackathon.currency;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static com.example.hackathon.currency.quizcontractcurr.MovieEntry.KEY_ANSWER;
import static com.example.hackathon.currency.quizcontractcurr.MovieEntry.KEY_ID;
import static com.example.hackathon.currency.quizcontractcurr.MovieEntry.KEY_OPTA;
import static com.example.hackathon.currency.quizcontractcurr.MovieEntry.KEY_OPTB;
import static com.example.hackathon.currency.quizcontractcurr.MovieEntry.KEY_OPTC;
import static com.example.hackathon.currency.quizcontractcurr.MovieEntry.KEY_OPTD;
import static com.example.hackathon.currency.quizcontractcurr.MovieEntry.KEY_QUES;
import static com.example.hackathon.currency.quizcontractcurr.MovieEntry.TABLE_QUEST;


public class dbcurr extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name

    private SQLiteDatabase dbase;

    public dbcurr(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT ," + KEY_OPTD + " TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }
    private void addQuestions() {
        questioncurr q1 = new questioncurr("আল্বেনিয়ার মুদ্রার নাম কি?", "a)রুবল", "b) আল্বেনিয়ান লেক", "c)স্লটি", "d)কাঞ্জা", "b)আল্বেনিয়ান লেক");
        this.addQuestion(q1);
        questioncurr q2 = new questioncurr(" আন্ডোরা সিটির মুদ্রার নাম কি?", "a) আন্ডোরান ডলার", "b) আন্ডোরান সেকেল", "c) আন্ডোরান পাউন্ড", "d) ইউরো", "d) ইউরো");
        this.addQuestion(q2);
        questioncurr q3 = new questioncurr(" আজারবাইজানের মুদ্রার নাম কি?", "a) আজারবাইজানি রুবল", "b) আজারবাইজানি ড্রাম", "c) আজারবাইজানি মানাত", "d) আজারবাইজানি ফ্লোরিন", "c)আজারবাইজানি মানাত");
        this.addQuestion(q3);
        questioncurr q4 = new questioncurr("ড্রাম কোন দেশের মুদ্রার নাম?", "a)আরমেনিয়া", "b)ক্রোয়েশিয়া", "c)ব্রাজিল", "d) বতসোয়ানা", "a)আরমেনিয়া");
        this.addQuestion(q4);
        questioncurr q5 = new questioncurr(" ইউরো কোন দেশের মুদ্রার নাম?", "a)কম্বোডিয়া", "b)স্পেন", "c) ইন্দোনেশিয়া", "d)গিনি", "b)স্পেন");
        this.addQuestion(q5);
        questioncurr q6 = new questioncurr("ক্রোয়েশিয়ার মুদ্রার নাম কি?", "a)ক্রোয়েশিয়ান গিল্ডার", "b)ক্রোয়েশিয়ান ক্রোন", "c)ক্রোয়েশিয়া্ন নাকফা", "d)ক্রোয়েশিয়ান কুনা", "d)ক্রোয়েশিয়া্ন কুনা");
        this.addQuestion(q6);
        questioncurr q7 = new questioncurr("ফিনল্যান্ডের মুদ্রার নাম কি?", "a)ক্রোনা", "b)ইউরো", "c)রুবল", "d)মারক্কা", "b) ইউরো");
        this.addQuestion(q7);
        questioncurr q8 = new questioncurr("চেক প্রজাতন্ত্রের মুদ্রার নাম কি?", "a)চেক রুবল", "b) ইউরো", "c) চেক করুনা", "d) চেক জলটি", "c) চেক করুনা");
        this.addQuestion(q8);
        questioncurr q9 = new questioncurr("ইউরোপিয়ান ইউরো কোন দেশের মুদ্রার নাম?", "a)ইরাক", "b)মিশর", "c)সিরিয়া", "d)সিপ্রাস", "d)সিপ্রাস");
        this.addQuestion(q9);
        questioncurr q10 = new questioncurr("ইউরো কোন দেশের মুদ্রার নাম?", "a) এস্তোনিয়া", "b)চিলি", "c)মিশর", "d)গাবন", "a) এস্তোনিয়া");
        this.addQuestion(q10);
        questioncurr q11 = new questioncurr("ড্যানিশ ক্রোন কোন দেশের মুদ্রার নাম", "a)এস্তোনিয়া", "b) ডেনমার্ক", "c) ফিনল্যান্ড", "d) কুয়েত", "b) ডেনমার্ক");
        this.addQuestion(q11);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + quizcontractcurr.MovieEntry.TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(questioncurr quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<questioncurr> getAllQuestions() {
        List<questioncurr> quesList = new ArrayList<questioncurr>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + quizcontractcurr.MovieEntry.TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                questioncurr quest = new questioncurr();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + quizcontractcurr.MovieEntry.TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }



}
