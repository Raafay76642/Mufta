package com.example.mufta.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mufta.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class signup extends AppCompatActivity {

    private EditText inputEmail, inputPassword, name,inputCPassowrd;
    ProgressBar progressBar;
    FirebaseAuth auth;
    TextView skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Objects.requireNonNull(getSupportActionBar()).hide();
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(signup.this, MainActivity.class));
            finish();
        }
        Button btnSignUp = (Button) findViewById(R.id.signup);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        inputCPassowrd = findViewById(R.id.Cpassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        name = (EditText) findViewById(R.id.eded);
        skip = findViewById(R.id.skipp);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String email = inputEmail.getText().toString();
                String username = name.getText().toString();
                String password = inputPassword.getText().toString();
                String cpassword = inputCPassowrd.getText().toString();

                if (username.isEmpty()) {
                    name.setError("name can't be empty");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                   inputEmail.setError("Email can't be empty");
                        return;
                }
                if (!email.matches(emailPattern)) {
                    inputEmail.setError("Invalid email address");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    inputPassword.setError("Password can't be empty");
                    return;
                }

                if (password.length() < 6) {
                   inputPassword.setError("Password is too short");
                    return;
                }
                if (password.equals(cpassword)) {
                    Toast.makeText(signup.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.VISIBLE);
                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(signup.this, "User Signed Up", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(signup.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(signup.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });

            }
        });

    }

    public void signin(View view) {
        Intent intent = new Intent(signup.this, signin.class);
        startActivity(intent);
        finish();
    }
    public  void working(View view)
    {
        Toast.makeText(this, "We are working on it", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

    public void twitter(View view) {
        click();
    }

    public void facebook(View view) {
        click();
    }

    public void google(View view) {
        click();
    }

    public void click() {
        Toast.makeText(this, "We are working on it", Toast.LENGTH_SHORT).show();
    }
}