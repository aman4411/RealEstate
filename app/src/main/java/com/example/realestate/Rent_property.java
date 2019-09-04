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

public class Rent_property extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    ImageView property1,property2,property3,property4,property5,property6,property7,property8;
    TextView rent1,rent2,rent3,rent4,rent5,rent6,rent7,rent8;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_property);

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
        rent1 = findViewById(R.id.rent1);
        rent1.setOnClickListener(this);
        rent2 = findViewById(R.id.rent2);
        rent2.setOnClickListener(this);
        rent3 = findViewById(R.id.rent3);
        rent3.setOnClickListener(this);
        rent4 = findViewById(R.id.rent4);
        rent4.setOnClickListener(this);
        rent5 = findViewById(R.id.rent5);
        rent5.setOnClickListener(this);
        rent6 = findViewById(R.id.rent6);
        rent6.setOnClickListener(this);
        rent7 = findViewById(R.id.rent7);
        rent7.setOnClickListener(this);
        rent8 = findViewById(R.id.rent8);
        rent8.setOnClickListener(this);

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
        getMenuInflater().inflate(R.menu.rent_property, menu);
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
            Intent i = new Intent(getApplicationContext(), Rent_property.class);
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

        } else if(id == R.id.nav_logout) {
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
        if(v==rent1)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",1);
            startActivity(i);
        }
        if(v==rent2)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",2);
            startActivity(i);
        }
        if(v==rent3)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",3);
            startActivity(i);
        }
        if(v==rent4)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",4);
            startActivity(i);
        }
        if(v==rent5)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",5);
            startActivity(i);
        }
        if(v==rent6)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",6);
            startActivity(i);
        }
        if(v==rent7)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",7);
            startActivity(i);
        }
        if(v==rent8)
        {
            Intent i = new Intent(getApplicationContext(),Location.class);
            i.putExtra("marker_no",8);
            startActivity(i);
        }
    }
}
