package com.example.karan.craps;

import android.app.AlertDialog;
import android.content.Context;
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

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Crap_Main extends AppCompatActivity implements OnClickListener
{
    String saveFileName = getResources().getString(R.string.saveFileName);
    private Craps_Interface model;
    private View rollButton;
    private View Buy;
    private View Home;
    private View settingsButton;
    private View MainTable;
    private View MiniTable;
    private TextView BuyTextView;
    private TextView TotalBetTextView;
    private TextView TotalWinsTextView;
    private Color_Finder color_finder;
    private View chip1;
    private View chip5;
    private View chip10;
    private View chip25;
    private View chip50;
    private View chip100;
    private View chip500;

    private int selectedChip;

    private ImageView Die1, Die2;


    /*Area for creating the onclick listeners and objects for use in the program*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        model = new Craps_Model();
        color_finder = new Color_Finder(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crap__main);
        Intent intent = getIntent();
        selectedChip = 0;

        rollButton = findViewById(R.id.rollButton);
        Home = findViewById(R.id.homeButton);
        Buy = findViewById(R.id.buyButton);
        settingsButton = findViewById(R.id.settingsButton);
        MainTable = findViewById(R.id.mainTable);
        MiniTable = findViewById(R.id.oddsTable);
        BuyTextView = findViewById(R.id.buyTextView);
        TotalBetTextView = findViewById(R.id.totalBetBox);
        TotalWinsTextView = findViewById(R.id.totalWinsBox);
        chip1=findViewById(R.id.chip1);
        chip5=findViewById(R.id.chip5);
        chip10=findViewById(R.id.chip10);
        chip25=findViewById(R.id.chip25);
        chip50=findViewById(R.id.chip50);
        chip100=findViewById(R.id.chip100);
        chip500=findViewById(R.id.chip500);


        Die1 = findViewById(R.id.die1);
        Die2 = findViewById(R.id.die2);

        Home.setOnClickListener(this);
        Buy.setOnClickListener(this);
        settingsButton.setOnClickListener(this);
        rollButton.setOnClickListener(this);
        chip1.setOnClickListener(this);
        chip5.setOnClickListener(this);
        chip10.setOnClickListener(this);
        chip25.setOnClickListener(this);
        chip50.setOnClickListener(this);
        chip100.setOnClickListener(this);
        chip500.setOnClickListener(this);

        MainTable.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return placeBet(v, event, true);
            }
        });


        MiniTable.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return placeBet(v, event, false);
            }
        });

        BuyTextView.setText(cashFormatter(model.getWallet()));


    }

    @Override
    public void onClick(View v)
    {
        if (v.getId()==R.id.homeButton)
        {
            Intent intent = new Intent(this, Homescreen.class);
                startActivity(intent);
        }
        if (v.getId()==R.id.buyButton)
        {
            //buy function button
            //insert microtransactions

            Toast.makeText(getApplicationContext(), "Gimme microtransaction",Toast.LENGTH_LONG).show();
        }
        if (v.getId()==R.id.rollButton)
        {
            updateTextViews(model.rollDice());
            //set dice to display current roll
            setDiceDisplay();

        }
        if (v.getId()==R.id.settingsButton)
        {
            //settings button, a radio button or drawer
        }
        if (v.getId()==R.id.chip1)
        {
            selectedChip=1;
        }
        if (v.getId()==R.id.chip5)
        {
            selectedChip=5;
        }
        if (v.getId()==R.id.chip10)
        {
            selectedChip=10;
        }
        if (v.getId()==R.id.chip25)
        {
            selectedChip=25;
        }
        if (v.getId()==R.id.chip50)
        {
            selectedChip=50;
        }
        if (v.getId()==R.id.chip100)
        {
            selectedChip=100;
        }
        if (v.getId()==R.id.chip500)
        {
            selectedChip=500;
        }






    }

    private  boolean placeBet(View v, MotionEvent event, boolean mainTable){
        if(selectedChip==0) {
            Toast.makeText(this, "Select a chip first", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int x, y;
            x = (int) event.getX();
            y = (int) event.getY();
            int touchColor;
            BetDestination dest;

            if (mainTable){
                touchColor = getHotspotColor(R.id.mainTableMap, x, y);
                dest = color_finder.findColorMainTable(touchColor);
            }
            else{
                touchColor = getHotspotColor(R.id.oddsTableMap, x, y);
                dest = color_finder.findColorMiniTable(touchColor);
            }
            if(dest!=null){
                String text;
                if (model.placeBet(dest, selectedChip)) {
                    text= selectedChip + " placed at " + dest.toString();
                }
                else{
                    text="Cannot bet at "+ dest.toString() +"at this time";
                }
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();

            }
            else{
                Toast.makeText(getApplicationContext(), "Not a valid position",Toast.LENGTH_LONG).show();
            }
        }
        updateTextViews(0);
        return true;
    }

    private void updateTextViews(double payout){
        TotalBetTextView.setText(cashFormatter(model.getTotalBet()));
        BuyTextView.setText(cashFormatter(model.getWallet()));
        TotalWinsTextView.setText(cashFormatter(payout));
    }

    private void setDiceDisplay(){

        int[] diceImages = {R.drawable.die1,R.drawable.die2,R.drawable.die3,R.drawable.die4,R.drawable.die5,R.drawable.die6};
        Die1.setImageResource(diceImages[model.getDie1()-1]);
        Die2.setImageResource(diceImages[model.getDie2()-1]);
    }

    private int getHotspotColor(int hotspotId, int x, int y) {
        ImageView img = (ImageView) findViewById (hotspotId);
        if (img == null) {
            Toast.makeText(getApplicationContext(), "No img found",Toast.LENGTH_LONG).show();
            return 0;
        } else {
            img.setDrawingCacheEnabled(true);
            Bitmap hotspots = Bitmap.createBitmap(img.getDrawingCache());
            if (hotspots == null) {
                Toast.makeText(getApplicationContext(), "Bitmap failure",Toast.LENGTH_LONG).show();
                return 0;
            } else {
                img.setDrawingCacheEnabled(false);
                return hotspots.getPixel(x, y);
            }
        }
    }

    private String cashFormatter(double value){
        String ret="$";
        ret+=String.format ("%.2f", value);
        return ret;
    }

    private boolean save(){
        try {
            FileOutputStream f; DataOutputStream d;
            f= new FileOutputStream(saveFileName);
            d=new DataOutputStream(f);
            d.writeDouble(model.getWallet());
            d.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean load(){
        try{
            FileOutputStream f; DataOutputStream d;
            f= new FileOutputStream(saveFileName);
            d=new DataOutputStream(f);
            model.setWallet(Double.parseDouble(d.toString()));
            d.close();
        }
        catch(Exception e){
        System.err.println(e.getMessage());
        return false;
    }
        return true;
    }

}
