package o1.mobile.softhanjolup.Volunteer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
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
import o1.mobile.softhanjolup.DB.course_DBHelper;
import o1.mobile.softhanjolup.English.a_english_main_j;
import o1.mobile.softhanjolup.MainActivity;
import o1.mobile.softhanjolup.R;
import o1.mobile.softhanjolup.Setting.InitialActivity;

public class a_volun_main_j extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    course_DBHelper dbHelper;
    SQLiteDatabase db;
    String sql;
    int calculatedCredit=0;
    TextView creditView;
    View headView;

    final static String dbName = "SHJU_DB.db";
    final static int dbVersion = 3;

    EditText edit_VMS;
    Button VMSBtn, Btn_1365;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_volun_main_x);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edit_VMS = findViewById(R.id.edit_VMS);
        VMSBtn = findViewById(R.id.VMSBtn);
        Btn_1365 = findViewById(R.id.Btn_1365);

        dbHelper = new course_DBHelper(this, dbName, null, dbVersion);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_volun_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        calculatedCredit =calCredit();
        headView = navigationView.getHeaderView(0);
        creditView = headView.findViewById(R.id.nav_creditView);
        String creditText = getString(R.string.nav_credit1) +" "+ calculatedCredit + getString(R.string.nav_credit2);
        creditView.setText(creditText);

        TextView userName = headView.findViewById(R.id.nav_user_name);
        SharedPreferences prefName = getSharedPreferences("prefName", Context.MODE_PRIVATE);
        String Name = prefName.getString("userName","name");
        userName.setText(Name);


        VMSBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String address1 = "https://www.vms.or.kr/partspace/inquiry.do?area=&legalcode=&centtype=&centname=&addr1=&program=";
                String address2 = "&page=1";
                String url = address1 + edit_VMS.getText() + address2;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        Btn_1365.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String url = "https://www.1365.go.kr/vols/P9210/partcptn/timeCptn.do";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_volun_drawer_layout);
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
        }else if(id == R.id.SideSetting){
            Intent intent = new Intent(getApplicationContext(), InitialActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("isFirst", 1);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        finish();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_volun_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
