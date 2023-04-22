package com.example.OOadp;

import java.util.*;

public class Table {

    ArrayList<card> table_Deck = new ArrayList<card>();
    int Pot;

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
