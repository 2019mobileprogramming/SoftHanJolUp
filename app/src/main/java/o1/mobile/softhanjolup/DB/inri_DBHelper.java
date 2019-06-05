package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class inri_DBHelper extends SQLiteOpenHelper {
    String sql;

    public inri_DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        sql = "CREATE TABLE inri_DB (_id INTEGER PRIMARY KEY AUTOINCREMENT, courseName TEXT, semester INTEGER);" ;

        db.execSQL(sql);

        db.execSQL("INSERT INTO inri_DB VALUES(0, '인성과 리더십', 0);");
        db.execSQL("INSERT INTO inri_DB VALUES(1, '가천 리더십', 0);");
        db.execSQL("INSERT INTO inri_DB VALUES(2, '생명과 나눔', 0);");
        db.execSQL("INSERT INTO inri_DB VALUES(3, '한국사', 0);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //버전이 업그레이드 됐을 경우 작업할 내용을 작성합니다.
        db.execSQL("drop table inri_DB");
        onCreate(db);
    }
}
