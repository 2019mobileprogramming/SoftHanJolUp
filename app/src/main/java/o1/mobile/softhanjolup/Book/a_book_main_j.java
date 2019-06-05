package o1.mobile.softhanjolup.Book;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import o1.mobile.softhanjolup.Course.a_course_main_j;
import o1.mobile.softhanjolup.DB.course_DBHelper;
import o1.mobile.softhanjolup.English.a_english_main_j;
import o1.mobile.softhanjolup.Init.info_first_j;
import o1.mobile.softhanjolup.Init.info_more_j;
import o1.mobile.softhanjolup.MainActivity;
import o1.mobile.softhanjolup.R;
import o1.mobile.softhanjolup.Init.InitialActivity;
import o1.mobile.softhanjolup.Volunteer.a_volun_main_j;

public class a_book_main_j extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    f_book_dept_j fragment1;
    f_book_uni_j fragment2;
    f_book_memo_j fragment3;
    TabLayout tabs;

    course_DBHelper dbHelper;
    SQLiteDatabase db;
    String sql;
    int calculatedCredit=0;
    TextView creditView;
    View headView;
    final static String dbName = "SHJU_DB.db";
    final static int dbVersion = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_book_main_x);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbHelper = new course_DBHelper(this, dbName, null, dbVersion);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_book_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //네비바 만들기
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        calculatedCredit =calCredit();

        headView = navigationView.getHeaderView(0);
        creditView = headView.findViewById(R.id.nav_creditView);
        String creditText = getString(R.string.nav_credit1) +" "+ calculatedCredit + getString(R.string.nav_credit2);
        creditView.setText(creditText);
        //네비바에 학점 표시

        TextView userName = headView.findViewById(R.id.nav_user_name);
        SharedPreferences prefName = getSharedPreferences("prefName", Context.MODE_PRIVATE);
        userName.setText(prefName.getString("userName","name"));
        //네비바에 이름 표시




        fragment1 = new f_book_dept_j();
        fragment2 = new f_book_uni_j();
        fragment3 = new f_book_memo_j();
        getSupportFragmentManager().beginTransaction().replace(R.id.containerBookTab, fragment1).commit();

        tabs = (TabLayout) findViewById(R.id.book_tabs);
        tabs.addTab(tabs.newTab().setText("학과 지정도서"));
        tabs.addTab(tabs.newTab().setText("학교 지정도서"));
        tabs.addTab(tabs.newTab().setText("독후감"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                int position = tab.getPosition();

                Fragment selected = null;
                if(position == 0)   selected = fragment1;
                else if(position == 1)   selected = fragment2;
                else if(position == 2)   selected = fragment3;

                getSupportFragmentManager().beginTransaction().replace(R.id.containerBookTab, selected).commit();
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab){}
            @Override
            public void onTabReselected(TabLayout.Tab tab){}
        });

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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_book_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
        } else if (id == R.id.SideVolun) {//봉사활동 창으로 이동
            Intent intent = new Intent(getApplicationContext(), a_volun_main_j.class);
            startActivity(intent);
        } else if (id == R.id.SideTOEIC) {//토익 창으로 이동
            Intent intent = new Intent(getApplicationContext(), a_english_main_j.class);
            startActivity(intent);
        } else if (id == R.id.SideBook) {//독후감 창으로 이동
            Intent intent = new Intent(getApplicationContext(), a_book_main_j.class);
            startActivity(intent);
        } else if (id == R.id.SideHow){
            Intent intent = new Intent(getApplicationContext(), info_more_j.class);
            startActivity(intent);
        }else if(id == R.id.SideSetting){
            Intent intent = new Intent(getApplicationContext(), InitialActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("isFirst", 1);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        finish();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_book_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
