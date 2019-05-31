package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class changsa_DBHelper extends SQLiteOpenHelper {
    String sql;

    public changsa_DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        sql = "CREATE TABLE changsa_DB (_id INTEGER PRIMARY KEY AUTOINCREMENT, courseName TEXT, semester INTEGER);" ;

        db.execSQL(sql);

        db.execSQL("INSERT INTO changsa_DB VALUES(0, '창의와 사고', 0);");
        db.execSQL("INSERT INTO changsa_DB VALUES(1, '논리적 사고', 0);");
        db.execSQL("INSERT INTO changsa_DB VALUES(2, '사고와 표현', 0);");
        db.execSQL("INSERT INTO changsa_DB VALUES(3, '역사와 상상력', 0);");
        db.execSQL("INSERT INTO changsa_DB VALUES(4, '창의적 고전읽기', 0);");
        db.execSQL("INSERT INTO changsa_DB VALUES(5, '창조와 몰입', 0);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //버전이 업그레이드 됐을 경우 작업할 내용을 작성합니다.
        db.execSQL("drop table changsa_DB");
        onCreate(db);
    }
}
