package com.example.karan.craps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Layout_Tutorial extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_layout);
        Intent intent = getIntent();
    }



    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.backButton){
            Intent intent = new Intent(this, Tutorial.class);
            startActivity(intent);
        }
    }
}
