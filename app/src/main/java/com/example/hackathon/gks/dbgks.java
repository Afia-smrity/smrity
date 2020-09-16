package com.example.hackathon.gks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static com.example.hackathon.gks.quizcontractgks.MovieEntry.KEY_ANSWER;
import static com.example.hackathon.gks.quizcontractgks.MovieEntry.KEY_ID;
import static com.example.hackathon.gks.quizcontractgks.MovieEntry.KEY_OPTA;
import static com.example.hackathon.gks.quizcontractgks.MovieEntry.KEY_OPTB;
import static com.example.hackathon.gks.quizcontractgks.MovieEntry.KEY_OPTC;
import static com.example.hackathon.gks.quizcontractgks.MovieEntry.KEY_OPTD;
import static com.example.hackathon.gks.quizcontractgks.MovieEntry.KEY_QUES;
import static com.example.hackathon.gks.quizcontractgks.MovieEntry.TABLE_QUEST;

public class dbgks extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name

    private SQLiteDatabase dbase;

    public dbgks(Context context) {
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
        questiongks q1 = new questiongks("abcd", "a)ab", "b)humming bird", "c)gulls", "d) woodpecker", "b)humming bird");
        this.addQuestion(q1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + quizcontractgks.MovieEntry.TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(questiongks quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(quizcontractgks.MovieEntry.KEY_QUES, quest.getQUESTION());
        values.put(quizcontractgks.MovieEntry.KEY_ANSWER, quest.getANSWER());
        values.put(quizcontractgks.MovieEntry.KEY_OPTA, quest.getOPTA());
        values.put(quizcontractgks.MovieEntry.KEY_OPTB, quest.getOPTB());
        values.put(quizcontractgks.MovieEntry.KEY_OPTC, quest.getOPTC());
        values.put(quizcontractgks.MovieEntry.KEY_OPTD, quest.getOPTD());
        // Inserting Row
        dbase.insert(quizcontractgks.MovieEntry.TABLE_QUEST, null, values);
    }
    public List<questiongks> getAllQuestions() {
        List<questiongks> quesList = new ArrayList<questiongks>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + quizcontractgks.MovieEntry.TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                questiongks quest = new questiongks();
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
        String selectQuery = "SELECT  * FROM " + quizcontractgks.MovieEntry.TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }




}
