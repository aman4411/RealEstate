package com.example.realestate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome_Page extends AppCompatActivity implements View.OnClickListener{

    Button buy,sell,rent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__page);

        buy = findViewById(R.id.buy);
        sell = findViewById(R.id.sell);
        rent = findViewById(R.id.rent);

        sell.setOnClickListener(this);
        buy.setOnClickListener(this);
        rent.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
       if(v==buy)
       {
           Intent i = new Intent(getApplicationContext(),buy_property.class);
           startActivity(i);
       }
        if(v==sell)
        {
            Intent i = new Intent(getApplicationContext(), Sell_Property.class);
            startActivity(i);
        }
        if(v==rent)
        {
            Intent i = new Intent(getApplicationContext(), Rent_property.class);
            startActivity(i);
        }
    }
}
