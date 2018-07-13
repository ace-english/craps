package com.example.karan.craps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Tutorial_Basics extends AppCompatActivity implements View.OnClickListener {

    TextView Title, MainText, Counter, Next, Prev;
    ImageButton Home;
    String[] titles = {"Pass Line", "Point Bet", "Don\'t Pass", "Odds Bet", "Come Bet"};
    int[] texts;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_basics);
        Intent intent = getIntent();

        Title=findViewById(R.id.title);
        MainText=findViewById(R.id.explanation);
        Counter=findViewById(R.id.tracker);
        Next=findViewById(R.id.next);
        Prev=findViewById(R.id.prev);
        Home=findViewById(R.id.homeButton);
        index=0;

        Next.setClickable(true);
        Prev.setClickable(true);

        Home.setOnClickListener(this);
        Prev.setOnClickListener(this);
        Next.setOnClickListener(this);

        texts=new int[]{R.string.t_passline, R.string.t_point, R.string.t_dontpass, R.string.t_odds, R.string.t_come};

        refreshViews();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.homeButton){
            finish();
        }
        if(id==R.id.next){
            if(index<texts.length-1)
                index++;
            refreshViews();
        }
        if(id==R.id.prev){
            if(index>0)
                index--;
            refreshViews();
        }
    }

    private void refreshViews(){
        Title.setText(titles[index]);
        MainText.setText(Html.fromHtml(getResources().getString(texts[index])));
        Counter.setText((index+1)+" of "+texts.length);
    }
}
