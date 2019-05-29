package o1.mobile.softhanjolup.Course;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import o1.mobile.softhanjolup.DB.inri_DBAdapter;
import o1.mobile.softhanjolup.DB.inri_DBHelper;
import o1.mobile.softhanjolup.R;


public class a_course_otherDB_j extends AppCompatActivity {

    ListView inriList;
    inri_DBHelper dbHelper;
    SQLiteDatabase db;
    String sql;
    Cursor cursor;

    final static String dbName = "INRI.db";
    final static int dbVersion = 3;

    Button confirmBtn;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_course_otherdb_x);

        dbHelper = new inri_DBHelper(this, dbName, null, dbVersion);

        confirmBtn = findViewById(R.id.other_confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

        inriList = findViewById(R.id.other_inriList);

        selectDB();

    }

    private void selectDB() {
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM inri_DB";

        cursor = db.rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            startManagingCursor(cursor);
            inri_DBAdapter dbAdapter = new inri_DBAdapter(this, cursor);
            inriList.setAdapter(dbAdapter);
        }

    }
}
