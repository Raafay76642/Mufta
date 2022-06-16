package com.example.mufta.ui.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mufta.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mufta.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    FirebaseAuth firebaseAuth;

    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        firebaseAuth = FirebaseAuth.getInstance();

        prefs = getSharedPreferences("com.nimtrixstudio.mufta1.0", MODE_PRIVATE);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


// No internet Activity
      if(!isNetworkConnected())
      {
          final Dialog dialog = new Dialog(MainActivity.this);
          dialog.setContentView(R.layout.custom_dialouge_internet);
          dialog.setCancelable(false);
          Button dialogButton = (Button) dialog.findViewById(R.id.loginbtnalert);
          ImageView dialougebtnback = dialog.findViewById(R.id.btnback);
          Button dialogeButtonSignup = dialog.findViewById(R.id.signupbtnalert);
          // if button is clicked, close the custom dialog
          dialogButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  dialog.dismiss();
                  finish();
                  startActivity(getIntent());

              }
          });
          dialogeButtonSignup.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  dialog.dismiss();

              }
          });

          dialog.show();

      }



//        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
//            Intent intent = new Intent(MainActivity.this,signin.class);
//            startActivity(intent);
//        }
        }



    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


    @Override
    protected void onResume() {
        super.onResume();

        if (prefs.getBoolean("firstrun", true)) {
            startActivity(new Intent(MainActivity.this,signup.class));
            // using the following line to edit/commit prefs
            prefs.edit().putBoolean("firstrun", false).commit();
        }
    }


    }

