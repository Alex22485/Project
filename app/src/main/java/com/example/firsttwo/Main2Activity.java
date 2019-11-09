package com.example.firsttwo;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void startMain3Activity(View View){
        Intent a= new Intent(this,Main3Activity.class);
        startActivity(a);
    }
    public void startMain4Activity(View View){
        Intent b= new Intent(this,Main4Activity.class);
        startActivity(b);
    }
    public void startMain5Activity(View View){
        Intent c= new Intent (this,Main5Activity.class);
        startActivity(c);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        Intent intent= new Intent(this, Main7Activity.class);
        menu.findItem(R.id.about).setIntent(intent);
        return true;
    }
}

