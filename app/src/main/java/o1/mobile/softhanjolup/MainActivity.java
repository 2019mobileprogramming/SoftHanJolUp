package o1.mobile.softhanjolup;

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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import o1.mobile.softhanjolup.Book.a_book_main_j;
import o1.mobile.softhanjolup.Course.a_course_main_j;
import o1.mobile.softhanjolup.DB.changsa_DBHelper;
import o1.mobile.softhanjolup.DB.course_DBHelper;
import o1.mobile.softhanjolup.DB.inri_DBHelper;
import o1.mobile.softhanjolup.DB.track_DBHelper;
import o1.mobile.softhanjolup.English.a_english_main_j;
import o1.mobile.softhanjolup.Init.InitialActivity;
import o1.mobile.softhanjolup.Init.info_first_j;
import o1.mobile.softhanjolup.Init.info_more_j;
import o1.mobile.softhanjolup.Volunteer.a_volun_main_j;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    course_DBHelper dbHelper;
    inri_DBHelper inriDBHelper;
    changsa_DBHelper changsa_dbHelper;
    track_DBHelper track_dbHelper;
    SQLiteDatabase inriDB, ChangsaDB, trackDB;

    SQLiteDatabase db;
    String sql;
    int calculatedCredit=0;
    TextView creditView;
    View headView;
    TextView creditInfo1, creditInfo2;
    ArrayList<TextView> creditList = new ArrayList<>();

    final static String dbName = "SHJU_DB.db";
    final static int dbVersion = 3;
    final static String inriDBName = "INRI.db";
    final static String changsaDBName = "CHANGSA.db";
    final static String trackDBName = "TRACK.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbHelper = new course_DBHelper(this, dbName, null, dbVersion);
        inriDBHelper = new inri_DBHelper(this, inriDBName, null, dbVersion);
        changsa_dbHelper = new changsa_DBHelper(this, changsaDBName, null, dbVersion);
        track_dbHelper = new track_DBHelper(this, trackDBName, null, dbVersion);

        creditInfo1 = findViewById(R.id.creditInfo1);
        creditInfo2 = findViewById(R.id.creditInfo2);

        //기쵸교양 -----------------------------------------------
        creditList.add((TextView)findViewById(R.id.basic0));
        creditList.add((TextView)findViewById(R.id.basic1));
        creditList.add((TextView)findViewById(R.id.basic2));
        creditList.add((TextView)findViewById(R.id.basic3));
        //융합교양
        creditList.add((TextView)findViewById(R.id.mix0));
        creditList.add((TextView)findViewById(R.id.mix1));
        //일반선택
        creditList.add((TextView)findViewById(R.id.gen0));
        creditList.add((TextView)findViewById(R.id.gen1));
        creditList.add((TextView)findViewById(R.id.gen2));
        //전공
        creditList.add((TextView)findViewById(R.id.major0));
        creditList.add((TextView)findViewById(R.id.major1));
        creditList.add((TextView)findViewById(R.id.major2));
        //총합
        creditList.add((TextView)findViewById(R.id.totalScore));
        //--------------------------------------------------------


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        calculatedCredit =calCredit();

        headView = navigationView.getHeaderView(0);
        creditView = headView.findViewById(R.id.nav_creditView);
        String creditText = getString(R.string.nav_credit1) +" "+ calculatedCredit + getString(R.string.nav_credit2);
        creditView.setText(creditText);
        creditInfo1.setText("졸업까지");
        int tempCredit = 120 - calculatedCredit;
        creditText =  tempCredit + "학점 남았어요!";
        creditInfo2.setText(creditText);

        TextView userName = headView.findViewById(R.id.nav_user_name);
        SharedPreferences prefName = getSharedPreferences("prefName", Context.MODE_PRIVATE);
        String Name = prefName.getString("userName","name");
        userName.setText(Name);

        int totalCredit = 0;
        int k = 0;
        for(k=0; k<12; k++){
            showCredit(k);
            totalCredit += Integer.parseInt(creditList.get(k).getText().toString());
        }
        creditList.get(12).setText(Integer.toString(totalCredit));

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

    public void showCredit(int index){
        int tempCredit=0;

        db=dbHelper.getReadableDatabase();
        inriDB = inriDBHelper.getReadableDatabase();
        ChangsaDB = changsa_dbHelper.getReadableDatabase();
        trackDB = track_dbHelper.getReadableDatabase();

        if (index == 0){
            sql = "select * from DB_Course where courseName = '과학기술 글쓰기' or courseName = 'Practical English1' or courseName = 'Practical English2' or courseName = 'Practical English3' or courseName = 'Practical English4'";
        }
        else if (index == 1){
            sql = "select * from DB_Course where courseName = '소프트웨어 생태계'";
        }
        else if (index == 2){
            sql = "select * from DB_Course where courseName = '인성과 리더십' or courseName = '인성세미나' or courseName = '진로세미나'";
        }
        else if (index == 3){
            sql = "select * from DB_Course where courseName = '창의와 사고'";
        }
        else if (index == 4){ //융합교양 ---------------------------------------------------------------------------------------------------------
            sql = "select * from DB_Course where courseName = '글로벌리더십'";
        }
        else if (index == 5){
            sql = "select * from DB_Course where courseName = '세계와 문화'";
        }
        else if (index == 6){  //일반선택 ------------------------------------------------------------------------------------------
            sql = "select * from DB_Course where courseName = 'Business English'";
        }
        else if (index == 7){
            sql = "select * from DB_Course where courseName = '사회와 역사'";
        }
        else if (index == 8){
            sql = "select * from DB_Course where index_course = 7";
        }
        else if (index == 9){  //전공 ---------------------------------------------------------------------------------------------
            sql = "select * from DB_Course where index_course = 5";
        }
        else if (index == 10){
            sql = "select * from DB_Course where index_course = 6";
        }
        else if (index == 11){
            sql = "select * from DB_Course where index_course = 4";
        }


        cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        for(int i = 0; i<cursor.getCount(); i++){
                if(cursor.getString(cursor.getColumnIndex("courseName")).equals("인성과 리더십")) {
                    if(cursor.getInt(cursor.getColumnIndex("done")) == 1){
                        int semester = cursor.getInt(cursor.getColumnIndex("semester"));
                        String checkSql = "select * from inri_DB where semester is 10"+semester;
                        Log.d("tag",checkSql);
                        Cursor cursorInri = inriDB.rawQuery(checkSql, null);
                        if(cursorInri != null){
                            tempCredit += cursor.getInt(cursor.getColumnIndex("credit"));
                            Log.d("tag",cursor.getString(cursor.getColumnIndex("courseName"))+" : "+tempCredit);
                        }
                    }
                }
                else if(cursor.getString(cursor.getColumnIndex("courseName")).equals("창의와 사고")){
                    if(cursor.getInt(cursor.getColumnIndex("done")) == 1) {

                        int semester = cursor.getInt(cursor.getColumnIndex("semester"));
                        String checkSql = "select * from changsa_DB where semester is 10"+semester;
                        Cursor cursorChansa = ChangsaDB.rawQuery(checkSql, null);
                        if(cursorChansa != null){
                            tempCredit += cursor.getInt(cursor.getColumnIndex("credit"));
                            Log.d("tag",cursor.getString(cursor.getColumnIndex("courseName"))+" : "+tempCredit);
                        }
                    }
                }
                else if(cursor.getString(cursor.getColumnIndex("courseName")).startsWith("트랙")){
                    if(cursor.getInt(cursor.getColumnIndex("done")) == 1) {
                        int semester = cursor.getInt(cursor.getColumnIndex("semester"));
                        int year = cursor.getInt(cursor.getColumnIndex("year"));
                        int YS = (year - 3)*2 + semester;

                            String checkSql = "select * from track_DB where semester is "+YS;
                            Cursor cursorTrack = trackDB.rawQuery(checkSql, null);
                            if(cursorTrack != null){
                                tempCredit += cursor.getInt(cursor.getColumnIndex("credit"));
                                Log.d("tag",cursor.getString(cursor.getColumnIndex("courseName"))+" : "+tempCredit);
                            }


                    }
                }
                else {
                    if(cursor.getInt(cursor.getColumnIndex("done")) == 1) {
                        tempCredit += cursor.getInt(cursor.getColumnIndex("credit"));
                        Log.d("tag",cursor.getString(cursor.getColumnIndex("courseName"))+" : "+tempCredit);
                    }
                }
            cursor.moveToNext();
        }
        creditList.get(index).setText(Integer.toString(tempCredit));
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
        } else if (id == R.id.SideHow){
            Intent intent = new Intent(getApplicationContext(), info_more_j.class);
            startActivity(intent);
        } else if(id == R.id.SideSetting){
            Intent intent = new Intent(getApplicationContext(), InitialActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("isFirst", 1);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        finish();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
