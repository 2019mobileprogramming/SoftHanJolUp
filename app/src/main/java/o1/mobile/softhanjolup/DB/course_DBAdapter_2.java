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

public class course_DBAdapter_2 extends CursorAdapter {
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
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.course_listlayout_2_x, parent, false);
        return v;
    }
}
