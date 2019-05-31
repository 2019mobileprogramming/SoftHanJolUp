package o1.mobile.softhanjolup;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import o1.mobile.softhanjolup.Book.a_book_main_j;
import o1.mobile.softhanjolup.Course.a_course_main_j;
import o1.mobile.softhanjolup.DB.course_DBAdapter;
import o1.mobile.softhanjolup.DB.course_DBHelper;
import o1.mobile.softhanjolup.English.a_english_main_j;
import o1.mobile.softhanjolup.Setting.InitialActivity;
import o1.mobile.softhanjolup.Volunteer.a_volun_main_j;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
EditText titleView, contentView;

    course_DBHelper dbHelper;
    SQLiteDatabase db;
    String sql;
    int calculatedCredit=0;
    TextView creditView;
    View headView;
    TextView creditInfo1, creditInfo2;

    final static String dbName = "SHJU_DB.db";
    final static int dbVersion = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dbHelper = new course_DBHelper(this, dbName, null, dbVersion);

        titleView = findViewById(R.id.editText1);
        contentView = findViewById(R.id.editText2);
        creditInfo1 = findViewById(R.id.creditInfo1);
        creditInfo2 = findViewById(R.id.creditInfo2);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        calculatedCredit =calCredit();

        headView = navigationView.getHeaderView(0);
        creditView = headView.findViewById(R.id.nav_creditView);
        String creditText = getString(R.string.nav_credit1) + calculatedCredit + getString(R.string.nav_credit2);
        creditView.setText(creditText);
        creditInfo1.setText("졸업까지");
        int tempCredit = 120 - calculatedCredit;
        creditText =  tempCredit + "학점 남았어요!";
        creditInfo2.setText(creditText);

        TextView userName = headView.findViewById(R.id.nav_user_name);
        SharedPreferences prefName = getSharedPreferences("prefName", Context.MODE_PRIVATE);
        String Name = prefName.getString("userName","name");
        userName.setText(Name);



    }

    Cursor cursor;
    public int calCredit(){
        int tempCredit=0;

        db=dbHelper.getReadableDatabase();
        sql = "select * from DB_Course where done is 1";

        cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        for(int i = 0; i<cursor.getCount(); i++){
            tempCredit += cursor.getInt(cursor.getColumnIndex("credit"));
            cursor.moveToNext();
        }

        return tempCredit;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.SideHomee) {//홈 창으로 이동
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.SideCourse) {//교육과정 창으로 이동
            Intent intent = new Intent(getApplicationContext(), a_course_main_j.class);
            startActivity(intent);
        }  else if (id == R.id.SideCourse) {//교육과정 창으로 이동
            Intent intent = new Intent(getApplicationContext(), a_course_main_j.class);
            startActivity(intent);
        } else if (id == R.id.SideVolun) {//봉사활동 창으로 이동
            Intent intent = new Intent(getApplicationContext(), a_volun_main_j.class);
            startActivity(intent);
        } else if (id == R.id.SideTOEIC) {//토익 창으로 이동
            Intent intent = new Intent(getApplicationContext(), a_english_main_j.class);
            startActivity(intent);
        } else if (id == R.id.SideBook) {//독후감 창으로 이동
            Intent intent = new Intent(getApplicationContext(), a_book_main_j.class);
            startActivity(intent);
        } else if(id == R.id.SideSetting){
            Intent intent = new Intent(getApplicationContext(), InitialActivity.class);
            startActivity(intent);
        }
        finish();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
