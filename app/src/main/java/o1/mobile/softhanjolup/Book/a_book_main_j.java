package o1.mobile.softhanjolup.Book;

import android.content.Intent;
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
import o1.mobile.softhanjolup.Course.a_course_main_j;
import o1.mobile.softhanjolup.Course.f_course_1st_j;
import o1.mobile.softhanjolup.Course.f_course_2nd_j;
import o1.mobile.softhanjolup.English.a_english_main_j;
import o1.mobile.softhanjolup.MainActivity;
import o1.mobile.softhanjolup.R;
import o1.mobile.softhanjolup.Volunteer.a_volun_main_j;

public class a_book_main_j extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    f_book_dept_j fragment1;
    f_book_uni_j fragment2;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_book_main_x);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_book_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragment1 = new f_book_dept_j();
        fragment2 = new f_book_uni_j();
        getSupportFragmentManager().beginTransaction().replace(R.id.containerBookTab, fragment1).commit();

        tabs = (TabLayout) findViewById(R.id.book_tabs);
        tabs.addTab(tabs.newTab().setText("dept"));
        tabs.addTab(tabs.newTab().setText("uni"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                int position = tab.getPosition();

                Fragment selected = null;
                if(position == 0)   selected = fragment1;
                else if(position == 1)   selected = fragment2;

                getSupportFragmentManager().beginTransaction().replace(R.id.containerBookTab, selected).commit();
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab){}
            @Override
            public void onTabReselected(TabLayout.Tab tab){}
        });

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

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //메뉴 ...버튼
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    */

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

        if (id == R.id.SideHome) {//홈 창으로 이동
            //fragmentClass = f_home_main_j.class;
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


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.a_book_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
