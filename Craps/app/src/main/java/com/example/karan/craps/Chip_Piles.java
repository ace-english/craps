package com.example.karan.craps;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Chip_Piles {
    public static int yshift =5;

    private class Chip_Pile{
        int betValue;
        int xpos, ypos;
        LinkedList<ImageView> chips;
        Context context;

        Chip_Pile(int x, int y, int value, Context context){
            xpos=x;
            ypos=y;
            value=betValue;
            this.context=context;
            render();
        }

        public void addTo(int value){
            betValue+=value;
            render();
        }
        /*
            This function calculates the best display fr a bet of that quantity
            and places a series of image views on the table.
         */

        private boolean render(){
            if(context==null)
                return false;   //probably necessary?
            int tempValue=betValue;
            int[] values=context.getResources().getIntArray(R.array.chip_values);
            int[] ids=context.getResources().getIntArray(R.array.chip_ids);
            LinkedList<Integer> tempChips=new LinkedList<>();

            for(int i=values.length; i>0; i--) {
                int value=values[i];
                int id=ids[i];
                while (tempValue <= value) {
                    tempChips.add(id);
                    tempValue -= value;
                }
            }
            chips=new LinkedList<>();
            ImageView tempIV;
            int yscale=0;
            //chips now contains linked list of chip ids in optimal order
            for(int id: tempChips){
                tempIV=new ImageView(context);
                tempIV.setImageResource(id);
                tempIV.setX((float) xpos);
                tempIV.setY((float) ypos+yscale);
                yscale+=yshift;
            }
            return true;
        }

    }

    private Map<BetDestination, Chip_Pile> pileMap;

    Context context;

    Chip_Piles(Context context){
        pileMap = new TreeMap<BetDestination, Chip_Pile>();
        this.context=context;


    }

    public void move(BetDestination oldDest, BetDestination newDest){
        if(pileMap.containsKey(newDest)){
            pileMap.get(newDest).addTo(pileMap.get(oldDest).betValue);
        }
        else{
            //find new x and y
            //TODO
        }
        remove(oldDest);
    }

    public void add(int x, int y, int betValue, BetDestination betDest){
        Chip_Pile pile;
        if(pileMap.containsKey(betDest)) {
            pile=pileMap.get(betDest);
            pile.addTo(betValue);
        }
        else{
            pile=new Chip_Pile(x, y, betValue, context);
            pileMap.put(betDest, pile);
        }

        //pile.render(); //redundant?
    }

    public void remove(BetDestination betDest){
        pileMap.remove(betDest);
    }

    public boolean contains(BetDestination betDest){
        if (pileMap.containsKey(betDest))
            return true;
        return false;
    }

    public int payout(BetDestination betDest){
        int payout=0;
        if (pileMap.containsKey(betDest)){
            payout=pileMap.get(betDest).betValue;
            //remove chips from view
            remove(betDest);
        }
        return payout;
    }

    public int getTotalBet(){
        int total=0;
        for(Map.Entry<BetDestination,Chip_Pile> bet : pileMap.entrySet())
            total+=bet.getValue().betValue;
        return total;
    }


    public void printMap(){
        for(Map.Entry<BetDestination,Chip_Pile> bet : pileMap.entrySet())
        	System.out.println(bet.getKey()+" : "+bet.getValue().betValue);
    }






}
