package com.example.realestate;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.provider.MediaStore;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Sell_Property extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener {

        Button submitButton,captureButton;
        AlertDialog.Builder builder;
        EditText name,number,property_location,area,price;
        ImageView image;

       static final int REQUEST_IMAGE_CAPTURE =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell__property);

        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        property_location = findViewById(R.id.property_location);
        area = findViewById(R.id.area);
        price = findViewById(R.id.price);
        submitButton=findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);
        submitButton.setEnabled(false);
        builder = new AlertDialog.Builder(this);
        captureButton=findViewById(R.id.captureButton);
        captureButton.setOnClickListener(this);
        image = findViewById(R.id.property_image);

        if(!hasCamera())
        {
            captureButton.setEnabled(false);
        }

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
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
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
        getMenuInflater().inflate(R.menu.sell__property, menu);
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

        if(v==submitButton)
        {  String customer = name.getText().toString().trim();
           String no = number.getText().toString().trim();
           String loc = property_location.getText().toString().trim();
           String area_property = area.getText().toString().trim();
           String rate = price.getText().toString().trim();

            if(customer.isEmpty())
            {
                Toast.makeText(this,"Please Enter Name",Toast.LENGTH_SHORT).show();
                return;
            }
            if(no.isEmpty())
            {
                Toast.makeText(this,"Please Enter Phone Number",Toast.LENGTH_SHORT).show();
                return;
            }
            if(loc.isEmpty())
            {
                Toast.makeText(this,"Please Enter Property Location",Toast.LENGTH_SHORT).show();
                return;
            }
            if(area_property.isEmpty())
            {
                Toast.makeText(this,"Please Enter Area",Toast.LENGTH_SHORT).show();
                return;
            }
            if(rate.isEmpty())
            {
                Toast.makeText(this,"Please Enter Selling Price",Toast.LENGTH_SHORT).show();
                return;
            }

            finish();
            Intent i = new Intent(getApplicationContext(),Selling_info.class);
            startActivity(i);
        }

        if(v==captureButton)
        {
            launchCamera(captureButton);
        }

    }

    public boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void launchCamera(View view)
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            image.setImageBitmap(photo);
            submitButton.setEnabled(true);
            image.setVisibility(View.VISIBLE);
        }
    }
}
