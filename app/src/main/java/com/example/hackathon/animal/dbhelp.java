package com.example.hackathon.animal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import java.util.ArrayList;
import java.util.List;

import static com.example.hackathon.animal.quizcontract.MovieEntry.KEY_ANSWER;
import static com.example.hackathon.animal.quizcontract.MovieEntry.KEY_ID;
import static com.example.hackathon.animal.quizcontract.MovieEntry.KEY_OPTA;
import static com.example.hackathon.animal.quizcontract.MovieEntry.KEY_OPTB;
import static com.example.hackathon.animal.quizcontract.MovieEntry.KEY_OPTC;
import static com.example.hackathon.animal.quizcontract.MovieEntry.KEY_OPTD;
import static com.example.hackathon.animal.quizcontract.MovieEntry.KEY_QUES;
import static com.example.hackathon.animal.quizcontract.MovieEntry.TABLE_QUEST;

public class dbhelp extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name

    private SQLiteDatabase dbase;

    public dbhelp(Context context) {
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
        question q1 = new question("১।কোন পাখির ডিম সবথেকে খুদ্র?", "a)হর্নবিল(hornbill)", "b)হামিং বার্ড(humming bird)", "c)গালস(gulls)", "d) উডপেকার(woodpecker)", "b)হামিং বার্ড(humming bird)");
        this.addQuestion(q1);
        question q2 = new question("২।কোন পাখির ডিম সবথেকে বড়?", "a)ভালচার(Vulture)", "b)পেচা(Owl)", "c) অস্ট্রিচ(Ostrich)", "d) ঈগল(Eagle)", "c)অস্ট্রিচ");
        this.addQuestion(q2);
        question q3 = new question("৩।সবচেয়ে ভারী সাপ কোনটি?", "a)কিং কোবরা(King kobra)", "b)জালের মত পাইথন(Reticulated python)", "c)জায়ান্ট এনাকোণ্ডা(giant anaconda)", "d)বোয়া কন্সট্রিকটর(boa constrictor)", "c)জায়ান্ট এনাকোণ্ডা(giant anaconda)");
        this.addQuestion(q3);
        question q4 = new question("স্থলভাগের সবচেয়ে লম্বা প্রাণি কোণ্টি?(which is the tallest land animal?)", "a)হাতি(elephant)", "b)জিরাফ(giraffe)", "c)গ্ণডার(Rhinoceros)", "d)মেরু ভাল্লুক(polar bear)", "b)িরাফ(giraffe)");
        this.addQuestion(q4);
        question q5 = new question("ডিম পাড়া প্রাণিদের কি বলা হয়?the egg laying animals are known as", "a)ত্রিণভোজি(herbivorous)", "b)অন্ডজ(Oviprus)", "c)মাংসাশী(carnivorous)", "d)স্রীস্রিপ(Reptiles)", "b)");
        this.addQuestion(q5);
        question q6 = new question("কোন পাখির মগজের থেকে চোখ বড়?", "a)ঈগল(Eagle)", "b) অস্ট্রিচ(ostrich)", "c)পেচা(owl)", "d)তোতা(parrot)", "b)অস্ট্রিচ(ostrich)");
        this.addQuestion(q6);
        question q7 = new question("কোনটি সরীস্রিপ?", "a)ডাইনোসর", "b)্টিক্টিকি", "c)বাদুড়", "d)সাপ", "b)্টিক্টিকি");
        this.addQuestion(q7);
        question q8 = new question("কোন প্রাণি থেকে পাশ্মিনা উল পাওয়া যায়?", "a)কালো ভেড়া", "b)হরিণ", "c)হিমালয়ান ছাগল", "d)্মেষ", "c)মালয়ান ছাগল");
        this.addQuestion(q8);
        question q9 = new question("্পাখিরা কোন প্রক্রিয়ায় তাদের পালক পরিবর্তন করে?", "a)স্খলন(shedding)", "b)অভিপ্র্যন (Migration)", "c)পরিপাটন(preening)", "d)নির্মোচন(molting)", "d)নির্মোচন(molting)");
        this.addQuestion(q9);
        question q10= new question("কোন অদ্রবণীয় প্রোটিন দিয়ে পালক গঠিত হয়", "a)ক্যালামাস(calamus)", "b)কেরাটিন(keratin)", "c)ডাউন(down)", "d)তরুণাস্থি(cartilage)", "b)কেরাটিন(keratin)");
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
    public void addQuestion(question quest) {
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
    public List<question> getAllQuestions() {
        List<question> quesList = new ArrayList<question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                question quest = new question();
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
