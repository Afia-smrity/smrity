package com.example.hackathon.hum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static com.example.hackathon.hum.quizcontracthum.MovieEntry.KEY_ANSWER;
import static com.example.hackathon.hum.quizcontracthum.MovieEntry.KEY_ID;
import static com.example.hackathon.hum.quizcontracthum.MovieEntry.KEY_OPTA;
import static com.example.hackathon.hum.quizcontracthum.MovieEntry.KEY_OPTB;
import static com.example.hackathon.hum.quizcontracthum.MovieEntry.KEY_OPTC;
import static com.example.hackathon.hum.quizcontracthum.MovieEntry.KEY_OPTD;
import static com.example.hackathon.hum.quizcontracthum.MovieEntry.KEY_QUES;
import static com.example.hackathon.hum.quizcontracthum.MovieEntry.TABLE_QUEST;


public class dbhum extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name

    private SQLiteDatabase dbase;

    public dbhum(Context context) {
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
        questionhum q1 = new questionhum("১।কোন পাখির ডিম সবথেকে খুদ্র?", "a)হর্নবিল(hornbill)", "b)হামিং বার্ড(humming bird)", "c)গালস(gulls)", "d) উডপেকার(woodpecker)", "b)হামিং বার্ড(humming bird)");
        this.addQuestion(q1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(questionhum quest) {
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
    public List<questionhum> getAllQuestions() {
        List<questionhum> quesList = new ArrayList<questionhum>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                questionhum quest = new questionhum();
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
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }

}
