package com.vvibu.todolist_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menampilkan halaman fragment yg pertamakali muncul
        getFragmentPage(new fragmentdashboard());


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                //menentukan fragment halaman yang akan tampil
                switch (item.getItemId()){
                    case R.id.dashboard:
                        fragment = new fragmentdashboard();
                        break;


                    case R.id.list:
                        fragment = new fragmentadd();
                        break;

                }
                return getFragmentPage(fragment);
            }
        });
    }
    //menampilkan halaman fragment
    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.page_container, fragment).commit();
            return  true;
        }
        return false;
    }
}