package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import o1.mobile.softhanjolup.R;

public class DeptBook_DBAdapter extends CursorAdapter {
    public DeptBook_DBAdapter(Context context, Cursor c){
        super(context, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor){
        //bookNum integer, title string, author string
        final TextView title;
        title = view.findViewById(R.id.title );
        final TextView author = (TextView)view.findViewById(R.id.author);

        //bookNum.setText("Index : "+cursor.getInt(cursor.getColumnIndex("bookNum")));
        title.setText(cursor.getString(cursor.getColumnIndex("title")));
        author.setText(cursor.getString(cursor.getColumnIndex("author")));

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.book_listlayout_x, parent, false);
        return v;
    }
}
