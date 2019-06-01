package o1.mobile.softhanjolup.Book;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import o1.mobile.softhanjolup.DB.Book_memo_DBHelper;
import o1.mobile.softhanjolup.DB.DeptBook_DBAdapter;
import o1.mobile.softhanjolup.R;

public class a_book_memo_j extends AppCompatActivity {


    ListView list;
    Book_memo_DBHelper book_memo_dbHelper;
    SQLiteDatabase memoDB;
    String sql;
    Cursor cursor;

    final static String memoDBName = "MEMO.db";
    final static int dbVersion = 2;

    Button confirm;
    ArrayList<EditText> contentList = new ArrayList<>();
    String bookName, bookAuthor;
    TextView nameView, authorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_book_memo_x);

        book_memo_dbHelper = new Book_memo_DBHelper(this, memoDBName, null, dbVersion);

        Intent intent = getIntent();
        Bundle bookInfo = intent.getExtras();
        bookName = bookInfo.getString("bookName");
        bookAuthor = bookInfo.getString("bookAuthor");

        confirm = findViewById(R.id.book_memo_confirm);
        nameView = findViewById(R.id.book_memo_name);
        authorView = findViewById(R.id.book_memo_author);

        nameView.setText(bookName);
        authorView.setText(bookAuthor);

        contentList.add((EditText)findViewById(R.id.book_memo_content1));
        contentList.add((EditText)findViewById(R.id.book_memo_content2));
        contentList.add((EditText)findViewById(R.id.book_memo_content3));
        contentList.add((EditText)findViewById(R.id.book_memo_content4));
        contentList.add((EditText)findViewById(R.id.book_memo_content5));

        for(int i=0; i<5; i++){
            contentList.get(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (motionEvent.getAction() & MotionEvent.ACTION_MASK){
                        case MotionEvent.ACTION_UP:
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                    return false;
                }
            });
        }

        selectDB();

        confirm.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                memoDB = book_memo_dbHelper.getWritableDatabase();
                sql = "SELECT * FROM memoBook;";
                cursor = memoDB.rawQuery(sql, null);

                ContentValues values = new ContentValues();
                values.put("title", bookName);
                values.put("author", bookAuthor);
                values.put("content1", contentList.get(0).getText().toString());
                values.put("content2", contentList.get(1).getText().toString());
                values.put("content3", contentList.get(2).getText().toString());
                values.put("content4", contentList.get(3).getText().toString());
                values.put("content5", contentList.get(4).getText().toString());

                if(cursor.getCount() > 0){//업데이트
                    memoDB.update("memoBook", values, "title=? and author=?", new String[]{bookName, bookAuthor});
                }
                else{//추가
                    memoDB.insert("memoBook", null, values);
                }

                finish();
            }
        });
    }

    private void selectDB(){
        memoDB = book_memo_dbHelper.getWritableDatabase();
        sql = "SELECT * FROM memoBook;where title='"+bookName+"' and author='"+bookAuthor+"'";

        cursor = memoDB.rawQuery(sql, null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            Log.d("contentList",Integer.toString(cursor.getColumnIndex("content1")));
            Log.d("contentList",cursor.getString(0));
            contentList.get(0).setText(cursor.getString(cursor.getColumnIndex("content1")));
            contentList.get(1).setText(cursor.getString(cursor.getColumnIndex("content2")));
            contentList.get(2).setText(cursor.getString(cursor.getColumnIndex("content3")));
            contentList.get(3).setText(cursor.getString(cursor.getColumnIndex("content4")));
            contentList.get(4).setText(cursor.getString(cursor.getColumnIndex("content5")));
        }
    }
}
