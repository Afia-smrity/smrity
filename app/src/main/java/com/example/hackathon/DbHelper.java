package com.example.hackathon;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.hackathon.QuizContract.MovieEntry.KEY_ANSWER;
import static com.example.hackathon.QuizContract.MovieEntry.KEY_ID;
import static com.example.hackathon.QuizContract.MovieEntry.KEY_OPTA;
import static com.example.hackathon.QuizContract.MovieEntry.KEY_OPTB;
import static com.example.hackathon.QuizContract.MovieEntry.KEY_OPTC;
import static com.example.hackathon.QuizContract.MovieEntry.KEY_OPTD;
import static com.example.hackathon.QuizContract.MovieEntry.KEY_QUES;
import static com.example.hackathon.QuizContract.MovieEntry.TABLE_QUEST;


public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name

    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT ,"+KEY_OPTD+" TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }
    private void addQuestions()
    {
        Question q1=new Question("১. প্রশ্ন : বাংলাদেশের সবচেয়ে বড় সেচ প্রকল্প কোনটি?", "a)্পদ্মা বাধ প্রকল্পা ", "b)তিস্তা বাধ প্রকল্প।", "c)গড়াই বাধ প্রকল্প।", "d)মেঘ্না প্রকল্প।", "b)তিস্তা বাধ প্রকল্প।");
        this.addQuestion(q1);
        Question q2=new Question("২. প্রশ্ন : বাংলাদেশে ধান গবেষণা কেন্দ্রের সংক্ষিপ্ত নাম কী?","a)BADC","b)BURO","c)BRRI","d)BARI","c) BRRI");
        this.addQuestion(q2);
        Question q3=new Question("৩।জুটন আবিস্কার করেন কে?","a)ড. মোহাম্মদ সিদ্দিকুল্লাহ।","b)ডঃ মাক্সুমুল আলম","c)ডঃ মোহাম্মদ শহীদুল্লাহ","d)ডঃআলিমুল হক","a)ড. মোহাম্মদ সিদ্দিকুল্লাহ।" );
        this.addQuestion(q3);
        Question q4=new Question("৪।প্রশ্ন : বাংলাদেশে মাথাপিছু আবাদী জমির পরিমাণ কত একর?","a)০.৩","b.০.২","c)০.১","d.০.১৪","d)০.১৪");
        this.addQuestion(q4);
        Question q5=new Question("৫। বাংলাদেশ কৃষি গবেষণা ইনস্টিটিউট কবে প্রতিষ্ঠিত হয়?","a)১৯৬৯","b.১৯৭১","c)১৯৭৩","d)১৯৭২","b)১৯৭১");
        this.addQuestion(q5);
        Question q6=new Question("৬। প্রশ্ন : বাংলাদেশে চাষের অযোগ্য জমির পরিমাণ কত?","a)২০,১৩,২২২ একর। ","b)২৫,১৩,২২২ একর। ","c)২৭,১৩,২২২ একর। ","d)২৭,১৩,২২৫ একর। ","c)২৭,১৩,২২২ একর। ");
        this.addQuestion(q6);
        Question q7=new Question("৭।প্রশ্ন : সরকার কৃষকের স্বার্থে কোন সার আমদানী নিষিদ্ধ করেছে?","a)এসএসপি","b)টিএসপি","c)ফসফেট","d)পটাশ","a) এসএসপি");
        this.addQuestion(q7);
        Question q8=new Question("৮।প্রশ্ন : বাংলাদেশের মোট কৃষি জমির পরিমাণ কত?","a)২,০৩,৮৪,৫৬১ একর।","b)২,০৪,৮৪,৫৬১ একর।","c)১,০৪,৮৪,৫৬১ একর।","d)২,০৪,৮৫,৫৬১ একর।","b)২,০৪,৮৪,৫৬১ একর।");
        this.addQuestion(q8);
        Question q9=new Question("৯।প্রশ্ন : বাংলাদেশের প্রধান অর্থকরী ফসল কী?","a)ধান","b)চা","c)পাট","d)গম","c)পাট");
        this.addQuestion(q9);
        Question q10=new Question("১০।প্রশ্ন : বিশ্বে ধান উৎপাদনে বাংলাদেশের অবস্থান?","a)১ম","b)৩য়","c)৫ম","d)৪থ","d)৪থ");
        this.addQuestion(q10);
        Question q11=new Question("১১।পাট উৎপাদনে বিশ্বে বাংলাদেশের স্থান?","a)4th","b)1st","c)5th","d)3rd","b)1st");
        this.addQuestion(q11);
        Question q12=new Question("১২।প্রশ্ন : সবচেয়ে বেশি পাট উৎপন্ন হয় কোন জেলায়?","a)ময়মনসিংহ।","b)বগুড়া","c)শেরপুর","d)খুলনা","a)ময়মনসিংহ।");
        this.addQuestion(q12);
        Question q13=new Question("১৩।প্রশ্ন : বাংলাদেশের অর্থনীতিতে কৃষিখাতের অবদান কত?","a)২১.৯১%।","b)২০.৯১%।","c)২২.৯১%।","d)১১.৯১%।","a)২১.৯১%।");
        this.addQuestion(q13);
        Question q14=new Question("১৪।প্রশ্ন : বাংলাদেশে বাণিজ্যিকভাবে প্রথম কখন চা চাষ করা হয়?","a)১৯৭৯","b)১৯৭০","c)১৯৭২","d)১৯৫৪","d)১৯৫৪");
        this.addQuestion(q14);
        Question q15=new Question("১৫।প্রশ্ন : বাংলদেশের প্রথম চা বাগান কোনটি?","a)সিলেটের লাক্কাতুরা","b)মৌলভীবাজার জেলার কমল্গঞ্জে","c)মৌলভীবাজার জেলার শ্রীমঙ্গলে।","d)সিলেটের মালনিছড়া।","d) িলেটের মালনিছড়া।");
        this.addQuestion(q15);
        Question q16=new Question("১৬।প্রশ্ন : বাংলাদেশের চা গবেষণা কেন্দ্র কোথায় অবস্থিত?","a)চাঁপাইনবাবগঞ্জে।","b)যশোরে।","c)মৌলভীবাজার জেলার শ্রীমঙ্গলে।","d)সুনামগঞ্জে","c)মৌলভীবাজার জেলার শ্রীমঙ্গলে।");
        this.addQuestion(q16);
        Question q17=new Question("১৭।প্রশ্ন : বাংলাদেশের সবচেয়ে বেশি রেশম উৎপন্ন হয়?","a)যশোরে।","b)চাঁপাইনবাবগঞ্জে।","বগুড়ায়","d)রাজশাহী","b)চাঁপাইনবাবগঞ্জে।");
        this.addQuestion(q17);
        Question q18=new Question("১৮।প্রশ্ন : বাংলাদেশে কোথায় সবচেয়ে বেশি তুলা জন্মে?","a)যশোরে।","b)চাঁপাইনবাবগঞ্জে।","c)ফরিদপুরে","d)সিলেটে","a)যশোরে।");
        this.addQuestion(q18);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
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
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
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