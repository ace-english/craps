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

//        Numbers = findViewById(R.id.Numbers);
//        Roll_Rules = findViewById(R.id.Roll_Rules);
//        Come = findViewById(R.id.Come);
//        Dont_Come = findViewById(R.id.Dont_Come);
//        Chips = findViewById(R.id.Chips);
//        Field = findViewById(R.id.Field);
//        Dont_Pass = findViewById(R.id.Dont_Pass);
//        Dont_Pass_2 = findViewById(R.id.Dont_Pass_2);
//        Pass = findViewById(R.id.Pass);
//        Big = findViewById(R.id.Big);
//
//        Numbers.setOnClickListener(this);
//        Roll_Rules.setOnClickListener(this);
//        Come.setOnClickListener(this);
//        Dont_Come.setOnClickListener(this);
//        Chips.setOnClickListener(this);
//        Field.setOnClickListener(this);
//        Dont_Pass.setOnClickListener(this);
//        Dont_Pass_2.setOnClickListener(this);
//        Pass.setOnClickListener(this);
//        Big.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.backButton){
            Intent intent = new Intent(this, Tutorial.class);
            startActivity(intent);
        }
        if (v.getId()==R.id.Numbers){
            new FancyShowCaseView.Builder(this)
                    .title("Numbers is clicked")
                    .build()
                    .show();
        }
    }
}
