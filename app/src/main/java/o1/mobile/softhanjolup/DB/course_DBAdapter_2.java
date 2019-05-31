package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import o1.mobile.softhanjolup.R;

public class course_DBAdapter_2 extends CursorAdapter {

    inri_DBHelper inriDBHelper;
    changsa_DBHelper changsa_dbHelper;
    track_DBHelper track_dbHelper;
    SQLiteDatabase inriDB, ChangsaDB, trackDB;

    final static String inriDBName = "INRI.db";
    final static String changsaDBName = "CHANGSA.db";
    final static String trackDBName = "TRACK.db";
    final static int dbVersion = 3;

    public course_DBAdapter_2(Context context, Cursor c){
        super(context, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final TextView courseName2 = view.findViewById(R.id.courseName2);
        final TextView credit2 = view.findViewById(R.id.credit2);
        final TextView index_course2 = view.findViewById(R.id.index_course2);
        final RelativeLayout listParent = view.findViewById(R.id.courseListParent2);

        courseName2.setText(cursor.getString(cursor.getColumnIndex("courseName")));
        credit2.setText(cursor.getString(cursor.getColumnIndex("credit")));
        index_course2.setText(cursor.getString(cursor.getColumnIndex("index_course")));

        checkDone(cursor, listParent, context);
        checkInri(cursor, context, courseName2);
        checkChangSa(cursor, context, courseName2);
        checkIndex(index_course2);
        checkTrack(cursor, context, courseName2);


    }

    public void checkIndex(TextView index_course){
        if(index_course.getText().toString().equals("1")){
            index_course.setText("학교필수교양");
        } else if(index_course.getText().toString().equals("2")){
            index_course.setText("학과필수교양");
        } else if(index_course.getText().toString().equals("3")){
            index_course.setText("필수일반선택");
        } else if(index_course.getText().toString().equals("4")){
            index_course.setText("트랙");
        } else if(index_course.getText().toString().equals("5")){
            index_course.setText("전공필수");
        } else if(index_course.getText().toString().equals("6")){
            index_course.setText("전공선택");
        } else if(index_course.getText().toString().equals("7")){
            index_course.setText("일반선택");
        }
    }
    public void checkDone(Cursor cursor, RelativeLayout listParent, Context context){
        if(cursor.getInt(cursor.getColumnIndex("done")) == 0){
            listParent.setBackgroundColor(context.getResources().getColor(R.color.nodoneBackground));
        }
        else{
            listParent.setBackgroundColor(context.getResources().getColor(R.color.doneBackground));
        }
    }

    public void checkInri(Cursor cursor, Context context, TextView courseName){

        if(cursor.getString(cursor.getColumnIndex("courseName")).equals("인성과 리더십")){
            Log.d("inri102", "인성과 리더십");
            inriDBHelper = new inri_DBHelper(context, inriDBName, null, dbVersion);
            inriDB = inriDBHelper.getReadableDatabase();

            String sql102 = "SELECT * FROM inri_DB";
            Cursor cursor102 = inriDB.rawQuery(sql102, null);

            cursor102.moveToFirst();
            for(int i=0; i<cursor102.getCount(); i++){
                if(cursor102.getInt(cursor102.getColumnIndex("semester")) == 102){
                    String inriName101 = cursor102.getString(cursor102.getColumnIndex("courseName"));
                    courseName.setText(inriName101);

                }
                cursor102.moveToNext();
            }
        }
    }
    public void checkChangSa(Cursor cursor, Context context, TextView courseName){
        if(cursor.getString(cursor.getColumnIndex("courseName")).equals("창의와 사고")){
            changsa_dbHelper = new changsa_DBHelper(context, changsaDBName, null, dbVersion);
            ChangsaDB = changsa_dbHelper.getReadableDatabase();

            String sql101 = "SELECT * FROM changsa_DB";
            Cursor cursor101 = ChangsaDB.rawQuery(sql101, null);

            cursor101.moveToFirst();
            for(int i=0; i<cursor101.getCount(); i++){
                if(cursor101.getInt(cursor101.getColumnIndex("semester")) == 102){
                    String changsaName101 = cursor101.getString(cursor101.getColumnIndex("courseName"));
                    courseName.setText(changsaName101);
                }
                cursor101.moveToNext();
            }
        }
    }

    public void checkTrack(Cursor cursor, Context context, TextView courseName){
        track_dbHelper = new track_DBHelper(context, trackDBName, null, dbVersion);
        trackDB = track_dbHelper.getReadableDatabase();
        if(cursor.getString(cursor.getColumnIndex("courseName")).equals("트랙2")){
            String sql = "SELECT * FROM track_DB where semester is 2";
            cursor = trackDB.rawQuery(sql, null);

            cursor.moveToFirst();
            for(int i=0; i<cursor.getCount(); i++){
                if(cursor.getInt(cursor.getColumnIndex("checked")) == 1){
                    String trackName = cursor.getString(cursor.getColumnIndex("courseName"));
                    courseName.setText(trackName);
                }
                cursor.moveToNext();
            }
        }
        else if(cursor.getString(cursor.getColumnIndex("courseName")).equals("트랙4")){
            String sql = "SELECT * FROM track_DB where semester is 4";
            cursor = trackDB.rawQuery(sql, null);

            cursor.moveToFirst();
            for(int i=0; i<cursor.getCount(); i++){
                if(cursor.getInt(cursor.getColumnIndex("checked")) == 1){
                    String trackName = cursor.getString(cursor.getColumnIndex("courseName"));
                    courseName.setText(trackName);
                }
                cursor.moveToNext();
            }
        }
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.course_listlayout_2_x, parent, false);
        return v;
    }
}
