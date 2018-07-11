package com.example.karan.craps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import me.toptas.fancyshowcase.FancyShowCaseView;

public class Layout_Tutorial extends AppCompatActivity implements View.OnClickListener {

    Button Numbers, Roll_Rules, Come, Dont_Come, Chips, Field, Dont_Pass, Pass, Big, Dont_Pass_2;
    FancyShowCaseView mFancyShowCaseView;

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
