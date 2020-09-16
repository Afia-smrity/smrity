package com.example.hackathon.capital;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hackathon.animal.question;

import java.util.ArrayList;
import java.util.List;

import static com.example.hackathon.capital.quizcontractcap.MovieEntry.KEY_ANSWER;
import static com.example.hackathon.capital.quizcontractcap.MovieEntry.KEY_ID;
import static com.example.hackathon.capital.quizcontractcap.MovieEntry.KEY_OPTA;
import static com.example.hackathon.capital.quizcontractcap.MovieEntry.KEY_OPTB;
import static com.example.hackathon.capital.quizcontractcap.MovieEntry.KEY_OPTC;
import static com.example.hackathon.capital.quizcontractcap.MovieEntry.KEY_OPTD;
import static com.example.hackathon.capital.quizcontractcap.MovieEntry.KEY_QUES;
import static com.example.hackathon.capital.quizcontractcap.MovieEntry.TABLE_QUEST;


public class dbcap extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name

    private SQLiteDatabase dbase;

    public dbcap(Context context) {
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
        questioncap q1 = new questioncap("১।চীনের রাজধানী কোনটি?", "a)কোপেনহেগেন", "b)বেইজিং", "c)বেল্মোপান", "d)লুয়ান্ডা ", "b)বেইজিং");
        this.addQuestion(q1);
        questioncap q2 = new questioncap("২।কানাডার রাজধানী কোনটি?", "a)উন্নিপেগ", "b)ভ্যানকুভার", "c)অটোয়া", "d) জুনেও", "c)অটোয়া");
        this.addQuestion(q2);
        questioncap q3= new questioncap("৩।ব্রাজিলের রাজধানী কোনটি?", "a)ব্রাসিলিয়া", "b)বাকু", "c)বগতা", "d)বুজুম্বুরা ", "a)ব্রাসিলিয়াক");
        this.addQuestion(q3);
        questioncap q4 = new questioncap("৪।বলিভিয়ার রাজধানী কোনটি?", "a)সেন্ট জর্জ", "b)পোর্ট লুইস", "c) পোর্টো নভো", "d) সুক্রি", "d)সুক্রি");
        this.addQuestion(q4);
        questioncap q5 = new questioncap("৫।ুলগেরিয়ার রাজধানী কোনটি?", "a)সুভা", "b)সানা", "c)সোফিয়া", "d) সান জোস", "c)সোফিয়া");
        this.addQuestion(q5);
        questioncap q6 = new questioncap("৬। কাবুল কোন দেশের রাজধানী?", "a)আলবেনিয়া", "b) আফগানিস্তান", "c) আন্ডোরা", "d) আংগোলা", "b)আফগানিস্তান");
        this.addQuestion(q6);
        questioncap q7 = new questioncap("৭।কলম্বিয়ার রাজধানী কোনটি?", "a)বগতা", "b)বাকু", "c)বাগদাদ", "d) বামাকো", "a)বগতা");
        this.addQuestion(q7);
        questioncap q8 = new questioncap("৮।েনমার্কের রাজধানী কোনটি?", "a)ক্যানবেরা", "b)কাইরো", "c)চিসিনাউ", "d)কোপেনহেগেন ", "d)োপেনহেগেন ");
        this.addQuestion(q8);
        questioncap q9 = new questioncap(" ৯।সান্টিয়াগো কোন দেশের রাজধানী?", "a)চিলি", "b)সোফিয়া", "c)সিউল", "d)সানা ", "a)চিলি");
        this.addQuestion(q9);
        questioncap q10 = new questioncap("১০।কুবার রাজধানী কোনটি?", "a)ভেনকুভার", "b)হাভানা", "c)ভিয়েনা", "d) আস্তানা", "b)হাভানা");
        this.addQuestion(q10);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(questioncap quest) {
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
    public List<questioncap> getAllQuestions() {
        List<questioncap> quesList = new ArrayList<questioncap>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                questioncap quest = new questioncap();
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
