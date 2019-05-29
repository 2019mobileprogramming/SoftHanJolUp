package o1.mobile.softhanjolup.Book;

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
import android.widget.Toast;

import o1.mobile.softhanjolup.DB.DeptBook_DBAdapter;
import o1.mobile.softhanjolup.DB.DeptBook_DBHelper;
import o1.mobile.softhanjolup.R;



public class f_book_dept_j extends Fragment {

    ListView list;
    DeptBook_DBHelper dbHelper;
    SQLiteDatabase db;
    String sql;
    Cursor cursor;

    final static String dbName = "DeptBook.db";
    final static int dbVersion = 2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.f_book_dept_x, container, false);

        list = (ListView)rootView.findViewById(R.id.book_list);
        dbHelper = new DeptBook_DBHelper(getActivity(), dbName, null, dbVersion);

        selectDB();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                cursor.moveToPosition(position);
                String str = cursor.getString(cursor.getColumnIndex("title"));
                Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void selectDB(){
        db = dbHelper.getWritableDatabase();
        sql = "SELECT * FROM DeptBook;";

        cursor = db.rawQuery(sql, null);
        if(cursor.getCount() > 0){
            getActivity().startManagingCursor(cursor);
            DeptBook_DBAdapter dbAdapter = new DeptBook_DBAdapter(getActivity(), cursor);
            list.setAdapter(dbAdapter);
        }
    }


}
