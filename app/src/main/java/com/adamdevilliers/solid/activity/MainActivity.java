package com.adamdevilliers.solid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adamdevilliers.solid.R;
import com.adamdevilliers.solid.fragment.DisplayCitiesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.screen_content, new DisplayCitiesFragment())
                .commit();

    }
}
