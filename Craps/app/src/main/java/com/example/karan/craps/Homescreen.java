package com.example.karan.craps;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;

public class Homescreen extends AppCompatActivity implements OnClickListener
{
    private Button Play;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        Intent intent = getIntent();

        Play = findViewById(R.id.playGame);

        Play.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.playGame) {
            Intent intent = new Intent(this, Crap_Main.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.tutorial)
        {
            Intent intent = new Intent (this, Tutorial_Menu.class);
            startActivity (intent);
        }
    }

}