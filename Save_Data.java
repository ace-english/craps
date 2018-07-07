package com.example.karan.craps;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.content.SharedPreferences;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.util.Map;

class Save_Data extends AppCompatActivity
{

    private static final String MyPreference;
    SharedPreferences sharedPreferences;

    @Override
    protected void OnCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(MyPreference, getApplicationContext().MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Wallet);
        editor.commit();

    }
}
*/