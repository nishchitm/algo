package com.example.nishu.algo1.main;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nishu.algo1.FragmentZones;
import com.example.nishu.algo1.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class index extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private CoordinatorLayout rootLayout;
    private GridView gridView;
    private Context context;
    private ArrayList arrayList;
    private TextView txtTimerDay, txtTimerHour, txtTimerMinute, txtTimerSecond;
    private TextView postTimer;
    private Handler handler;
    private Runnable runnable;


    public static String[] gridViewString = {
            "Literaria",
            "GLEE",
            "ABHIVYAKTI",
            "RYTHMRATZ",
            "SYMPHONY",
            "INCARNATION"
    };

    public static int[] gridViewImages = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(new CustomGridViewAdapter(gridViewString, gridViewImages, this));

        initInstances();

        txtTimerDay = (TextView) findViewById(R.id.txtTimerDays);
        txtTimerHour = (TextView) findViewById(R.id.txtTimerHours);
        txtTimerMinute = (TextView) findViewById(R.id.txtTimerMinutes);
        txtTimerSecond = (TextView) findViewById(R.id.txtTimerSeconds);

        postTimer = (TextView) findViewById(R.id.textposttime);
        countDownStart();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd");
// Please here set your event date//YYYY-MM-DD
                    Date futureDate = dateFormat.parse("2016-09-23");
                    Date postfutureDate = dateFormat.parse("2016-09-24");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        txtTimerDay.setText("" + String.format("%02d", days));
                        txtTimerHour.setText("" + String.format("%02d", hours));
                        txtTimerMinute.setText(""
                                + String.format("%02d", minutes));
                        txtTimerSecond.setText(""
                                + String.format("%02d", seconds));
                    }else if(currentDate.after(postfutureDate)){
                        postTimer.setVisibility(View.VISIBLE);
                        postTimer.setText("See you again next year !");
                    }
                    else {
                        textViewGone();
                        postTimer.setVisibility(View.VISIBLE);
                        postTimer.setText("Welcome To Algorythm");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }
    public void textViewGone() {
        findViewById(R.id.LinearLayout10).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout11).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout12).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout13).setVisibility(View.GONE);
        findViewById(R.id.text_timer_title).setVisibility(View.GONE);
    }

    public void initInstances(){
        rootLayout = (CoordinatorLayout) findViewById(R.id.android_coordinator_layout);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.index, menu);
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

        if (id == R.id.nav_home) {

            Toast.makeText(this,"home",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_about) {

            Toast.makeText(this,"about",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_zones) {

            Toast.makeText(this,"zones",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_attraction) {

            Toast.makeText(this,"attraction",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_schedule) {

            Toast.makeText(this,"schedule",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_guidelines) {

            Toast.makeText(this,"guidelines",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_accomodation) {

            Toast.makeText(this,"accommodation",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_reach) {

            Toast.makeText(this,"reach",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_contact) {

            Toast.makeText(this,"contact",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_sponsor) {

            Toast.makeText(this,"sponsor",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_developer) {

            Toast.makeText(this,"developer",Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
