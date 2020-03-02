package com.example.ssauapp.suapp;

import android.app.FragmentManager;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.suapp.R;
import com.example.ssauapp.suapp.notes.NotesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MenuActivity extends AppCompatActivity {

    private Fragment selectedFragment = null;


    @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_menu);
       setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);



        BottomNavigationView mBottomNavigationItemView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
       mBottomNavigationItemView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               switch (item.getItemId()) {
                   case R.id.nav_user:
                       selectedFragment = UserFragment.newInstance();
                       break;
                   case R.id.nav_table:
                       selectedFragment = TableFragment.newInstance();
                       break;
                   case R.id.nav_notes:
                       selectedFragment = NotesFragment.newInstance();
                       break;
                   default:
                       selectedFragment = UserFragment.newInstance();
               }
               FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
               transaction.replace(R.id.fragment_container, selectedFragment);
               transaction.commit();
               return true;
           }
       });
       if(selectedFragment == null){
           FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
           transaction.replace(R.id.fragment_container, TableFragment.newInstance());
           transaction.commit();
       }

   }

}
