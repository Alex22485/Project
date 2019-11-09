package com.example.firsttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void dom(View view){
        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        Intent intent= new Intent(this, Main7Activity.class);
        menu.findItem(R.id.about).setIntent(intent);
        return true;
    }
}