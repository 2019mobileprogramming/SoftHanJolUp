package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Book_memo_DBHelper extends SQLiteOpenHelper {
    String sql;

    public Book_memo_DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //bookNum integer, title string, author string
        sql = "CREATE TABLE memoBook (_id INTEGER PRIMARY KEY AUTOINCREMENT, bookNum INTEGER, title TEXT, author TEXT, content1 TEXT, content2 TEXT, content3 TEXT, content4 TEXT, content5 TEXT);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //버전이 업그레이드 됐을 경우 작업할 내용을 작성합니다.
    }
}
