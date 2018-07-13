package com.example.karan.craps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;

public class Tutorial_Menu extends AppCompatActivity implements OnClickListener
{
    View backButton;
    private Button tLayout;
    private Button tTricks;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_menu);
        Intent intent = getIntent();

        backButton = findViewById(R.id.homeButton);
        backButton.setOnClickListener(this);

        tLayout = findViewById(R.id.learnLayout);
        tLayout.setOnClickListener(this);

        tTricks = findViewById(R.id.tipsandtricks);
        tTricks.setOnClickListener(this);


        findViewById(R.id.basics).setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.learnLayout)
        {
            Intent intent = new Intent(this, Layout_Tutorial.class);
            startActivity(intent);
        }

        if (v.getId()==R.id.tipsandtricks)
        {
            Intent intent = new Intent(this, Tips_and_Tricks.class);
            startActivity(intent);
        }

        if(v.getId()==R.id.basics){
            Intent intent = new Intent(this, Tutorial_Basics.class);
            startActivity(intent);
        }

        if (v.getId()==R.id.homeButton)
        {
            Intent intent = new Intent(this, Homescreen.class);
            startActivity(intent);
        }
    }


}
