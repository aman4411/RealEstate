package com.example.realestate;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class buy_property extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    AlertDialog.Builder builder;
    ImageView property1,property2,property3,property4,property5,property6,property7,property8;
    TextView loc1,loc2,loc3,loc4,loc5,loc6,loc7,loc8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_property);

        builder = new AlertDialog.Builder(this);
        property1 = findViewById(R.id.property1);
        property2 = findViewById(R.id.property2);
        property3 = findViewById(R.id.property3);
        property4 = findViewById(R.id.property4);
        property5 = findViewById(R.id.property5);
        property6 = findViewById(R.id.property6);
        property7 = findViewById(R.id.property7);
        property8 = findViewById(R.id.property8);
        property1.setOnClickListener(this);
        property2.setOnClickListener(this);
        property3.setOnClickListener(this);
        property4.setOnClickListener(this);
        property5.setOnClickListener(this);
        property6.setOnClickListener(this);
        property7.setOnClickListener(this);
        property8.setOnClickListener(this);
        loc1 = findViewById(R.id.loc1);
        loc1.setOnClickListener(this);
        loc2 = findViewById(R.id.loc2);
        loc2.setOnClickListener(this);
        loc3 = findViewById(R.id.loc3);
        loc3.setOnClickListener(this);
        loc4 = findViewById(R.id.loc4);
        loc4.setOnClickListener(this);
        loc5 = findViewById(R.id.loc5);
        loc5.setOnClickListener(this);
        loc6 = findViewById(R.id.loc6);
        loc6.setOnClickListener(this);
        loc7 = findViewById(R.id.loc7);
        loc7.setOnClickListener(this);
        loc8 = findViewById(R.id.loc8);
        loc8.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email_intent = new Intent(Intent.ACTION_SEND);
                email_intent.setData(Uri.parse("mailto: "));
                email_intent.setType("text/plain");
                email_intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"amanmehta4411@gmail.com"});
                email_intent.putExtra(Intent.EXTRA_SUBJECT, "Customer Support");
                startActivity(email_intent);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.buy_property, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
             Intent i = new Intent(getApplicationContext(),About.class);
             startActivity(i);
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
            finish();
            Intent i = new Intent(getApplicationContext(),Welcome_Page.class);
            startActivity(i);
        } else if (id == R.id.nav_buy) {
            finish();
            Intent i = new Intent(getApplicationContext(),buy_property.class);
            startActivity(i);

        } else if (id == R.id.nav_sell) {
            finish();
            Intent i = new Intent(getApplicationContext(),Sell_Property.class);
            startActivity(i);

        } else if (id == R.id.nav_rent) {
            finish();
            Intent i = new Intent(getApplicationContext(),Rent_property.class);
            startActivity(i);

        } else if (id == R.id.nav_share) {
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_SUBJECT, "Share Real Estate App Link");
            share.putExtra(Intent.EXTRA_TEXT, "Download Real Estate App and manage all your property dealings for free. App Link - https://drive.google.com/file/d/1H3Z0RWjsXx7B5H2-WHsVHvigTu4wCO_N/view?usp=sharing");
            startActivity(Intent.createChooser(share, "Share Link!"));


        } else if (id == R.id.nav_contact) {
            try
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://aman4411.github.io"));
                startActivity(intent);
            }catch (Exception e){
            }

        } else if (id == R.id.nav_logout){
            builder.setMessage("Do You want to close this App?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.setTitle("Alert");
            alert.show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        if(v==property1||v==property2||v==property3||v==property4||v==property5||v==property6||v==property7||v==property8)
        {
            Intent i = new Intent(getApplicationContext(),Gallery1.class);
            startActivity(i);
        }
        if(v==loc1)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",1);
            startActivity(i);
        }
        if(v==loc2)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",2);
            startActivity(i);
        }
        if(v==loc3)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",3);
            startActivity(i);
        }
        if(v==loc4)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",4);
            startActivity(i);
        }
        if(v==loc5)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",5);
            startActivity(i);
        }
        if(v==loc6)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",6);
            startActivity(i);
        }
        if(v==loc7)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",7);
            startActivity(i);
        }
        if(v==loc8)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",8);
            startActivity(i);
        }


    }
}
