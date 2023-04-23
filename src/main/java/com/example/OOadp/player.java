package com.example.OOadp;

import java.util.*;

public class player {

    public int Amount;
    public int id;
    public boolean isPlaying;
    public String name;
    public ArrayList<card> Hand = new ArrayList<card>();
    public int HandValue;
    public String card1Suit;
    public String card2Suit;
    public String card1Value;
    public String card2Value;
    public boolean isturn; 

    player() {
        // this.name = name; PRIMARRY KEYS ONLY FOR CONSTRUCTORS 
        // this.Amount = 0;
        this.isPlaying = true;
    }
    // should send message to pokesh to tell that player has joined so that pokesh
    // can count number of players

    void addAmount(int amt) {

        this.Amount += amt;

    }
    public boolean isIsturn() {
        return isturn;
    }

    public void setIsturn(boolean isturn) {
        this.isturn = isturn;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void Set_cards(){

        this.card1Suit = Hand.get(0).suit  ;
        this.card2Suit = Hand.get(1).suit ;
        this.card1Value = Hand.get(0).value;
        this.card2Value = Hand.get(1).value;

    }
    void DisplayAmount() {
        System.out.println("Current amount with player " + name + " = " + Amount);
    }

    int Bet(int amt) {
        if (Amount == 0) {
            System.out.println("not enough in account for bet  has to fold ");
            fold();

            return 0;
        }
        if (amt < Amount) {
            this.Amount -= amt;
            return amt;
        } else {
            System.out.println("not enough in account for bet goin ALL IN ");
            // fold();
            amt = Amount;
            Amount = 0;
            return amt;
        }

    }

    void fold() {
        // player must quit the current round
        isPlaying = false;
        System.out.println("player : " + name + " has folded ");
    }

    void DisplayHand() {

        System.out.println("Current cards with " + name + " : \n");
        for (int i = 0; i < Hand.size(); i++) {
            System.out.println("Card " + i + " : " + Hand.get(i).value + " of " + Hand.get(i).suit + "\n");
        }
    }

}
