package o1.mobile.softhanjolup.Course;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import o1.mobile.softhanjolup.DB.inri_DBHelper;
import o1.mobile.softhanjolup.R;


public class a_course_otherDB_j extends AppCompatActivity {

    inri_DBHelper inriDBHelper;
    SQLiteDatabase db;
    String sql;
    Cursor cursor;
    Spinner inri101, inri102;
    Bundle savedData = new Bundle();

    final static String inriDBName = "INRI.db";
    final static int dbVersion = 3;

    Button confirmBtn;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_course_otherdb_x);

        inriDBHelper = new inri_DBHelper(this, inriDBName, null, dbVersion);

        confirmBtn = findViewById(R.id.other_confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                saveData();
                finish();
            }
        });
        savedData.putString("inri101", "인성과 리더십");
        savedData.putString("inri102", "인성과 리더십");

        inri101 = findViewById(R.id.inri_101_spinner);
        inri102 = findViewById(R.id.inri_102_spinner);

        loadInriData();

        inri101.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = parent.getSelectedItem().toString();
                savedData.putString("inri101", selectedCourse);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        inri102.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = parent.getSelectedItem().toString();
                savedData.putString("inri102", selectedCourse);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void saveData(){
        db = inriDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("semester", 0);
        db.update("inri_DB", values, "courseName=?", new String[]{savedData.getString("inri101")});
        db.update("inri_DB", values, "courseName=?", new String[]{savedData.getString("inri102")});
        //reset previous data

        String inri101Course = savedData.getString("inri101");
        values.put("semester", 101);
        db.update("inri_DB", values, "courseName=?", new String[]{inri101Course});

        String inri102Course = savedData.getString("inri102");
        values.put("semester", 102);
        db.update("inri_DB", values, "courseName=?", new String[]{inri102Course});

    }

    private void loadInriData() {
        db = inriDBHelper.getReadableDatabase();
        List<String> label101 = new ArrayList<String>();
        List<String> label102 = new ArrayList<String>();

        sql = "SELECT * FROM inri_DB";

        cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        for(int i=0; i<cursor.getCount(); i++){
            if(cursor.getInt(cursor.getColumnIndex("semester")) != 101){
                label101.add(cursor.getString(cursor.getColumnIndex("courseName")));
            }
            if(cursor.getInt(cursor.getColumnIndex("semester")) != 102) {
                label102.add(cursor.getString(cursor.getColumnIndex("courseName")));
            }
            cursor.moveToNext();
        }

        ArrayAdapter<String> dataAdapter101 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, label101);
        ArrayAdapter<String> dataAdapter102 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, label102);
        dataAdapter101.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter102.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inri101.setAdapter(dataAdapter101);
        inri102.setAdapter(dataAdapter102);



    }


}
