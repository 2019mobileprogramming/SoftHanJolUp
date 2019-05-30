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
    SQLiteDatabase inriDB;

    final static String inriDBName = "INRI.db";
    final static int dbVersion = 3;

    public course_DBAdapter_2(Context context, Cursor c){
        super(context, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final TextView year2 = view.findViewById(R.id.year2);
        final TextView semester2 = view.findViewById(R.id.semester2);
        final TextView courseName2 = view.findViewById(R.id.courseName2);
        final TextView credit2 = view.findViewById(R.id.credit2);
        final TextView index_course2 = view.findViewById(R.id.index_course2);
        final RelativeLayout listParent = view.findViewById(R.id.courseListParent2);

        year2.setText(cursor.getString(cursor.getColumnIndex("year")));
        semester2.setText(cursor.getString(cursor.getColumnIndex("semester")));
        courseName2.setText(cursor.getString(cursor.getColumnIndex("courseName")));
        credit2.setText(cursor.getString(cursor.getColumnIndex("credit")));
        index_course2.setText(cursor.getString(cursor.getColumnIndex("index_course")));

        if(cursor.getInt(cursor.getColumnIndex("done")) == 0){
            listParent.setBackgroundColor(context.getResources().getColor(R.color.nodoneBackground));
        }
        else{
            listParent.setBackgroundColor(context.getResources().getColor(R.color.doneBackground));
        }

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
                    courseName2.setText(inriName101);

                }
                cursor102.moveToNext();
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
