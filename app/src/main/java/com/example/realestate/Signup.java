package com.example.realestate;

import android.app.ProgressDialog;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity implements View.OnClickListener {

    Button signup;
    TextView loginText;
    EditText name,mail,pass;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        signup = findViewById(R.id.signupButton);
        loginText = findViewById(R.id.loginText);
        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        pass = findViewById(R.id.pass);

        signup.setOnClickListener(this);
        loginText.setOnClickListener(this);

    }

    private void registerUser(){

        String user = name.getText().toString().trim();
        String email = mail.getText().toString().trim();
        String password = pass.getText().toString().trim();

        if(user.isEmpty())
        {
            Toast.makeText(this,"Please Enter Name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(email.isEmpty())
        {
         Toast.makeText(this,"Please Enter Email",Toast.LENGTH_SHORT).show();
         return;
        }
        if(password.isEmpty())
        {
            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password)
        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    //user successfully registered.
                    finish();
                    Toast.makeText(getApplicationContext(),"Account Created",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                } else
                {
                    Toast.makeText(getApplicationContext(),"Unable to Create Account...",Toast.LENGTH_LONG).show();
                    progressDialog.cancel();
                }
            }
        })
        ;
    }

    @Override
    public void onClick(View v) {

        if(v == signup)
        {   registerUser();

        }

        if(v==loginText)
        {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }
    }
}
