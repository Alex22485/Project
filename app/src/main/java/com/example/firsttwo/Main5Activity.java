package com.example.firsttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }
    public void startMapsActivity(View view){
        Intent a = new Intent(this,MapsActivity.class);
        startActivity(a);

    }
    public void startMain6Activity (View view){
        Intent b = new Intent(this,Main6Activity.class);
        startActivity(b);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        Intent intent= new Intent(this, Main7Activity.class);
        menu.findItem(R.id.about).setIntent(intent);
        return true;
    }
}
