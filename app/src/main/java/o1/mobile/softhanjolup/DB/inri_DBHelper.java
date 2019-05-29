package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class inri_DBHelper extends SQLiteOpenHelper {
    String sql;
    String tempsql;

    public inri_DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        sql = "CREATE TABLE inri_DB (_id INTEGER PRIMARY KEY AUTOINCREMENT, courseName TEXT, semester INTEGER);" ;

        db.execSQL(sql);

        inri tempDB = new inri(db);
        tempDB.createInriDB(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //버전이 업그레이드 됐을 경우 작업할 내용을 작성합니다.
        db.execSQL("drop table inri_DB");
        onCreate(db);
    }
}
