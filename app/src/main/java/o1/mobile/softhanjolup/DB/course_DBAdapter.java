package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import o1.mobile.softhanjolup.R;

public class course_DBAdapter extends CursorAdapter {
    public course_DBAdapter(Context context, Cursor c){
        super(context, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final TextView year = view.findViewById(R.id.year);
        final TextView semester = view.findViewById(R.id.semester);
        final TextView courseName = view.findViewById(R.id.courseName);
        final TextView credit = view.findViewById(R.id.credit);
        final TextView index_course = view.findViewById(R.id.index_course);
        final RelativeLayout listParent = view.findViewById(R.id.courseListParent);

        year.setText(cursor.getString(cursor.getColumnIndex("year")));
        semester.setText(cursor.getString(cursor.getColumnIndex("semester")));
        courseName.setText(cursor.getString(cursor.getColumnIndex("courseName")));
        credit.setText(cursor.getString(cursor.getColumnIndex("credit")));
        index_course.setText(cursor.getString(cursor.getColumnIndex("index_course")));

        if(cursor.getInt(cursor.getColumnIndex("done")) == 0){
            listParent.setBackgroundColor(context.getResources().getColor(R.color.nodoneBackground));
        }
        else{
            listParent.setBackgroundColor(context.getResources().getColor(R.color.doneBackground));
        }
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.course_listlayout_x, parent, false);
        return v;
    }
}
