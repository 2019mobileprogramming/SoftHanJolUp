package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class track_DBHelper extends SQLiteOpenHelper {
    String sql;

    public track_DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        sql = "CREATE TABLE track_DB (_id INTEGER PRIMARY KEY AUTOINCREMENT, courseName TEXT, semester INTEGER, class INTEGER, trackName TEXT, checked INTEGER);" ;

        db.execSQL(sql);

        db.execSQL("INSERT INTO track_DB VALUES(0, '데이터 과학', 1, 17, 'Both', 0);");
        db.execSQL("INSERT INTO track_DB VALUES(1, '인공지능 개론', 2, 17, 'General', 0);");
        db.execSQL("INSERT INTO track_DB VALUES(2, '머신러닝', 2, 17, '빅데이터', 0);");
        db.execSQL("INSERT INTO track_DB VALUES(3, '클라우드', 3, 17, 'General', 0);");
        db.execSQL("INSERT INTO track_DB VALUES(4, '딥러닝', 3, 17, '빅데이터', 0);");
        db.execSQL("INSERT INTO track_DB VALUES(5, '사이버 보안', 4, 17, 'General', 0);");
        db.execSQL("INSERT INTO track_DB VALUES(6, '데이터베이스2', 4, 17, '빅데이터', 0);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //버전이 업그레이드 됐을 경우 작업할 내용을 작성합니다.
        db.execSQL("drop table track_DB");
        onCreate(db);
    }
}
