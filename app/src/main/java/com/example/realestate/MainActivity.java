package com.example.realestate;

import android.app.ProgressDialog;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mail,password;
    Button login;
    TextView signupText;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginButton);
        signupText = findViewById(R.id.signupText);
       progressDialog = new ProgressDialog(this);
       firebaseAuth = FirebaseAuth.getInstance();


        if(firebaseAuth.getCurrentUser() != null)
        {
            firebaseAuth.signOut();

        }

        login.setOnClickListener(this);
        signupText.setOnClickListener(this);

    }

    private void userLogin()
    {
        String email = mail.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(email.isEmpty())
        {
            Toast.makeText(this,"Please Enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(pass.isEmpty())
        {
            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Loading...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Successfully Logged In",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(),Welcome_Page.class);
                            startActivityForResult(i,1);
                        } else
                        {
                            Toast.makeText(getApplicationContext(),"Could not Sign In...",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {

        if(v == login)
        {
            userLogin();

        }

        if (v == signupText)
        {
            Intent i = new Intent(getApplicationContext(),Signup.class);
            startActivity(i);
        }

    }
}
