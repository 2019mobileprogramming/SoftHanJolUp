package o1.mobile.softhanjolup.Course;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import o1.mobile.softhanjolup.DB.course_DBAdapter;
import o1.mobile.softhanjolup.DB.course_DBAdapter_2;
import o1.mobile.softhanjolup.DB.course_DBHelper;
import o1.mobile.softhanjolup.R;

public class f_course_2nd_j  extends Fragment {

    ListView list, list2;
    course_DBHelper dbHelper;
    SQLiteDatabase db;
    String sql;
    Cursor cursor;

    final static String dbName = "SHJU_DB.db";
    final static int dbVersion = 3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.f_course_2nd_x, container, false);

        dbHelper = new course_DBHelper(getActivity(), dbName, null, dbVersion);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        list = (ListView)rootView.findViewById(R.id.second_list);
        list2 = (ListView)rootView.findViewById(R.id.second_2_list);
        selectDB();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Cursor se1 = se1Index(position);
                String str = se1.getString(se1.getColumnIndex("courseName"));
                Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Cursor se1 = se2Index(position);
                String str = se1.getString(se1.getColumnIndex("courseName"));
                Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id){
                Cursor se1 = se1Index(position);
                String str = se1.getString(se1.getColumnIndex("courseName"));
                //Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();

                RelativeLayout tempRel = (RelativeLayout)v;
                if(se1.getInt(se1.getColumnIndex("done")) == 0)
                {
                    tempRel.setBackgroundColor(getResources().getColor(R.color.doneBackground));
                    updateDone(str,1);
                    ((a_course_main_j)getActivity()).updateCredit();
                } else {
                    tempRel.setBackgroundColor(getResources().getColor(R.color.nodoneBackground));
                    updateDone(str,0);
                    ((a_course_main_j)getActivity()).updateCredit();
                }
                return true;
            }
        });

        list2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id){
                Cursor se = se2Index(position);
                String str = se.getString(se.getColumnIndex("courseName"));
                //Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();

                RelativeLayout tempRel = (RelativeLayout)v;
                if(se.getInt(se.getColumnIndex("done")) == 0)
                {
                    tempRel.setBackgroundColor(getResources().getColor(R.color.doneBackground));
                    updateDone(str,1);
                    ((a_course_main_j)getActivity()).updateCredit();
                } else {
                    tempRel.setBackgroundColor(getResources().getColor(R.color.nodoneBackground));
                    updateDone(str,0);
                    ((a_course_main_j)getActivity()).updateCredit();
                }
                return true;
            }
        });

        return rootView;
    }
    public void updateDone(String name, int done){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("done",done);
        db.update("DB_Course", values, "courseName = ?", new String[]{name});
    }
    private Cursor se1Index(int positon) {
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM DB_Course where year is 2 and semester is 1;";
        Cursor tempC = db.rawQuery(sql, null);
        tempC.moveToPosition(positon);

        return tempC;
    }
    private Cursor se2Index(int positon) {
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM DB_Course where year is 2 and semester is 2;";
        Cursor tempC = db.rawQuery(sql, null);
        tempC.moveToPosition(positon);

        return tempC;
    }

    private void selectDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM DB_Course where year is 2 and semester is 1;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            getActivity().startManagingCursor(cursor);
            course_DBAdapter dbAdapter = new course_DBAdapter(getActivity(), cursor);
            list.setAdapter(dbAdapter);
        }
        sql = "SELECT * FROM DB_Course where year is 2 and semester is 2;";

        cursor = db.rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            getActivity().startManagingCursor(cursor);
            course_DBAdapter_2 dbAdapter = new course_DBAdapter_2(getActivity(), cursor);
            list2.setAdapter(dbAdapter);
        }
    }
}