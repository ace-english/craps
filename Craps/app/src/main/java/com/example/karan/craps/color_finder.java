package com.example.karan.craps;

import android.R.color;
import android.content.Context;
import android.graphics.Color;

public class Color_Finder {
    
    private Context context;

    public Color_Finder(Context context){
        this.context=context;
        
    }

    private int tolerance=10;

    public BetDestination findColorMainTable(int clickedColor){
        if (clickedColor==0)
                return null;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_dontPassBar)))
            return BetDestination.dontPassBar;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_passline)))
            return BetDestination.passLine;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_fieldBet)))
            return BetDestination.field;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_big6)))
            return BetDestination.big6;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_big8)))
            return BetDestination.big8;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_dontcome)))
            return BetDestination.dontCome;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_come)))
            return BetDestination.come;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_four)))
            return BetDestination.sideBet4;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_five)))
            return BetDestination.sideBet5;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_six)))
            return BetDestination.sideBet6;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_eight)))
            return BetDestination.sideBet8;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_nine)))
            return BetDestination.sideBet9;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_ten)))
            return BetDestination.sideBet10;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_fourLay)))
            return BetDestination.lay4;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_fiveLay)))
            return BetDestination.lay5;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_sixLay)))
            return BetDestination.lay6;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_eightLay)))
            return BetDestination.lay8;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_nineLay)))
            return BetDestination.lay9;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_tenLay)))
            return BetDestination.lay10;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_fourBuy)))
            return BetDestination.buy4;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_fiveBuy)))
            return BetDestination.buy5;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_sixBuy)))
            return BetDestination.buy6;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_eightBuy)))
            return BetDestination.buy8;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_nineBuy)))
            return BetDestination.buy9;
        if(compare(clickedColor, context.getResources().getColor(R.color.t_tenBuy)))
            return BetDestination.buy10;

        return null;
    }

    public BetDestination findColorMiniTable(int clickedColor){
        if(compare(clickedColor, context.getResources().getColor(R.color.o_seven)))
            return BetDestination.mini7;
        if(compare(clickedColor, context.getResources().getColor(R.color.o_six)))
            return BetDestination.hard6;
        if(compare(clickedColor, context.getResources().getColor(R.color.o_ten)))
            return BetDestination.hard10;
        if(compare(clickedColor, context.getResources().getColor(R.color.o_eight)))
            return BetDestination.hard8;
        if(compare(clickedColor, context.getResources().getColor(R.color.o_four)))
            return BetDestination.hard4;
        if(compare(clickedColor, context.getResources().getColor(R.color.o_three)))
            return BetDestination.mini3;
        if(compare(clickedColor, context.getResources().getColor(R.color.o_two)))
            return BetDestination.mini2;
        if(compare(clickedColor, context.getResources().getColor(R.color.o_twelve)))
            return BetDestination.mini12;
        if(compare(clickedColor, context.getResources().getColor(R.color.o_eleven)))
            return BetDestination.mini11;
        if(compare(clickedColor, context.getResources().getColor(R.color.o_any)))
            return BetDestination.mini_any;

        return null;
    }

    public int findChip(int clickedColor){
        if(compare(clickedColor, context.getResources().getColor(R.color.c_1)))
            return 1;
        if(compare(clickedColor, context.getResources().getColor(R.color.c_5)))
            return 5;
        if(compare(clickedColor, context.getResources().getColor(R.color.c_10)))
            return 10;
        if(compare(clickedColor, context.getResources().getColor(R.color.c_25)))
            return 25;
        if(compare(clickedColor, context.getResources().getColor(R.color.c_50)))
            return 50;
        if(compare(clickedColor, context.getResources().getColor(R.color.c_100)))
            return 100;
        if(compare(clickedColor, context.getResources().getColor(R.color.c_500)))
            return 500;

        return 0;
    }

    public boolean compare(int color1, int color2){ //returns true if color1 is 'close enough' to color2
        if ((int) Math.abs (Color.red (color1) - Color.red (color2)) > tolerance )
            return false;
        if ((int) Math.abs (Color.green (color1) - Color.green (color2)) > tolerance )
            return false;
        if ((int) Math.abs (Color.blue (color1) - Color.blue (color2)) > tolerance )
            return false;
        return true;
    }
}
