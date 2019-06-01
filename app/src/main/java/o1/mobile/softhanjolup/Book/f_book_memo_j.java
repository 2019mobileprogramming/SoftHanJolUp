package o1.mobile.softhanjolup.Book;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Templates;

import o1.mobile.softhanjolup.DB.Book_memo_DBHelper;
import o1.mobile.softhanjolup.DB.DeptBook_DBAdapter;
import o1.mobile.softhanjolup.DB.DeptBook_DBHelper;
import o1.mobile.softhanjolup.R;


public class f_book_memo_j extends Fragment {

    ListView list;
    Book_memo_DBHelper book_memo_dbHelper;
    SQLiteDatabase memoDB;
    String sql;
    Cursor cursor;

    final static String memoDBName = "MEMO.db";
    final static int dbVersion = 2;

    TextView memoNull;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.f_book_memo_x, container, false);

        list = (ListView)rootView.findViewById(R.id.book_memo_list);
        memoNull = rootView.findViewById(R.id.book_memo_null);
        book_memo_dbHelper = new Book_memo_DBHelper(getActivity(), memoDBName, null, dbVersion);

        selectDB();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                cursor.moveToPosition(position);
                String str = cursor.getString(cursor.getColumnIndex("title"));
                Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id){
                cursor.moveToPosition(position);
                String bookName = cursor.getString(cursor.getColumnIndex("title"));
                String bookAuthor = cursor.getString(cursor.getColumnIndex("author"));

                Intent intent = new Intent(getActivity(), a_book_memo_j.class);
                Bundle bundle = new Bundle();
                bundle.putString("bookName", bookName);
                bundle.putString("bookAuthor", bookAuthor);
                intent.putExtras(bundle);
                startActivity(intent);

                return true;
            }
        });

        return rootView;
    }

    private void selectDB(){
        memoDB = book_memo_dbHelper.getWritableDatabase();
        sql = "SELECT * FROM memoBook;";

        cursor = memoDB.rawQuery(sql, null);

        if(cursor.getCount() > 0){
            getActivity().startManagingCursor(cursor);
            DeptBook_DBAdapter dbAdapter = new DeptBook_DBAdapter(getActivity(), cursor);
            list.setAdapter(dbAdapter);
        }
        else{
            memoNull.setVisibility(View.VISIBLE);
        }
    }


}
