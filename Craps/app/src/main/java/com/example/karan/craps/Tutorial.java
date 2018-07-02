package com.example.karan.craps;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.view.inputmethod.EditorInfo;
import android.content.Intent;
import android.app.Activity;
import android.widget.Toast;

public class Tutorial extends AppCompatActivity implements OnClickListener
{
    View backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_menu);
        Intent intent = getIntent();


        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        Intent next = new Intent(this, Homescreen.class);
        startActivity(next);
    }


}
