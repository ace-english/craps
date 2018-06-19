package com.example.karan.craps;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.view.inputmethod.EditorInfo;
import android.content.Intent;
import android.app.Activity; //for new activity

public class Crap_Main extends AppCompatActivity implements OnClickListener
{
    private Craps_Interface model;
    private View rollButton;
    private View Buy;
    private View Home;
    private View settingsButton;
    private View Coin1;

    private ImageView Die1, Die2;


    /*Area for creating the onclick listeners and objects for use in the program*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        model = new Craps_Model();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crap__main);
        //Intent intent = getIntent(); for homescreen
        Craps_Model cm=new Craps_Model();

        rollButton=findViewById(R.id.rollButton);
        Home = findViewById(R.id.homeButton);
        Buy = findViewById(R.id.buyButton);
        settingsButton = findViewById(R.id.settingsButton);
        Coin1 = findViewById (R.id.chip1);

        Home.setOnClickListener(this);
        Buy.setOnClickListener(this);
        settingsButton.setOnClickListener(this);
        rollButton.setOnClickListener(this);
        Coin1.setOnClickListener(this);

        Die1 = findViewById(R.id.die1);
        Die2 = findViewById(R.id.die2);

    }

    @Override
    public void onClick(View v)
    {
        if (v.getId()==R.id.homeButton)
        {
            //Home Screen, Set new .java and reference intent to this.
		   /*For home screen : import android.content.Intent;
		   insert inside onClick, Intent intent = new Intent(this, [name].class); startActivity(intent);
		   insert inside onCreate get Intent intent = getIntent(); for homescreen */

            //for this function
		   /*Intent intent = new Intent(this, [home].class);
                startActivity(intent);*/
        }
        if (v.getId()==R.id.buyButton)
        {
            //buy function button
            //insert microtransactions
        }
        if (v.getId()==R.id.rollButton)
        {
            model.rollDice();
            //set dice to display current roll
            setDiceDisplay();

        }
        if (v.getId()==R.id.settingsButton)
        {
            //settings button, a radio button or drawer
        }
        if (v.getId()==R.id.chip1)
        {
            //enter chip value
        }
        if (v.getId()==R.id.mainTable){

        }






    }
    public void setDiceDisplay(){

        int[] diceImages = {R.drawable.die1,R.drawable.die2,R.drawable.die3,R.drawable.die4,R.drawable.die5,R.drawable.die6};
        Die1.setImageResource(diceImages[model.getDie1()-1]);
        Die2.setImageResource(diceImages[model.getDie2()-1]);
    }
}
