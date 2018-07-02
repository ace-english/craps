package com.example.karan.craps;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Chip_Piles {
    public static int yshift =5;
    public static int width =40;

    private class Chip_Pile{
        int betValue;
        BetDestination betDest;
        int xpos, ypos;
        LinkedList<ImageView> chips;
        Context context;
        Activity activity;
        FrameLayout layout;

        Chip_Pile(int x, int y, int value, BetDestination bd, Context context, Activity activity){
            xpos=x-(width/2);
            ypos=y-(width/2);
            betValue=value;
            betDest=bd;
            this.context=context;
            this.activity=activity;
            //determine which layout to use
            switch (betDest){
                case hard4:
                case hard6:
                case hard8:
                case hard10:
                case mini2:
                case mini3:
                case mini7:
                case mini11:
                case mini12:
                case mini_any:
                    layout=(FrameLayout) activity.findViewById(R.id.miniCrapsFrame);
                    break;
                default:
                    layout=(FrameLayout) activity.findViewById(R.id.mainTableFrame);
            }
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

        private void render() {
            if(chips!=null) {
                for (ImageView chip : chips) {
                    chip.setVisibility(View.INVISIBLE);
                }
            }
            int tempValue = betValue;
            int[] values;
            TypedArray ids;
            LinkedList<Integer> tempChips = new LinkedList<>();
            if (context == null) {
                //for the test app
                values=new int[]{1,5,10,25,50,100,500};

                //creates list of chips in largest possible orders
                for (int i = values.length - 1; i >= 0; i--) {
                    System.out.println("Checking "+i);
                    int value = values[i];
                    int id = values[i];
                    while (tempValue >= value) {
                        tempChips.add(id);
                        tempValue -= value;
                    }
                }

                System.out.println("Chips rendered on "+betDest+": "+tempChips.toString());

            } else {
                values = context.getResources().getIntArray(R.array.chip_values);
                ids=context.getResources().obtainTypedArray(R.array.chip_ids);


                //creates list of chips in largest possible orders
                for (int i = values.length - 1; i > 0; i--) {
                    int value = values[i];
                    int id = ids.getResourceId(i,-1);
                    while (tempValue >= value) {
                        tempChips.add(id);
                        tempValue -= value;
                    }
                }
                chips = new LinkedList<>();
                ImageView tempIV;
                int yscale = 0;
                //chips now contains linked list of chip ids in optimal order
                for (int tempChip:tempChips) {
                    tempIV = new ImageView(context);
                    tempIV.setBackgroundResource(tempChip);
                    tempIV.setX((float) xpos);
                    tempIV.setY((float) ypos + yscale);
                    tempIV.setLayoutParams(new ViewGroup.LayoutParams(50, 50));
                    chips.add(tempIV);
                    System.out.println("Added at "+xpos+","+(ypos+yscale));
                    yscale -= yshift;
                }


                for (ImageView IV : chips) {
                    layout.addView(IV);
                    IV.bringToFront();
                    System.out.println("Added chip.");
                }
            }
        }




    }

    private Map<BetDestination, Chip_Pile> pileMap;

    Context context; Activity activity;

    Chip_Piles(Context context, Activity activity){
        pileMap = new TreeMap<BetDestination, Chip_Pile>();
        this.context=context;
        this.activity=activity;


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
            pile=new Chip_Pile(x, y, betValue, betDest, context, activity);
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

    //for test
    public void printMap(){
        for(Map.Entry<BetDestination,Chip_Pile> bet : pileMap.entrySet())
        	System.out.println(bet.getKey()+" : "+bet.getValue().betValue);
    }






}
