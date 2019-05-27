package o1.mobile.softhanjolup.English;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import o1.mobile.softhanjolup.Book.a_book_main_j;
import o1.mobile.softhanjolup.Course.a_course_main_j;
import o1.mobile.softhanjolup.MainActivity;
import o1.mobile.softhanjolup.R;
import o1.mobile.softhanjolup.Volunteer.a_volun_main_j;

public class a_english_main_j extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_english_main_x);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_english_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_english_drawer_layout);
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
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

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
        // fragmentManager.beginTransaction().replace(R.id.course_flcontent, myFragment).commit();//수강화면 바꾸는 부분


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_english_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
