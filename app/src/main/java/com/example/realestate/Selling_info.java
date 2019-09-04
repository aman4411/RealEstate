package com.example.realestate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Selling_info extends AppCompatActivity implements View.OnClickListener{

    Button homeButton,exitButton;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selling_info);

        homeButton=findViewById(R.id.homeButton);
        exitButton=findViewById(R.id.exitButton);
        builder = new AlertDialog.Builder(this);

        homeButton.setOnClickListener(this);
        exitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==homeButton)
        {
            Intent i = new Intent(getApplicationContext(),Welcome_Page.class);
            startActivity(i);
        }

        if(v==exitButton)
        {
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

    }
}
