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

import o1.mobile.softhanjolup.DB.changsa_DBHelper;
import o1.mobile.softhanjolup.DB.inri_DBHelper;
import o1.mobile.softhanjolup.DB.track_DBHelper;
import o1.mobile.softhanjolup.R;


public class a_course_otherDB_j extends AppCompatActivity {

    inri_DBHelper inriDBHelper;
    changsa_DBHelper changsa_dbHelper;
    track_DBHelper track_dbHelper;
    SQLiteDatabase db;
    String sql;
    Cursor cursor;
    Spinner inri101, inri102;
    Spinner changsa101, changsa102;
    Spinner track1, track2, track3, track4;
    List<Spinner> trackSpinner= new ArrayList<>();
    Bundle savedData = new Bundle();

    final static String inriDBName = "INRI.db";
    final static String changsaDBName = "CHANGSA.db";
    final static String trackDBName = "TRACK.db";
    final static int dbVersion = 3;

    Button confirmBtn;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_course_otherdb_x);

        inriDBHelper = new inri_DBHelper(this, inriDBName, null, dbVersion);
        changsa_dbHelper = new changsa_DBHelper(this, changsaDBName, null, dbVersion);
        track_dbHelper = new track_DBHelper(this, trackDBName, null, dbVersion);

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
        savedData.putString("changsa101", "창의와 사고");
        savedData.putString("changsa102", "창의와 사고");
        savedData.putString("track1", "트랙1");
        savedData.putString("track2", "트랙2");
        savedData.putString("track3", "트랙3");
        savedData.putString("track4", "트랙4");

        inri101 = findViewById(R.id.inri_101_spinner);
        inri102 = findViewById(R.id.inri_102_spinner);
        changsa101 = findViewById(R.id.changsa_101_spinner);
        changsa102 = findViewById(R.id.changsa_102_spinner);
        track1 = findViewById(R.id.track_1_spinner);
        track2 = findViewById(R.id.track_2_spinner);
        track3 = findViewById(R.id.track_3_spinner);
        track4 = findViewById(R.id.track_4_spinner);

        trackSpinner.add(track1);
        trackSpinner.add(track2);
        trackSpinner.add(track3);
        trackSpinner.add(track4);

        loadInriData();
        loadchangsaData();
        loadTrackData();

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

        changsa101.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = parent.getSelectedItem().toString();
                savedData.putString("changsa101", selectedCourse);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        changsa102.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = parent.getSelectedItem().toString();
                savedData.putString("changsa102", selectedCourse);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        track1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = parent.getSelectedItem().toString();
                savedData.putString("track1", selectedCourse);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        track2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = parent.getSelectedItem().toString();
                savedData.putString("track2", selectedCourse);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        track3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = parent.getSelectedItem().toString();
                savedData.putString("track3", selectedCourse);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        track4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = parent.getSelectedItem().toString();
                savedData.putString("track4", selectedCourse);
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



        db = changsa_dbHelper.getWritableDatabase();
        values = new ContentValues();

        values.put("semester", 0);
        db.update("changsa_DB", values, "courseName=?", new String[]{savedData.getString("changsa101")});
        db.update("changsa_DB", values, "courseName=?", new String[]{savedData.getString("changsa102")});
        //reset previous data

        String changsa101Course = savedData.getString("changsa101");
        values.put("semester", 101);
        db.update("changsa_DB", values, "courseName=?", new String[]{changsa101Course});

        String changsa102Course = savedData.getString("changsa102");
        values.put("semester", 102);
        db.update("changsa_DB", values, "courseName=?", new String[]{changsa102Course});




        db = track_dbHelper.getWritableDatabase();
        values = new ContentValues();

        values.put("checked", 0);
        db.update("track_DB", values, "courseName=?", new String[]{savedData.getString("track1")});
        db.update("track_DB", values, "courseName=?", new String[]{savedData.getString("track2")});
        db.update("track_DB", values, "courseName=?", new String[]{savedData.getString("track3")});
        db.update("track_DB", values, "courseName=?", new String[]{savedData.getString("track4")});
        //reset previous data

        for(int i=0; i<4; i++){
            String trackCourse = savedData.getString("track"+(i+1));
            values.put("checked",1);
            db.update("track_DB", values, "courseName=?", new String[]{trackCourse});
        }

    }

    private void loadInriData() {
        db = inriDBHelper.getReadableDatabase();
        List<String> label101 = new ArrayList<String>();
        List<String> label102 = new ArrayList<String>();

        sql = "SELECT * FROM inri_DB";

        cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        for(int i=0; i<cursor.getCount(); i++){
                label101.add(cursor.getString(cursor.getColumnIndex("courseName")));
                label102.add(cursor.getString(cursor.getColumnIndex("courseName")));
            cursor.moveToNext();
        }

        ArrayAdapter<String> dataAdapter101 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, label101);
        ArrayAdapter<String> dataAdapter102 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, label102);
        dataAdapter101.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter102.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inri101.setAdapter(dataAdapter101);
        inri102.setAdapter(dataAdapter102);
    }

    private void loadchangsaData() {
        db = changsa_dbHelper.getReadableDatabase();
        List<String> label101 = new ArrayList<String>();
        List<String> label102 = new ArrayList<String>();

        sql = "SELECT * FROM changsa_DB";

        cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        for(int i=0; i<cursor.getCount(); i++){
                label101.add(cursor.getString(cursor.getColumnIndex("courseName")));
                label102.add(cursor.getString(cursor.getColumnIndex("courseName")));
            cursor.moveToNext();
        }

        ArrayAdapter<String> dataAdapter101 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, label101);
        ArrayAdapter<String> dataAdapter102 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, label102);
        dataAdapter101.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter102.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        changsa101.setAdapter(dataAdapter101);
        changsa102.setAdapter(dataAdapter102);
    }

    private void loadTrackData() {
        db = track_dbHelper.getReadableDatabase();
        List<String> label1 = new ArrayList<String>();
        List<String> label2 = new ArrayList<String>();
        List<String> label3 = new ArrayList<String>();
        List<String> label4 = new ArrayList<String>();

        sql = "SELECT * FROM track_DB";

        cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        for(int i=0; i<cursor.getCount(); i++){
            switch(cursor.getInt(cursor.getColumnIndex("semester"))){
                case 1:
                    label1.add(cursor.getString(cursor.getColumnIndex("courseName")));
                    break;
                case 2:
                    label2.add(cursor.getString(cursor.getColumnIndex("courseName")));
                    break;
                case 3:
                    label3.add(cursor.getString(cursor.getColumnIndex("courseName")));
                    break;
                case 4:
                    label4.add(cursor.getString(cursor.getColumnIndex("courseName")));
                    break;
            }
            cursor.moveToNext();
        }

        List<List<String>> label = new ArrayList<>();
        label.add(label1);
        label.add(label2);
        label.add(label3);
        label.add(label4);

        for(int i=0; i<4; i++){
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, label.get(i));
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            trackSpinner.get(i).setAdapter(dataAdapter);
        }
    }
}
