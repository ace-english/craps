package com.example.karan.craps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/*
Copyright [2018] [Blackrain Technologies]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

import me.toptas.fancyshowcase.FancyShowCaseView;

public class Layout_Tutorial extends AppCompatActivity implements View.OnTouchListener {

    View[] views;
    Color_Finder color_finder;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_layout);
        Intent intent = getIntent();    //is this necessary?
        color_finder=new Color_Finder(this);

        views=new View[11];

        views[0]=findViewById(R.id.mainTable);
        views[1]=findViewById(R.id.diceBox);
        views[2]=findViewById(R.id.backButton);
        views[3]=findViewById(R.id.pointOff);
        views[4]=findViewById(R.id.oddsTable);
        views[5]=findViewById(R.id.totalBetBox);
        views[6]=findViewById(R.id.totalWinsBox);
        views[7]=findViewById(R.id.rollButton);
        views[8]=findViewById(R.id.chips);
        views[9]=findViewById(R.id.buyTextView);
        views[10]=findViewById(R.id.buyButton);




        for (int i=0; i<views.length; i++){
            views[i].setOnTouchListener(this);
        }

    }


    @Override
    public boolean onTouch(View v, MotionEvent me) {
        int id=v.getId();
        System.out.println("Clicked: "+id);
        if (id==R.id.backButton){
            Intent intent = new Intent(this, Tutorial_Menu.class);
            startActivity(intent);
        }
        if(id==R.id.diceBox){
            display(R.string.t_dice);
        }
        if (id==R.id.mainTable){
            int color = Color_Finder.getHotspotColor(R.id.mainTableMap, (int)me.getX(), (int)me.getY(), this);
            switch (color_finder.findColorMainTable(color)){
                case passLine:
                    display(R.string.t_passline);
                    break;
                case dontPassBar:
                    display(R.string.t_dontPass);
                    break;
                case sideBet4:
                case sideBet5:
                case sideBet6:
                case sideBet8:
                case sideBet9:
                case sideBet10:
                    display(R.string.t_sidebet);
                    break;
                case lay4:
                case lay5:
                case lay6:
                case lay8:
                case lay9:
                case lay10:
                    display(R.string.t_lay);
                    break;
                case buy4:
                case buy5:
                case buy6:
                case buy8:
                case buy9:
                case buy10:
                    display(R.string.t_buy);
                    break;
                case come:
                    display(R.string.t_come);
                    break;
                case dontCome:
                    display(R.string.t_dontCome);
                    break;
                case field:
                    display(R.string.t_field);
                    break;
                case big6:
                    display(R.string.t_big6);
                    break;
                case big8:
                    display(R.string.t_big8);
                    break;
            }
            
        }


        return true;
    }

    private void display(int id){
        new FancyShowCaseView.Builder(this)
                .title(getResources().getString(id))
                .build()
                .show();}
}
