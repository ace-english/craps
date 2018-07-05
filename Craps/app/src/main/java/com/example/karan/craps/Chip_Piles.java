package com.example.karan.craps;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
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
            if(activity!=null) {
                switch (betDest) {
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
                        layout = (FrameLayout) activity.findViewById(R.id.miniCrapsFrame);
                        break;
                    default:
                        layout = (FrameLayout) activity.findViewById(R.id.mainTableFrame);
                }
            }
            render();
        }

        public void cleanup(){
            if(chips!=null) {
                for (ImageView chip : chips) {
                    if(chip!=null) {
                        ((ViewGroup) chip.getParent()).removeView(chip);
                        layout.removeView(chip);
                        chip.setVisibility(View.GONE);
                        chip.setImageResource(android.R.color.transparent);
                        System.out.println("Chips removed on " + betDest);
                    }
                }
            }

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
            cleanup();
            System.out.println("Rendering for "+betDest);
            int tempValue = betValue;
            int[] values;
            TypedArray ids;
            LinkedList<Integer> tempChips = new LinkedList<>();
            if (context == null) {
                //for the test app
                values=new int[]{1,5,10,25,50,100,500};

                //creates list of chips in largest possible orders
                for (int i = values.length - 1; i >= 0; i--) {
                    //System.out.println("Checking "+values[i]);
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
                for (int i = values.length - 1; i >= 0; i--) {
                    int value = values[i];
                    int id = ids.getResourceId(i,-1);
                    //System.out.println("Checking "+value+" : "+context.getResources().getString(id));
                    while (tempValue >= value) {
                        tempChips.add(id);
                        //System.out.println("Enqueued "+context.getResources().getString(id));
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
                    //System.out.println("Added "+context.getResources().getString(tempChip)+" at "+xpos+","+ypos);
                    yscale -= yshift;
                }


                for (ImageView IV : chips) {
                    layout.addView(IV);
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

    public void move(BetDestination oldDest, BetDestination newDest) throws Exception{
        if(pileMap.containsKey(newDest)){   //add to old dest
            pileMap.get(newDest).addTo(pileMap.get(oldDest).betValue);
        }
        else{   //create new dest
            if(activity==null)  //test drive
                add(0,0,pileMap.get(oldDest).betValue,newDest);
            else {      //find color of new location
                int color;
                switch (newDest){
                    case come4:
                    case dontCome4:
                        color=context.getResources().getColor(R.color.t_four);
                        break;
                    case come5:
                    case dontCome5:
                        color=context.getResources().getColor(R.color.t_five);
                        break;
                    case come6:
                    case dontCome6:
                        color=context.getResources().getColor(R.color.t_six);
                        break;
                    case come8:
                    case dontCome8:
                        color=context.getResources().getColor(R.color.t_eight);
                        break;
                    case come9:
                    case dontCome9:
                        color=context.getResources().getColor(R.color.t_nine);
                        break;
                    case come10:
                    case dontCome10:
                        color=context.getResources().getColor(R.color.t_ten);
                        break;
                    default:
                        throw new Exception("Invalid move attempted.");

                }
                int[] coords = Color_Finder.findColor(color, (ImageView) activity.findViewById(R.id.mainTableMap));
                if(coords==null)
                    throw new Exception("Unable to find coordinate.");
                add(coords[0], coords[1], pileMap.get(oldDest).betValue, newDest);
                System.out.println("Coords for "+newDest+": "+coords[0]+","+coords[1]);
            }
        }
        System.out.println("Moved "+pileMap.get(newDest).betValue +" from "+oldDest +" to "+newDest);
        remove(oldDest);
        pileMap.get(newDest).render();
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
        if(contains(betDest)) {
            pileMap.get(betDest).cleanup();
            pileMap.remove(betDest);
        }
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
            pileMap.get(betDest).cleanup();
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

    public void clearAll(){
        for(BetDestination dest : BetDestination.values()){
            remove(dest);
        }
    }

    //for test
    public void printMap(){
        for(Map.Entry<BetDestination,Chip_Pile> bet : pileMap.entrySet())
        	System.out.println(bet.getKey()+" : "+bet.getValue().betValue);
    }






}
