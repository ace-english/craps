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
    private Button rollButton;
    private Button Buy;
	private Button Home;
	private Button settingsButton;
	private Button Coin1;


/*Area for creating the onclick listeners and objects for use in the program*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crap__main);

        Craps_Model cm=new Craps_Model();

        rollButton=findViewById(R.id.rollButton);
		Home = findViewById(R.id.homeButton);
		Buy = findViewById(R.id.buybotton);
        settingsButton = findViewById(R.id.settingsButton);
		Coin1 = findViewById (R.id.c);
		
		homeButton.setOnClickListener(this);
		Buy.setOnClickListener(this);
		settingsButton.setOnClickListener(this);
        rollButton.setOnClickListener(this);
		Coin1.setOnClickListener(this);

        



        /*
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        Bet = findViewById(R.id.BetAmount);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
    */

    }

    @Override
    public void onClick(View v)
    {
       if (v.getId()==R.id.Home)
       {
           //
       }
	   if (v.getId()==R.id.Buy)
	   {
		   
	   }
	   if (v.getId()==R.id.rollButton)
	   {
		   
	   }
	   if (v.getId()==R.id.settingsButton)
	   {
		   
	   }
	   if (v.getId()==R.id.Coin1)
	   {
		   
	   }
		   
	   
	   
	   
	   
	   
    }
}
