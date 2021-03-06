package com.example.ecoknowledge.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ecoknowledge.QuestionOS;

import java.util.ArrayList;
import java.util.List;

public class DBHelpers extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz.db";
    private static final String TABLE_QUEST = "questOS";
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA = "opta"; //option a
    private static final String KEY_OPTB = "optb"; //option b
    private static final String KEY_OPTC = "optc"; //option c
    private static final String KEY_OPTD = "optd"; //option d
    private static final String KEY_CAT = "category"; //category
    private static final String TABLE_QUEST1 = "questCompFunda";
    private static final String TABLE_QUEST2 = "questHardware";
    private static final String TABLE_QUEST3 = "questFinal";

    public static final String TABLE_SCORE = "score";
    public static final String SCORE_KEY_ID = "id";
    public static final String SCORE_KEY_SECTION = "section";
    public static final String SCORE_KEY_CAT = "category";
    public static final String SCORE_KEY_SCORE = "score";

    private SQLiteDatabase dbase;

    public DBHelpers(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public DBHelpers(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT, " + KEY_OPTD + " TEXT, " + "B" + " TEXT)";
        db.execSQL(sql);
        addQuestionsOS();

        String sql_quiz = "CREATE TABLE IF NOT EXISTS " + TABLE_SCORE + " ( "
                + SCORE_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SCORE_KEY_SECTION
                + " TEXT, " + SCORE_KEY_CAT + " TEXT, " + SCORE_KEY_SCORE + " INTEGER)";
        db.execSQL(sql_quiz);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addQuestionOS(QuestionOS quest) {
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


    //ecoknowledge
    private void addQuestionsOS() {
        // QuestionOS q0 = new QuestionOS( "question","a" ,"b" ,"c" ,"d" ,"answer" );
        QuestionOS q1 = new QuestionOS("????????? ????????? ????????? ???????????? ???????????? ?????? ?????? ???????????????. ??????????????? 101????????? ????????? ????????? 2008??? ???????????? ????????? ????????? ??? ??? ????????? ????????????????", " ??????????????????", "????????? ??????", "?????? ??????", "??????????????? ??????", "????????? ??????");
        QuestionOS q2 = new QuestionOS("???????????? ???????????? ???????????? ?????? ????????? ????????????. ???????????? ??????????????? ???????????? ?????? ???????????? ??? ??????????????? ???????????? ???????????? ????????? ?????? ?????????????????? ????????????. ??? ????????? ??????????", "?????? ??????", "?????? ??????", "?????? ????????? ??????", "????????? ?????? ??????", "?????? ????????? ??????");
        QuestionOS q3 = new QuestionOS("?????? ????????? ?????? ?????? ??????????????? ?????? ????????????. ??? ??? ???????????????, ???????????? ?????? ????????? ???????????? ???????????? ????????? ????????? ?????? ????????? ???????????? ??????????", "???????????????", "??????????????????", "???????????????", "????????????", "??????????????????");
        QuestionOS q4 = new QuestionOS("?????? ????????? ????????? ??? ????????? ????????? ???????????? ????????? ????????? ???????????? ?????? ??????????????????(WMO)??? ??????????????????(UNEP)??? ???????????? ????????? ?????? ?????? ?????? ???????????? ????????? ????????????????", "IPCC", "WWF", "UNESCO", "????????????", "IPCC");
        QuestionOS q5 = new QuestionOS("????????? NGO??? ?????? ?????? ????????????", "????????????", "????????? ???", "????????????????????????", "?????????", "?????????");
        QuestionOS q6 = new QuestionOS("1986??? 11??? ????????? ????????? ?????? ????????? ????????? ?????????????????? ????????? ???????????? ????????? ?????? ?????????, ???????????? ??????, ?????? ????????? ??? ??? 30t??? ?????? ?????????????????? ?????? ???????????? ?????? ?????? ????????? ?????? ????????? ?????? ?????? ???????????? ?????? ???????????? ??????????", "????????? ????????????", "????????? ????????????", "????????? ????????????", "????????? ????????????", "????????? ????????????");
        QuestionOS q7 = new QuestionOS("????????? ??????????????? ???????????? ???????????? ???????????? ???????????? ???????????? ????????? ??????????????? ????????? ????????? ??????????", "???????????????", "???????????????", "??????????????????", "???????????????", "???????????????");
        QuestionOS q8 = new QuestionOS("?????????, ?????????, ???????????? ?????? ????????? ?????? ????????????????", "????????????", "????????????", "????????????", "????????????", "????????????");
        QuestionOS q9 = new QuestionOS("???????????? ?????? ??????????????? ????????? ???????????? ?????? ?????? ????????? ????????? ????????? ???????????????? ", "??????", "??????", "??????", "??????", "??????");
        QuestionOS q10 = new QuestionOS("???????????? ?????? ??? ????????? ????????? ???????????? ?????? ????????? ?????? ????????? ?????? ????????? ?????? ?????? ????????? ????????? ??????????????? ?????? ????????? ?????? ???????????? ????????? ???????????? ????????? ??????????????? ??????????", "????????????", "??????????????? ", "????????? ", "???????????? ", "????????????");
        QuestionOS q11 = new QuestionOS("??? ??????????????? ?????????????????? ??????????????? ????????? ??? ?????? ???????????????. ??????????????? ???????????? ???????????? ??? ??????????????? ????????????????", "??????", "????????????", "???????????????", "??????", "???????????????");
        QuestionOS q12 = new QuestionOS("??????????????? ???10km~50km????????? ??????????????? ?????????. ????????? ????????? ?????? ??? 25km ????????? ????????? ?????? ?????? ???????????? ????????? ????????? ???????????? ??????????????? ????????? ????????????????", "??????", "?????????", "?????????", "???????????????", "?????????");
        QuestionOS q13 = new QuestionOS("???????????? ???????????????????????????????????? ????????? ????????? ???????????? ???????????? ????????? ???????????? ?????? ????????? ????????? ????????? ???????????? ????????? ????????????", "????????????", "????????????", "????????????", "?????? ???", "????????????");

        //14??? o/x???????????? ????????????. ?????? ????????? ????????? ??? ?????? ????????? ????????? ????????? ???!!!!!! 14 ->15???
        QuestionOS q14 = new QuestionOS("1992??? ???????????? ??????????????????????????? ????????? ?????? ?????? ??????????????? ????????? ?????????????", "??????????????????", "????????????", "????????????", "?????????????????????", "????????????");//
        QuestionOS q15 = new QuestionOS("?????????????????????????????? ????????? ???????????? ?????? ?????? ????????? ??????????????? ???????????? ????????????. ????????????????????? ????????? ??????????????? ??? ???????????? ????????????????????? ????????????????", "IMO 14", "IEO 1400", "ISO 14000", "ISO 2000", "ISO 14000");//
        QuestionOS q16 = new QuestionOS("???????????? ????????? ?????? ????????? ???????????? ?????????, 1910??? ????????? ??????????????? ???????????? ???????????? ?????? ?????? ?????????, ?????? ?????? ?????? ??????????????? ??????. ???????????? ???????????? ?????????????????? ?????? ???????????? ????????? ????????? ????????? ?????????. ??? ?????? ?????????????", "?????????????????????", "?????????", "???????????????", "?????????????????????", "?????????????????????");
        QuestionOS q17 = new QuestionOS("?????????????????? ?????? ??????????????? ??? ??? ?????? ?????? ????????? ????????????????", "???????????????", "???", "??????????????????", "????????????", "??????????????????");
        QuestionOS q18 = new QuestionOS("??? ?????? ???????????? ????????? ????????? ????????? ????????? ???????????? ????????? ???????????? ???, ??? ????????? ?????? ????????????????", "5??? 5???", "6??? 5???", "1??? 1???", "4??? 3???", "6??? 5???");
        QuestionOS q19 = new QuestionOS("?????? ?????? ?????? ?????? ????????????????", "1??? 1???", "3??? 22???", "5??? 5???", "12??? 25???", "3??? 22???");
        QuestionOS q20 = new QuestionOS("??????????????? ?????? ?????? ????????????????? ??????????????? ?????? ????????? ??????????????? ??????????", "????????????", "CITES", "????????????", "????????????", "CITES");
        QuestionOS q21 = new QuestionOS("??????????????? ???????????? ????????? ?????? ??????????????? ????????? ????????? ????????? ?????? 2??? ?????? ????????? ????????? ??? ??? ????????? ?????????. ????????? ????????????????", "??????", "???????????????", "??????", "??????", "??????");
        QuestionOS q22 = new QuestionOS("????????? ???????????? ????????? ?????? ?????? ????????? ??????????????? ??????????????? ????????? ?????? ?????? ?????? ???????????? ???????????? ???????????? ?????? ?????????. ????????? ????????????????", "????????????", "????????????", "????????????", "????????????", "????????????");
        QuestionOS q23 = new QuestionOS("?????????(bicycle)??? ?????????(ecology)??? ??????????????? 1971??? ?????? ????????? ???????????? ???????????? ?????????????????? ????????? ??? ????????? ????????????????", "????????????", "???????????????", "???????????????", "???????????????", "???????????????");
        QuestionOS q24 = new QuestionOS("????????? ????????? ????????? ????????? ????????? ????????? ???????????? ?????? ????????? ????????? ????????? ??????. ??? ?????? ????????? ????????????????", "?????????", "?????????", "?????????", "?????????", "?????????");
        QuestionOS q25 = new QuestionOS("???????????????????????? ????????? ????????? ?????? (???????????????)??? ????????? ?????? ????????? ???????????? ????????? ????????????????", "?????? ?????? ?????? ??????", "????????? ?????? ??????", "????????? ?????? ??????", "????????? ????????? ??????", "?????? ?????? ?????? ??????");
        QuestionOS q26 = new QuestionOS("?????? ??????, ???????????? ??? ????????? ?????????. ????????? ????????????, ???????????? ????????? ??????. [?????? ??????] ??????????????? Sakht - Sar. ?????? 1??? 6000??? ???????????? ?????? ?????? ??????????????? ????????? ???????????? ????????? ????????????????", "?????????", "?????????", "?????????", "????????????", "?????????");
        QuestionOS q27 = new QuestionOS("????????? ????????? ??????????????? ???????????? ???????????? ????????? ????????? ???????????? ????????? ?????????????????? ??????????????? ??????????", "????????????", "????????????", "???????????????", "???????????????", "???????????????");
        QuestionOS q28 = new QuestionOS("?????? ??? ?????? ???????????? ????????? ?????? ?????????????????? ????????? ???????", "?????? ??? ????????? ??????, ?????? ????????? ???????????? ????????????. ", "?????? ????????? ????????? ??? ????????? ????????? ????????????.", "?????? ????????? ????????? ???????????? ?????? ??? ?????? ????????? ????????????.", "?????? ????????? ????????? ????????? ?????? ????????? ??? ??? ????????????", "?????? ??? ????????? ??????, ?????? ????????? ???????????? ????????????.");
        QuestionOS q29 = new QuestionOS("???????????? ????????? ????????? ???????????? ???????????? ????????? ????????? ????????? ??????????????? ????????? ??? ????????? ????????? ??? ?????????? ", "????????????", "?????????", "???????????????", "???????????????", "????????????");
        QuestionOS q30 = new QuestionOS("?????? ?????? ??? ???????????? ???????????? ?????? ???????", "???????????????", "?????????", "??????", "?????????", "???????????????");
        QuestionOS q31 = new QuestionOS("?????? ????????? ????????? ?????????????????? ?????? ??????????????? ?????? ???????????? ????????? ?????? ?????? ????????????????", "???????????????", "?????????", "???????????????", "????????????", "???????????????");
        QuestionOS q32 = new QuestionOS("????????? ????????? ??? ???(6???)?????? ????????? ????????? ??? ??? ??????????", "1???", "2???", "3???", "4???", "4???");
        QuestionOS q33 = new QuestionOS("?????????, ?????????, ??????????????? ????????? ???????????? ???????????? ????????? ???????????? ????????? ???????????? ???????????? ????????? ????????? ?????? ?????????????????? ???????????????????????? ??????????????? ?????? ???????????? ??????????", "???????????????", "??????????????????", "????????????", "????????????", "??????????????????");
        QuestionOS q34 = new QuestionOS("500????????? ????????? ????????? ????????? ???????????????", "?????????", "??????", "?????????", "??????", "?????????");
        QuestionOS q35 = new QuestionOS("?????? ???????????? ???????????????. ?????? ???????????? ????????? ????????? ????????? ???????????????? \n ?????? ????????? ???????????? ?????? ??????, ??? ???????????????(???)??? ????????? ????????????.", "???", "??????", "??????", "??????", "??????");
        QuestionOS q36 = new QuestionOS("????????? ?????? ???????????? ?????? ???????????? ???????????? ??????????????? ????????????????????? ?????????, ????????? ????????????????", "????????? ????????? ????????? ???", "??????????????? ???", "????????????", "?????????", "????????????");
        QuestionOS q37 = new QuestionOS("?????? ??? ???????????? ????????????????", "????????????", "????????????", "???????????????", "??????????????????", "???????????????");
        QuestionOS q38 = new QuestionOS("?????? ??? ????????? ????????? ?????? ???????", "????????? ??????, ??????, ???, ??? ??? ?????? ???????????? ???????????? ??????.", "????????? ???????????? ????????? ??????????????? ?????????.", "????????? ???????????? ???????????? ???????????????.", "????????? ????????? ????????? ?????????.", "????????? ???????????? ???????????? ???????????????.");
        QuestionOS q39 = new QuestionOS("?????? ?????? ????????? ????????? ?????? ???????????? ????????? ???????????? ???????????????. ??????????????? ?????? ?????? ????????? ??? ?????????????", "6??? 49???", "7??? 30???", "8??? 50???", "9??? 56???", "9??? 56???");
        QuestionOS q40 = new QuestionOS("?????? ????????????~????????? ??????~ ?????? ??????????????? ???????????????. ????????? ???????????? ??????????????? ?????? ?????? ????????????????", "????????????", "????????????", "???????????????", "????????????", "????????????");
        QuestionOS q41 = new QuestionOS("TV?????? ??? ???????????? ????????? ?????? ????????? ?????? ?????? ????????? ????????????. ?????? ???????????? ?????????????????? ?????? ????????? ?????? ????????? ????????? ?????? ??????????????? ???????????? ????????? ????????? ?????? ????????? ???????????? ??? ?????? ?????? ?????? ??????????????? ????????? ????????????. ???????????? ???????????? ????????? ????????????????", "????????? ??????", "?????? ?????? ?????? ??????", "?????? ?????? ???", "?????? ??????", "?????? ?????? ?????? ??????");
        QuestionOS q42 = new QuestionOS("???????????? ???????????????????????????????????? ????????? ????????? ???????????? ???????????? ????????? ???????????? ?????? ????????? ????????? ????????? ???????????? ????????? ?????????????", "????????????", "????????????", "????????????", "?????? ???", "????????????");
        QuestionOS q43 = new QuestionOS("????????? 1?????? ??????????????? ????????? ??? ?????? ?????? ??????????", "10???", "20???", "30???", "40???", "30???");
        QuestionOS q44 = new QuestionOS("?????? ??? ????????? ???????????? ?????? ?????? ????????????????", "?????????", "??????", "??????", "??????", "??????");
        QuestionOS q45 = new QuestionOS("????????? ??? ??????????????? ?????????????????? ???????????? ????????? ????????????????????? ?????????. ?????? ??????????????? ????????? ???????????? ????????? ?????? ?????? ????????? ????????????????", "?????????", "???????????? ????????????", "?????????", "?????????", "???????????? ????????????");
        QuestionOS q46 = new QuestionOS("?????? ??????(????????? ????????? ?????? ?????? ??????)??? ?????? ???????????? ????????? ????????? ???????????? ????????? ???????????? ????????? ????????? ?????? ????????? ????????????????", "CNG", "LNG", "LPG", "BIOGAS", "BIOGAS");
        QuestionOS q47 = new QuestionOS("????????? ????????? ?????? ??????, ?????????, ????????? ????????? ???????????? ???????????? ?????????. ?????? ??? ????????? ????????? ?????? ?????? ????????????????", "??????", "???", "????????????", "??????", "??????");
        QuestionOS q48 = new QuestionOS("???????????? ???????????? ???????????? ????????? ?????? ????????? ????????????????????? ??? ??????????", "18 - 20??? ", "22 - 24??? ", "24 - 26??? ", "26 - 28??? ", "26 - 28??? ");
        QuestionOS q49 = new QuestionOS("??? ????????? ????????? ??????????????? ???????????? ???????????? ?????? ????????? ???????????? ????????? ?????? ??????????????? ????????? ?????? ????????????. ????????????????????? ?????? 1995????????? ???????????? ?????? ??? ????????? ????????? ????????? ????????????????", "??????????????????", "?????????????????????", "??????????????????", "?????????????????????", "??????????????????");
        QuestionOS q50 = new QuestionOS("????????? ???????????? ?????? ????????? ????????? ????????? ????????????? ???????????? ???????????? 90% ????????? ????????? ???????????? ????????????????????? ????????? ??? ?????? ?????? ????????? ??? %??? ???????????? ?????????????", "??? 5%", "??? 10%", "??? 25%", "??? 40%", "??? 25%");
        QuestionOS q51 = new QuestionOS("?????? ?????? ??? ????????? ????????? ???????????? ????????? ?????? ?????? ????????? ?????? ????????????????", "????????????", "?????????", "????????????", "?????????", "????????????");
        QuestionOS q52 = new QuestionOS("????????? ????????? ????????? ???????????? ????????? ??? ????????? ???????????????. ????????? ??????????????? ?????? ???????????? ??? ????????? ?????? ??? ?????? ????????? ?????????????????? ????????? ?????? ????????????. ??? ????????? ????????????????", "????????????", "LPG", "LNG", "???????????????", "????????????");
        QuestionOS q53 = new QuestionOS("???????????? ????????? ?????? ?????? ?????? ???????????? ??? ?????? ?????? ?????? ?????? ????????? ???????????? ????????? ??? ??? ????????? ??? ????????? ?????? ????????? ?????? m??? ?????????????????? ???????????? ?????? ????????? ????????? ????????? ???????????? ????????? ????????? ??????????????? ??????????", "?????????", "?????????", "????????????", "?????????", "?????????");
        QuestionOS q54 = new QuestionOS("????????? ???????????? ??????????????? ????????? ????????? ??? ????????? ???????????? ???????????? ?????? ?????? ?????? ?????? ??????, ???????????? ????????? 14??? ????????? ??? ?????? ??????????????? ??????????", "????????? ???", "????????? ???", "???????????? ???", "?????? ???", "???????????? ???");
        QuestionOS q55 = new QuestionOS("????????? ???????????? ???????????? ?????? ????????? ????????? ?????????, ?????????, ??????????????????, ????????? ?????? ????????? ?????? ????????????????", "???????????????", "??????????????????", "?????? ?????????", "????????? ?????????", "????????? ?????????");
        QuestionOS q56 = new QuestionOS("????????? ????????? ??????????????? ????????? ????????? ????????? ??? ?????? '3R ??????'?????? ????????? ?????? ??????????????? ???????????? ?????? ?????? ????????????????", "??????(reduction)", "?????????(reuse)", "??????(reversion)", "?????????(recycling)", "??????(reversion)");
        QuestionOS q57 = new QuestionOS("????????? ???????????? ????????? ??????????????? ????????? ?????? ??????????????? ??????????????? ???????????? ????????? ( )??????. ?????? ?????? ????????? ???????", "????????????", "??????????????? ??????", "???????????????", "????????????", "???????????????");
        QuestionOS q58 = new QuestionOS("?????? 100??? ?????? ????????? ?????? 0.74?????? ??????????????? ?????????. 1?????? ?????? 1??? ????????? ?????? ???????????? ????????? ?????? ?????? ?????? ?????? ?????? ????????? ????????? ?????? ????????? ?????? ?????? ???????????????. ?????? ????????? ??????????????? ??????????????? ???????????? ???????????? ?????? ????????? ????????? ???????????? ??????????????? ????????? ????????? ??????????????? ????????? ???????????????. ?????? ???????????? ???????????? ?????? ????????? ?????????, ??????????????? ?????? 100?????? ?????? ??? ??? ???????????????????", "??? 0.4??? ", "??? 0.75??? ", "??? 1.5??? ", "??? 2.4??? ", "??? 1.5??? ");
        QuestionOS q59 = new QuestionOS("??????????????? ?????????????????? ?????? ?????? ????????? ?????????????????? ????????? ???????????? ?????? ????????? ??????????????? ??????????????? ??????????????? ????????? ????????? ??????????????? ????????? ????????? ?????? ????????? ??????????????? ??????????", "?????????", "????????????", "?????????", "??????", "?????????");
        QuestionOS q60 = new QuestionOS("?????????????????? ???????????? 6??? ??????????????? ???????????? ?????? ?????? ????????????????", "???????????????", "???????????????", "??????", "??????", "??????");
        QuestionOS q61 = new QuestionOS("?????????????????? ?????? ?????? ????????? CO2 ?????? ?????? ???????????? ??? 70%????????? ??????????????? ???????????? ????????????. ?????? ?????? ??? ?????? ?????? CO2??? ???????????? ????????? ????????????????", "??????", "??????", "??????", "??????", "??????");

        // ????????????.
//        QuestionOS q62 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q63 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q64 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q65 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q66 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q67 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q68 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q69 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q70 = new QuestionOS("", "", "", "", "", "");


        this.addQuestionOS(q1);
        this.addQuestionOS(q2);
        this.addQuestionOS(q3);
        this.addQuestionOS(q4);
        this.addQuestionOS(q5);
        this.addQuestionOS(q6);
        this.addQuestionOS(q7);
        this.addQuestionOS(q8);
        this.addQuestionOS(q9);
        this.addQuestionOS(q10);
        this.addQuestionOS(q11);
        this.addQuestionOS(q12);
        this.addQuestionOS(q13);
        this.addQuestionOS(q14);
        this.addQuestionOS(q15);
        this.addQuestionOS(q16);
        this.addQuestionOS(q17);
        this.addQuestionOS(q18);
        this.addQuestionOS(q19);
        this.addQuestionOS(q20);
        this.addQuestionOS(q21);
        this.addQuestionOS(q22);
        this.addQuestionOS(q23);
        this.addQuestionOS(q24);
        this.addQuestionOS(q25);
        this.addQuestionOS(q26);
        this.addQuestionOS(q27);
        this.addQuestionOS(q28);
        this.addQuestionOS(q29);
        this.addQuestionOS(q30);
        this.addQuestionOS(q31);
        this.addQuestionOS(q32);
        this.addQuestionOS(q33);
        this.addQuestionOS(q34);
        this.addQuestionOS(q35);
        this.addQuestionOS(q36);
        this.addQuestionOS(q37);
        this.addQuestionOS(q38);
        this.addQuestionOS(q39);
        this.addQuestionOS(q40);
        this.addQuestionOS(q41);
        this.addQuestionOS(q42);
        this.addQuestionOS(q43);
        this.addQuestionOS(q44);
        this.addQuestionOS(q45);
        this.addQuestionOS(q46);
        this.addQuestionOS(q47);
        this.addQuestionOS(q48);
        this.addQuestionOS(q49);
        this.addQuestionOS(q50);
        this.addQuestionOS(q51);
        this.addQuestionOS(q52);
        this.addQuestionOS(q53);
        this.addQuestionOS(q54);
        this.addQuestionOS(q55);
        this.addQuestionOS(q56);
        this.addQuestionOS(q57);
        this.addQuestionOS(q58);
        this.addQuestionOS(q59);
        this.addQuestionOS(q60);
        this.addQuestionOS(q61);

//        this.addQuestionOS(q62);
//        this.addQuestionOS(q63);
//        this.addQuestionOS(q64);
//        this.addQuestionOS(q65);
//        this.addQuestionOS(q66);
//        this.addQuestionOS(q67);
//        this.addQuestionOS(q68);
//        this.addQuestionOS(q69);
//        this.addQuestionOS(q70);


    }

    public List<QuestionOS> getAllQuestions(String tname) {
        List<QuestionOS> quesList1 = new ArrayList<QuestionOS>();
        // String selectQuery1 = "SELECT  * FROM " + tname + " WHERE " + KEY_CAT + " = '" + lname + "'";
        String selectQuery1 = "SELECT  * FROM " + "questOS";
        String selectQuery2 = "SELECT  * FROM questOS WHERE category = 'B'";

        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);

        Log.d("select query1: ", selectQuery1);
        // Log.d("lname: ", lname);
        Log.d("tname: ", tname);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionOS quest1 = new QuestionOS();

                quest1.setID(cursor.getInt(0));

                quest1.setQUESTION(cursor.getString(1));
                quest1.setANSWER(cursor.getString(2));

                quest1.setOPTA(cursor.getString(3));
                quest1.setOPTB(cursor.getString(4));
                quest1.setOPTC(cursor.getString(5));
                quest1.setOPTD(cursor.getString(6));

                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }
}
