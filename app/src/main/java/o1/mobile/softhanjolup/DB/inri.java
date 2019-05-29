package o1.mobile.softhanjolup.DB;

import android.database.sqlite.SQLiteDatabase;

public class inri {
    SQLiteDatabase db;

    inri(SQLiteDatabase db){
        this.db = db;
    }

    public void createInriDB(SQLiteDatabase db){
        //id, courseName, semester

        db.execSQL("INSERT INTO inri_DB VALUES(0, '가천 리더십', 0);");
        db.execSQL("INSERT INTO inri_DB VALUES(0, '생명과 나눔', 0);");
        db.execSQL("INSERT INTO inri_DB VALUES(0, '한국사', 0);");
    }
}
