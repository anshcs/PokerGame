package com.example.OOadp;

import java.util.*;

public class Table {

    ArrayList<card> table_Deck = new ArrayList<card>();
    int Pot;
    int MinBet;
    String Flop1rank ;
    String Flop1suit;
    String Flop2rank ;
    String Flop2suit;
    String Flop3rank ;
    String Flop3suit;
    String turnrank;
    String turnsuit;
    String riverrank;
    String riversuit;

    
    public int getMinBet() {
        return MinBet;
    }

    public void setMinBet(int minBet) {
        MinBet = minBet;
    }

    public String getFlop1rank() {
        return Flop1rank;
    }

    public void setFlop1rank(String flop1rank) {
        Flop1rank = flop1rank;
    }

    public String getFlop1suit() {
        return Flop1suit;
    }

    public void setFlop1suit(String flop1suit) {
        Flop1suit = flop1suit;
    }

    public String getFlop2rank() {
        return Flop2rank;
    }

    public void setFlop2rank(String flop2rank) {
        Flop2rank = flop2rank;
    }

    public String getFlop2suit() {
        return Flop2suit;
    }

    public void setFlop2suit(String flop2suit) {
        Flop2suit = flop2suit;
    }

    public String getFlop3rank() {
        return Flop3rank;
    }

    public void setFlop3rank(String flop3rank) {
        Flop3rank = flop3rank;
    }

    public String getFlop3suit() {
        return Flop3suit;
    }

    public void setFlop3suit(String flop3suit) {
        Flop3suit = flop3suit;
    }

    public String getTurnrank() {
        return turnrank;
    }

    public void setTurnrank(String turnrank) {
        this.turnrank = turnrank;
    }

    public String getTurnsuit() {
        return turnsuit;
    }

    public void setTurnsuit(String turnsuit) {
        this.turnsuit = turnsuit;
    }

    public String getRiverrank() {
        return riverrank;
    }

    public void setRiverrank(String riverrank) {
        this.riverrank = riverrank;
    }

    public String getRiversuit() {
        return riversuit;
    }

    public void setRiversuit(String riversuit) {
        this.riversuit = riversuit;
    }

    


    Table(int Pot) {

        this.Pot = Pot;

    }

    void addPot(int amt) {
        Pot += amt;
    }

    int removePot() {
        int PotValue = Pot;
        Pot = 0;
        return PotValue;
    }

    void DisplayDeck() {

        System.out.println("Current cards on the table : \n");
        for (int i = 0; i < table_Deck.size(); i++) {
            System.out.println("Card" + i + " : " + table_Deck.get(i).value + " of " + table_Deck.get(i).suit + "\n");
        }
    }

    // void calculate

    // void addFlop(card c) {
    // if (table_Deck.Deck.size() < 3) {
    // table_Deck.AddCards(c);
    // }
    // }

    // void addTurn(card c) {
    // if (table_Deck.Deck.size() < 4) {
    // table_Deck.AddCards(c);
    // }
    // }

    // void addRiver(card c) {
    // if (table_Deck.Deck.size() < 5) {
    // table_Deck.AddCards(c);
    // }
    // }
}
