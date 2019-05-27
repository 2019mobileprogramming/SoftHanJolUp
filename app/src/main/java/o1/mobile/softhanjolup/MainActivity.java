package o1.mobile.softhanjolup;

import android.content.ContentValues;
import android.content.Intent;
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

    final static String dbName = "SHJU_DB.db";
    final static int dbVersion = 3;

Button Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titleView = findViewById(R.id.editText1);
        contentView = findViewById(R.id.editText2);
        Btn = findViewById(R.id.tempBtn);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        calculatedCredit = bundle.getInt("credit");

        headView = navigationView.getHeaderView(0);
        creditView = headView.findViewById(R.id.nav_creditView);
        String creditText = getString(R.string.nav_credit1) + calculatedCredit + getString(R.string.nav_credit2);
        creditView.setText(creditText);
        Btn.setText(creditText);


        dbHelper = new course_DBHelper(this, dbName, null, dbVersion);

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
    public boolean onCreateOptionsMenu(Menu menu) {  //메뉴 ...버튼
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //Fragment myFragment = null;
        //Class fragmentClass;

        if (id == R.id.SideHomee) {//홈 창으로 이동
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);


        } else if (id == R.id.SideCourse) {//교육과정 창으로 이동
            Intent intent = new Intent(getApplicationContext(), a_course_main_j.class);
            startActivity(intent);


            //fragmentClass = f_course_main_j.class;

        }  else if (id == R.id.SideCourse) {//교육과정 창으로 이동
            Intent intent = new Intent(getApplicationContext(), a_course_main_j.class);
            startActivity(intent);
            //fragmentClass = f_course_main_j.class;


        } else if (id == R.id.SideVolun) {//봉사활동 창으로 이동
            Intent intent = new Intent(getApplicationContext(), a_volun_main_j.class);
            startActivity(intent);


        } else if (id == R.id.SideTOEIC) {//토익 창으로 이동
            Intent intent = new Intent(getApplicationContext(), a_english_main_j.class);
            startActivity(intent);


        } else if (id == R.id.SideBook) {//독후감 창으로 이동
            Intent intent = new Intent(getApplicationContext(), a_book_main_j.class);
            startActivity(intent);

        }
        finish();

       // FragmentManager fragmentManager = getSupportFragmentManager();
       // fragmentManager.beginTransaction().replace(R.id.flcontent, myFragment).commit();//화면 바꾸기


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
