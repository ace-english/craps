package com.example.karan.craps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.view.inputmethod.EditorInfo;
import android.content.Intent;

public class Crap_Main extends AppCompatActivity implements OnClickListener
{
    /*initailizer Area for buttons, text view, booleans, edit text, etc*/
    private EditText
    private Button
    private TextView
    private Boolean
    private Integer

/*Area for creating the onclick listeners and objects for use in the program*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crap__main);
        /*Variable*/ = (EditText) findViewById(R.id./*variable*/)
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId()==R.id.Send)
        {
            if (/*code for if statement for changing to next page or creating popups. Change the variables to match next page name*/)
            {
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
            }
            else Verify.setText("Incorrect");
        }
}
