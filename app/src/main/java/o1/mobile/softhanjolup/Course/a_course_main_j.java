package o1.mobile.softhanjolup.Course;

import android.app.Dialog;
import android.content.ContentValues;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import o1.mobile.softhanjolup.Book.a_book_main_j;
import o1.mobile.softhanjolup.DB.course_DBHelper;
import o1.mobile.softhanjolup.English.a_english_main_j;
import o1.mobile.softhanjolup.MainActivity;
import o1.mobile.softhanjolup.R;
import o1.mobile.softhanjolup.Setting.InitialActivity;
import o1.mobile.softhanjolup.Volunteer.a_volun_main_j;

public class a_course_main_j extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    course_DBHelper dbHelper;
    SQLiteDatabase db;
    String sql;

    final static String dbName = "SHJU_DB.db";
    final static int dbVersion = 3;


    f_course_1st_j fragment1;
    f_course_2nd_j fragment2;
    f_course_3rd_j fragment3;
    f_course_4th_j fragment4;
    TabLayout tabs;
    NavigationView navigationView;
    TextView creditView;
    View headView;
    int calculatedCredit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_course_main_x);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_course_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        dbHelper = new course_DBHelper(this, dbName, null, dbVersion);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        headView = navigationView.getHeaderView(0);

        creditView = headView.findViewById(R.id.nav_creditView);
        calculatedCredit = calCredit();
        String creditText = getString(R.string.nav_credit1) +" "+ calculatedCredit + getString(R.string.nav_credit2);
        creditView.setText(creditText);

        TextView userName = headView.findViewById(R.id.nav_user_name);
        SharedPreferences prefName = getSharedPreferences("prefName", Context.MODE_PRIVATE);
        String Name = prefName.getString("userName","name");
        userName.setText(Name);

        {//tab 생성
            fragment1 = new f_course_1st_j();
            fragment2 = new f_course_2nd_j();
            fragment3 = new f_course_3rd_j();
            fragment4 = new f_course_4th_j();
            getSupportFragmentManager().beginTransaction().replace(R.id.containerCourseTab, fragment1).commit();

            tabs = (TabLayout) findViewById(R.id.course_tabs);
            tabs.addTab(tabs.newTab().setText("1학년"));
            tabs.addTab(tabs.newTab().setText("2학년"));
            tabs.addTab(tabs.newTab().setText("3학년"));
            tabs.addTab(tabs.newTab().setText("4학년"));

            tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    int position = tab.getPosition();

                    Fragment selected = null;
                    if (position == 0) selected = fragment1;
                    else if (position == 1) selected = fragment2;
                    else if (position == 2) selected = fragment3;
                    else if (position == 3) selected = fragment4;

                    getSupportFragmentManager().beginTransaction().replace(R.id.containerCourseTab, selected).commit();
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });
        }
    }

    public void updateCredit(){
        creditView = headView.findViewById(R.id.nav_creditView);
        int tempC = calCredit();
        String creditText = getString(R.string.nav_credit1) + tempC + getString(R.string.nav_credit2);
        creditView.setText(creditText);
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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_course_drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //메뉴 ...버튼
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.course_option_menu, menu);
        return true;
    }

    Dialog dialogAdd;
    Spinner course_new_year;
    Spinner course_new_semester;
    EditText course_new_courseName;
    EditText course_new_credit;
    Button newCourseAddBtn;
    int newYear = 1;
    int newSemester = 1;
    String newCourse = "new";
    String newCredit = "0";

    Dialog dialogDel;
    Spinner course_del_year;
    Spinner course_del_semester;
    EditText course_del_courseName;
    Button course_delBtn;
    int delYear = 1;
    int delSemester = 1;
    String delCourse = "del";


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.course_action_add) {
            dialogAdd = new Dialog(a_course_main_j.this);

            dialogAdd.setContentView(R.layout.course_add_record_x);

            course_new_year = dialogAdd.findViewById(R.id.course_new_year);
            course_new_semester = dialogAdd.findViewById(R.id.course_new_semester);
            course_new_courseName = dialogAdd.findViewById(R.id.course_new_courseName);
            course_new_credit = dialogAdd.findViewById(R.id.course_new_credit);
            newCourseAddBtn = dialogAdd.findViewById(R.id.course_new_addBtn);

            course_new_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    newYear = position+1;
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) { newYear = 1; }
            });
            course_new_semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    newSemester = position+1;
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) { newSemester = 1;}
            });

            newCourseAddBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    newCourse = course_new_courseName.getText().toString();
                    newCredit = course_new_credit.getText().toString();
                    insert(newYear, newSemester,newCourse, Integer.parseInt(newCredit));
                    dialogAdd.dismiss();
                }
            });

            dialogAdd.show();

            return true;
        }
        else if(id == R.id.course_action_delete){
            dialogDel = new Dialog(a_course_main_j.this);

            dialogDel.setContentView(R.layout.course_delete_record_x);

            course_del_year = dialogDel.findViewById(R.id.course_del_year);
            course_del_semester = dialogDel.findViewById(R.id.course_del_semester);
            course_del_courseName = dialogDel.findViewById(R.id.course_del_courseName);
            course_delBtn = dialogDel.findViewById(R.id.course_delBtn);

            course_del_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    delYear = position+1;
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) { delYear = 1; }
            });
            course_del_semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    delSemester = position+1;
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) { delSemester = 1;}
            });

            course_delBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    delCourse = course_del_courseName.getText().toString();
                    delete(delYear, delSemester,delCourse);
                    dialogDel.dismiss();
                }
            });

            dialogDel.show();
        }
        else if(id == R.id.course_action_other){
            Intent intent = new Intent(getApplicationContext(), a_course_otherDB_j.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }

    public void delete(int year, int semester, String courseName){
        db=dbHelper.getWritableDatabase();

        db.delete("DB_Course", "year = ? and semester = ? and courseName = ?", new String[]{Integer.toString(year), Integer.toString(semester), courseName});

    }

    int newId = 0;
    //id, year, semester, courseName, credit, index, done
    public void insert(int year, int semester, String courseName, int credit){

        int tempID = 80+newId;
        db=dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id", tempID);
        values.put("year", year);
        values.put("semester", semester);
        values.put("courseName", courseName);
        values.put("credit", credit);
        values.put("index_course", 7);//일반선택
        values.put("done", 0);
        newId++;

        db.insert("DB_Course", null, values);
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
            Bundle bundle = new Bundle();
            bundle.putInt("isFirst", 1);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        finish();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_course_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
