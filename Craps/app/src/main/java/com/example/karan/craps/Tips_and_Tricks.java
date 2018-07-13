package com.example.karan.craps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Tips_and_Tricks extends AppCompatActivity implements View.OnClickListener {


    TextView Title, MainText, Counter, Next, Prev;
    ImageButton Home;
    String[] titles = {"When to play the Field-Bet", "Don\'t Come Bet",
            "Place Two Come Bets along with Pass Line Bet", "Keep off from Proposition Bets", "Avoid Betting on Hard 4, Hard 10, Big 6 or Big 8"};

    int[] texts;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_tips_and_tricks);
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

        texts=new int[]{R.string.t_tip1, R.string.t_tip3, R.string.t_tip4, R.string.t_tip5, R.string.t_tip6};

        refreshViews();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.homeButton){
            Intent intent = new Intent(this, Tutorial_Menu.class);
            startActivity(intent);
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
