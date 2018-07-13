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

public class Layout_Tutorial extends AppCompatActivity implements View.OnTouchListener{

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
        views[2]=findViewById(R.id.wallet);
        views[3]=findViewById(R.id.pointOff);
        views[4]=findViewById(R.id.oddsTable);
        views[5]=findViewById(R.id.totalBetBox);
        views[6]=findViewById(R.id.totalWinsBox);
        views[7]=findViewById(R.id.rollButton);
        views[8]=findViewById(R.id.chips);

        views[9]=findViewById(R.id.buyButton);
        views[10]=findViewById(R.id.homeButton);


        findViewById(R.id.buyButton).setClickable(false);
        //findViewById(R.id.homeButton).setClickable(false);




        for (int i=0; i<views.length; i++){
            views[i].setOnTouchListener(this);
        }

    }


    @Override
    public boolean onTouch(View v, MotionEvent me) {
        int id=v.getId();
        if (id == R.id.homeButton) {
            finish();
        }
        if(id==R.id.diceBox){
            display(R.string.l_dice);
        }
        if (id==R.id.mainTable){
            try {
                int color = Color_Finder.getHotspotColor(R.id.mainTableMap, (int) me.getX(), (int) me.getY(), this);
                switch (color_finder.findColorMainTable(color)) {
                    case passLine:
                        display(R.string.l_passline);
                        break;
                    case dontPassBar:
                        display(R.string.l_dontPass);
                        break;
                    case sideBet4:
                    case sideBet5:
                    case sideBet6:
                    case sideBet8:
                    case sideBet9:
                    case sideBet10:
                        display(R.string.l_sidebet);
                        break;
                    case lay4:
                    case lay5:
                    case lay6:
                    case lay8:
                    case lay9:
                    case lay10:
                        display(R.string.l_lay);
                        break;
                    case buy4:
                    case buy5:
                    case buy6:
                    case buy8:
                    case buy9:
                    case buy10:
                        display(R.string.l_buy);
                        break;
                    case come:
                        display(R.string.l_come);
                        break;
                    case dontCome:
                        display(R.string.l_dontCome);
                        break;
                    case field:
                        display(R.string.l_field);
                        break;
                    case big6:
                        display(R.string.l_big6);
                        break;
                    case big8:
                        display(R.string.l_big8);
                        break;
                    default:
                        break;
                }
            }
            catch (Exception e){
                //consider it handled
            }

            
        }
        if(id==R.id.oddsTable){
            int color = Color_Finder.getHotspotColor(R.id.oddsTableMap, (int)me.getX(), (int)me.getY(), this);
            switch (color_finder.findColorMiniTable(color)){
                case hard4:
                case hard6:
                case hard8:
                case hard10:
                    display(R.string.l_hard);
                    break;
                case mini2:
                case mini3:
                case mini7:
                case mini11:
                case mini12:
                case mini_any:
                    display(R.string.l_mini);
                    break;
            }
        }
        if(id==R.id.chips){
            display(R.string.l_chips);
        }
        if(id==R.id.wallet||id==R.id.buyButton){
            display(R.string.l_wallet);
        }
        if(id==R.id.totalBetBox){
            display(R.string.l_bet);
        }
        if(id==R.id.totalWinsBox){
            display(R.string.l_wins);
        }
        if(id==R.id.pointOff){
            display(R.string.l_point);
        }



        return true;
    }

    private void display(int id){
        new FancyShowCaseView.Builder(this)
                .title(getResources().getString(id))
                .build()
                .show();
    }
}
