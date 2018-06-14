package com.example.karan.craps;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Craps_Model CM= new Craps_Model();
        Scanner scanner = new Scanner(System.in);
        int choice;
        BetDestination betDest;
        int bet;
        System.out.print("Let's play.\n");
        while(true){
            System.out.println("Your wallet: "+CM.getWallet());
            CM.displayBets();
            System.out.println("Pick one:");
            System.out.println("1. Place a bet");
            System.out.println("2. Roll dice");
            choice=scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Where?");
                    displayBets();
                    choice = scanner.nextInt();
                    betDest = BetDestination.values()[choice];
                    System.out.println("How much?");
                    bet = scanner.nextInt();
                    if (CM.placeBet(betDest, bet))
                        System.out.println(bet + " placed on " + betDest);
                    break;
                case 2:
                    CM.rollDice();

            }

        }
    }

    public static void displayBets(){
        for(int i=0; i<BetDestination.values().length; i++){
            System.out.println(i+": "+BetDestination.values()[i]);
        }
    }

}
